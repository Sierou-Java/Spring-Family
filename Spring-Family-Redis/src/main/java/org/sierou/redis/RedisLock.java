package org.sierou.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author Sierou.{javayue@yeah.net}
 * @create 2018-04-06 下午10:31
 */
@Slf4j
public class RedisLock {

    //加锁超时时间，单位毫秒， 即：加锁时间内执行完操作，如果未完成会有并发现象
    private long lockTimeout;
    private RedisTemplate redisTemplate;
    public RedisLock(RedisTemplate redisTemplate, long timeout) {
        this.redisTemplate = redisTemplate;
        this.lockTimeout = timeout;
    }

    private boolean setNX(final String key, final String value) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    Boolean success = connection.setNX(serializer.serialize(key), serializer.serialize(value));
                    connection.close();
                    return success;
                }
            });
        } catch (Exception e) {
            log.error("setNX redis error, key : {}", key);
        }
        return obj != null ? (Boolean) obj : false;
    }

    private String get(final String key) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    byte[] data = connection.get(serializer.serialize(key));
                    connection.close();
                    if (data == null) {
                        return null;
                    }
                    return serializer.deserialize(data);
                }
            });
        } catch (Exception e) {
            log.error("get redis error, key : {}", key);
        }
        return obj != null ? obj.toString() : null;
    }

    private String getSet(final String key, final String value) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    byte[] data = connection.getSet(serializer.serialize(key), serializer.serialize(value));
                    connection.close();
                    return serializer.deserialize(data);
                }
            });
        } catch (Exception e) {
            log.error("getSet redis error, key : {}", key);
        }
        return obj != null ? obj.toString() : null;
    }

    private boolean del(final String lockKey) {
        try {
            redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    Long del = connection.del(serializer.serialize(lockKey));
                    connection.close();
                    return del;
                }
            });
            return true;
        } catch (Exception e) {
            log.error("del redis error, key : {}", lockKey);
        }
        return false;
    }

    private boolean expire(final String lockKey, final Long expireTime) {
        Object obj = null;
        try {
            obj =  redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    boolean bool = connection.expire(serializer.serialize(lockKey), expireTime);
                    connection.close();
                    return bool;
                }
            });
            return (Boolean)obj;
        } catch (Exception e) {
            log.error("expire redis error, key : {}", lockKey);
        }
        return false;
    }

    /**
     * 加锁
     * 取到锁加锁，取不到锁就返回
     *
     * @param lockKey
     * @param threadName
     * @return
     */
    public  synchronized  long  lock(String lockKey, String threadName) {
        log.info(threadName + "开始执行加锁");
        //锁时间
        Long lock_timeout = currtTimeForRedis() + lockTimeout * 1000 + 1;
        if (setNX(lockKey, String.valueOf(lock_timeout))) {
            //如果加锁成功
            log.info(threadName + "加锁成功+1");
            //设置超时时间，释放内存
            expire(lockKey, lockTimeout);
            System.out.println("lock_timeout = " + lock_timeout);
            return lock_timeout;
        } else {
            //获取redis里面的时间
            Object result = get(lockKey);
            Long currt_lock_timeout_str = result == null ? null : Long.parseLong(result.toString());
            //锁已经失效
            if (currt_lock_timeout_str != null && currt_lock_timeout_str < currtTimeForRedis()) {
                //判断是否为空，不为空时，说明已经失效，如果被其他线程设置了值，则第二个条件判断无法执行
                //获取上一个锁到期时间，并设置现在的锁到期时间
                Long old_lock_timeout_Str = Long.valueOf(getSet(lockKey, String.valueOf(lock_timeout)));
                if (old_lock_timeout_Str != null && old_lock_timeout_Str.equals(currt_lock_timeout_str)) {
                    //多线程运行时，多个线程签好都到了这里，但只有一个线程的设置值和当前值相同，它才有权利获取锁
                    log.info(threadName + "加锁成功+2");
                    //设置超时间，释放内存
                    expire(lockKey, lockTimeout);
                    //返回加锁时间
                    return lock_timeout;
                }
            }
        }
        return -1;
    }
    /**
     * 解锁
     *
     * @param lockKey
     * @param lockValue
     * @param threadName
     */
    public synchronized void unlock(String lockKey, long lockValue, String threadName) {
        log.info(threadName + "执行解锁==========");//正常直接删除 如果异常关闭判断加锁会判断过期时间
        //获取redis中设置的时间
        String result = get(lockKey);
        log.info("获取到的locakValue为:[{}],当前线程为:[{}]", result, threadName);
        Long currt_lock_timeout_str = result == null ? null : Long.valueOf(result);
        //如果是加锁者，则删除锁， 如果不是，则等待自动过期，重新竞争加锁
        if (currt_lock_timeout_str != null && currt_lock_timeout_str == lockValue) {
            del(lockKey);
            log.info(threadName + "解锁成功------------------");
        }
    }
    /**
     * 多服务器集群，使用下面的方法，代替System.currentTimeMillis()，获取redis时间，避免多服务的时间不一致问题！！！
     *
     * @return
     */
    public long currtTimeForRedis() {
        Object obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.time();
            }
        });
        return obj == null ? -1 : Long.parseLong(obj.toString());
    }
}
