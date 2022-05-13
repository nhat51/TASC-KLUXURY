package com.example.kluxury.entity.dto;

import com.example.kluxury.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String username;

    private Set<String> roles;

    private Set<String> permission;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = new HashSet<>();
        this.permission = new HashSet<>();
        if (user.getRoles() != null && user.getRoles().size() > 0) {
            user.getRoles().forEach(role -> {
                this.roles.add(role.getName());
                role.getPermissions().forEach(privilege -> {
                    this.permission.add(privilege.getName());
                });
            });
        }

        if (user.getPermissions() != null && user.getPermissions().size() > 0) {
            user.getPermissions().forEach(privilege -> {
                this.permission.add(privilege.getName());
            });
        }
    }
}
