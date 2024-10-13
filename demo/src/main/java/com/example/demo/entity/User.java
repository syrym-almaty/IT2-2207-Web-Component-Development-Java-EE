package com.example.demo.entity;

import com.example.demo.entity.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private boolean enabled;

//    @ManyToMany(fetch = FetchType.EAGER)
////    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

}