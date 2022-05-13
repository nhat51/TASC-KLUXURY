package com.example.kluxury.configSecurity;

import com.example.kluxury.entity.Permission;
import com.example.kluxury.entity.Role;
import com.example.kluxury.entity.User;
import com.example.kluxury.exception.NotFoundException;
import com.example.kluxury.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
@Transactional
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new NotFoundException("Account not found");
        return new org.springframework.security.core.userdetails.User(user.getUsername()
                ,user.getPassword()
                ,getAuthorities(user.getRoles(),user.getPermissions()));
    }

    private Set<SimpleGrantedAuthority> getAuthorities(Collection<Role> roles, Set<Permission> permissions) {

        return getGrantedAuthorities(getPrivileges(roles, permissions));
    }

    private Set<String> getPrivileges(Collection<Role> roles, Set<Permission> permissions) {

        Set<String> privileges = new HashSet<>();
        Set<Permission> collection = new HashSet<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPermissions());
        }
        for (Permission item : collection) {
            privileges.add(item.getName());
        }
        for (Permission item : permissions) {
            privileges.add(item.getName());
        }
        return privileges;
    }

    private Set<SimpleGrantedAuthority> getGrantedAuthorities(Set<String> privileges) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
