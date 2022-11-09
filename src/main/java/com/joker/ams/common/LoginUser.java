package com.joker.ams.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.joker.ams.entity.AmsUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser implements UserDetails {
    private AmsUser user;

    //数据库查出来的
    List<String> permissions;
    //不序列化
    @JSONField(serialize = false)
    List<SimpleGrantedAuthority> authorities;

    public LoginUser(AmsUser user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    //权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) {
            return authorities;
        }
        //低级写法
        /* List<SimpleGrantedAuthority> list=new ArrayList<>();
            for (String permission : permissions) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(permission);
                list.add(simpleGrantedAuthority);
            }*/
        //高级写法
        authorities = permissions.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
