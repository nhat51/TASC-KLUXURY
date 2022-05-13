package com.example.kluxury.service.user;

import com.example.kluxury.entity.Permission;
import com.example.kluxury.entity.Role;
import com.example.kluxury.entity.User;
import com.example.kluxury.entity.dto.UserDto;
import com.example.kluxury.entity.dto.UserLogin;
import com.example.kluxury.exception.NotFoundException;
import com.example.kluxury.exception.RequestValidException;
import com.example.kluxury.repo.PermissionRepository;
import com.example.kluxury.repo.RoleRepository;
import com.example.kluxury.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto register(UserLogin userLogin) {
        if (userRepository.findByUsername(userLogin.getUsername()) != null) {
            throw new RequestValidException("Username already exists! Please choose another username.");
        }

        Role role = roleRepository.findRoleById(userLogin.getRoleId());

        if (role == null) throw new NotFoundException("Role is not found");

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User account = new User(userLogin.getUsername(),
                bCryptPasswordEncoder.encode(userLogin.getPassword()),
                roleSet);

        return new UserDto(userRepository.save(account));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto finByUserName(String name) {
        User user = userRepository.findByUsername(name);
        if (user == null) throw new NotFoundException("Account is not found");
        return new UserDto(user);
    }

    @Override
    public Page<User> findAll(int page, int pageSize) {
        if (page < 0 && pageSize < 0) {
            page = 1;
            pageSize = 10;
        }

        return userRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public User updatePermission(int accId, int permissionId) {
        Permission permission = permissionRepository.findById(permissionId).orElse(null);
        User acc = userRepository.findById(accId).orElse(null);
        if (permission == null) throw new NotFoundException("Privilege is not found");
        if (acc == null) throw new NotFoundException("Account is not found");
        Set<Permission> collection = acc.getPermissions();
        boolean existPrivilege = false;
        for (Permission p : collection) {
            if (p.getId()==(permission.getId())) {
                existPrivilege = true;
                break;
            }
        }
        if (existPrivilege) throw new RequestValidException("Permission is exist!");
        collection.add(permission);
        acc.setPermissions(collection);
        return userRepository.save(acc);
    }

    @Override
    public User delete(int accountId) {
        User account = userRepository.findById(accountId).orElse(null);
        if (account == null) throw new NotFoundException("Account is not found.");
        userRepository.deleteById(accountId);
        return account;
    }

    @Override
    public User findById(int id) {
        User account = userRepository.findById(id).orElse(null);
        if (account == null) throw new NotFoundException("Account is not found.");
        return account;
    }


}
