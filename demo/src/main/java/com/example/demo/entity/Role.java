package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements GrantedAuthority {
    @Id
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}