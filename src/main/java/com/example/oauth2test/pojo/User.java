package com.example.oauth2test.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity(name = "t_user")
public class User implements UserDetails{
    @Id
    private Integer id;
    /**
     *用户名
     */
    private String username;
    /**
     *密码
     */
    private String password;

    /**
     *是否启用：0不启用,1启用
     */
    private boolean enabled;

    /**
     *是否锁定
     */
    private boolean locked;
    /**
     * 角色列表
     */
    @Transient
    private List<Role> roleList;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleList.stream()
                .map(Role::getName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
