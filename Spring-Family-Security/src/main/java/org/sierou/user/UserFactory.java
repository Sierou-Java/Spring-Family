package org.sierou.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-15 下午3:03
 */
final class UserFactory {
    private UserFactory() {
    }

    static User create(User user) {

        return new User(
//                user.getId(),
//                user.getAccount(),
//                user.getPassword(),
//                mapToGrantedAuthorities(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                null, null, null, null
        );
    }

    //将与用户类一对多的角色类的名称集合转换为 GrantedAuthority 集合
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
