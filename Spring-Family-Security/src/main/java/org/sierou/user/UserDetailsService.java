package org.sierou.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-15 下午2:57
 */
public interface UserDetailsService {

    // 这个接口只有一个方法 loadUserByUsername，是提供一种用 用户名 查询用户并返回的方法。
    UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException;
}
