package com.example.demo.Entity;

import jakarta.persistence.Entity;

@Entity
public class User implements UserDetails {
    @Id
    private String username;
    private String password;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    // Реализуйте методы интерфейса UserDetails
}

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String name;

    // Реализуйте методы интерфейса GrantedAuthority
}
