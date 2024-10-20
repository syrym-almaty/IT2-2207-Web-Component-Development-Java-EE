package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles; // возвращаем роли как авторитеты
    }

    @Override
    public String getPassword() {
        return password; // возвращаем реальный пароль
    }

    @Override
    public String getUsername() {
        return username; // возвращаем имя пользователя
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // реализация метода UserDetails
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // реализация метода UserDetails
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // реализация метода UserDetails
    }

    @Override
    public boolean isEnabled() {
        return enabled; // возвращаем статус включения
    }

    // Остальные методы
}
