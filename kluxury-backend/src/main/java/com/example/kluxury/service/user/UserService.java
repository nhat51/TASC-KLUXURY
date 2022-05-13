package com.example.kluxury.service.user;

import com.example.kluxury.entity.User;
import com.example.kluxury.entity.dto.UserDto;
import com.example.kluxury.entity.dto.UserLogin;
import org.springframework.data.domain.Page;

public interface UserService {
    UserDto register(UserLogin userLogin);

    User getUserByUsername(String username);

    UserDto finByUserName(String name);

    Page<User> findAll(int page, int pageSize);

    User updatePermission(int accId, int privilegeId);

    User delete(int accountId);

    User findById(int id);
}
