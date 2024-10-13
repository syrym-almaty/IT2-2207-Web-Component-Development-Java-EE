package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
    @Id
    private String name;

    public String getAuthority() {
        return "";
    }

    // Implement methods from GrantedAuthority interface
}
