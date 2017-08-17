package org.sierou.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-15 下午3:00
 */
public class UserDetailsServiceImpl implements UserDetailsService{

    // jpa
//    @Autowired
//    private UserRepository userRepository;

    /**
     * 提供一种从用户名可以查到用户并返回的方法
     * @param account 帐号
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        // 这里是数据库里的用户类
//        User user = userRepository.findByAccount(account);
//        ArrayList<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
//        list.add("admin");
        User user = new User("1", "admin", "admin", null);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("没有该用户 '%s'.", account));
        } else {
            //这里返回上面继承了 UserDetails  接口的用户类,为了简单我们写个工厂类
            return UserFactory.create(user);
        }
    }
}
