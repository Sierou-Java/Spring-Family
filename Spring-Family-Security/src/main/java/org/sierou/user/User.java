package org.sierou.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 此 User 类不是我们的数据库里的用户类,是用来安全服务的.
 * @Author 王洪悦.{javayue@yeah.net}
 * @Create 2017-08-15 下午2:58
 */
public class User implements UserDetails{

    private final String id;
    //帐号,这里是我数据库里的字段
    private final String account;
    //密码
    private final String password;
    //角色集合
    private final Collection<? extends GrantedAuthority> authorities;

    User(String id, String account, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.authorities = authorities;
    }

    //返回分配给用户的角色列表
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    //虽然我数据库里的字段是 `account`  ,这里还是要写成 `getUsername()`,因为是继承的接口
    @Override
    public String getUsername() {
        return account;
    }
    // 账户是否未过期
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 账户是否未锁定
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 密码是否未过期
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 账户是否激活
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
