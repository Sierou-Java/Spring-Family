package org.family.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-09-24 下午9:42
 */
public class SpringFamilySingleJob implements SimpleJob{

    private static int a = 0;
    /**
     * 执行作业.
     *
     * @param shardingContext 分片上下文
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("分片总数：" + shardingContext.getShardingTotalCount());
        System.out.println("分片：" + shardingContext.getShardingItem());
        System.out.println("参数shardingParameter：" + shardingContext.getShardingParameter());
        System.out.println("参数getJobParameter" + shardingContext.getJobParameter());
        a++;
        System.out.println("a = " + a);
        System.out.println("=========================");

    }
}
