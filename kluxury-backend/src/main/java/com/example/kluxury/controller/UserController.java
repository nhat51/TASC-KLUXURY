package com.example.kluxury.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
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
import com.example.kluxury.response.RESTPagination;
import com.example.kluxury.response.RESTResponse;
import com.example.kluxury.service.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/manager/accounts")
public class UserController {

    @Autowired
    UserService accountService;

    @Autowired
    UserRepository accountRepository;

    @Autowired
    PermissionRepository privilegeRepository;

    @Autowired
    RoleRepository roleRepository;


    @RequestMapping(method = RequestMethod.POST, path = "register")
    public ResponseEntity<?> register( @RequestBody UserLogin form) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountService.register(form))
                .build(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/detail")
    @PreAuthorize("hasAuthority('ACCOUNT_READ')")
    public ResponseEntity<?> findById(@RequestParam(value = "id") int id) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountService.findById(id))
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_READ')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll(@RequestParam(name = "page", defaultValue = "-1") int page,
                                 @RequestParam(name = "pageSize", defaultValue = "-1") int pageSize

    ) {
        Page paging = accountService.findAll(page, pageSize);
        List<UserDto> accountDtoList = new ArrayList<>();
        for (Object acc : paging.getContent()) {
            User account = (User) acc;
            accountDtoList.add(new UserDto(account));
        }
        return new ResponseEntity<>(new RESTResponse.Success()
                .setPagination(new RESTPagination(paging.getNumber() + 1, paging.getSize(), paging.getTotalElements()))
                .addData(accountDtoList)
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_WRITE')")
    @RequestMapping(method = RequestMethod.PUT, path = "/role/update")
    public ResponseEntity<?> addRole(@RequestParam(value = "accountId") int accountId,
                                  @RequestParam(value = "roleId") int roleId) {
        Role role = roleRepository.findRoleById(roleId);
        User acc = accountRepository.findById(accountId).orElse(null);

        if (acc == null) throw new NotFoundException("Account is not found");
        if (role == null) throw new NotFoundException("Role is not found");

        acc.getRoles().forEach(roleAcc -> {
            if (roleAcc.getId() == (role.getId())) {
                throw new RequestValidException("Role already exists! Please enter another role");
            }
        });
        acc.getRoles().add(role);
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountRepository.save(acc))
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_WRITE')")
    @RequestMapping(method = RequestMethod.PUT, path = "/role/add")
    public ResponseEntity<?> addMultiRole(@RequestParam(name = "accountId") int accountId,
                                       @RequestParam(name = "roleIds") String roleIds
    ) {
        User acc = accountRepository.findById(accountId).orElse(null);
        if (acc == null) throw new NotFoundException("Account is not found");

        Set<String> setIds = new HashSet<>(Arrays.asList(roleIds.split(",")));
        Set<Role> roleSet = new HashSet<>();
        setIds.forEach(id -> {
            Role role = roleRepository.findById(Integer.valueOf(id)).orElse(null);
            if (role == null) throw new NotFoundException("Role is not found");
            roleSet.add(role);
        });
        acc.getRoles().addAll(roleSet);
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountRepository.save(acc))
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_WRITE')")
    @RequestMapping(method = RequestMethod.PUT, path = "/privilege/add")
    public ResponseEntity<?> addMultiPermission(@RequestParam(name = "accountId") int accountId,
                                             @RequestParam(name = "privilegeIds") String privilegeIds
    ) {
        User acc = accountRepository.findById(accountId).orElse(null);
        if (acc == null) throw new NotFoundException("Account is not found");

        Set<String> setIds = new HashSet<>(Arrays.asList(privilegeIds.split(",")));
        Set<Permission> permissionSet = new HashSet<>();
        setIds.forEach(id -> {
            Permission privilege = privilegeRepository.findById(Integer.valueOf(id)).orElse(null);
            if (privilege == null) throw new NotFoundException("Privilege is not found");
            permissionSet.add(privilege);
        });
        acc.getPermissions().addAll(permissionSet);
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountRepository.save(acc))
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_WRITE')")
    @RequestMapping(method = RequestMethod.DELETE, path = "role/delete")
    public ResponseEntity<?> deleteRoleInAccount(@RequestParam(value = "accountId") int accountId,
                                              @RequestParam(value = "roleId") int roleId) {

        Role role = roleRepository.findRoleById(roleId);
        User acc = accountRepository.findById(accountId).orElse(null);

        if (acc == null) throw new NotFoundException("Account is not found");
        if (role == null) throw new NotFoundException("Role is not found");

        if (!acc.getRoles().contains(role)) throw new NotFoundException("Role is not exist");
        acc.getRoles().remove(role);
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountRepository.save(acc))
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_WRITE')")
    @RequestMapping(method = RequestMethod.DELETE, path = "privilege/delete")
    public ResponseEntity<?> deletePermissionFromAccount(@RequestParam(value = "accountId") int accountId,
                                                      @RequestParam(value = "privilegeId") int privilegeId) {

        Permission privilege = privilegeRepository.findById(privilegeId).orElse(null);
        User acc = accountRepository.findById(accountId).orElse(null);

        if (acc == null) throw new NotFoundException("Account is not found");
        if (privilege == null) throw new NotFoundException("Privilege is not found");

        if (!acc.getPermissions().contains(privilege)) throw new NotFoundException("Privilege is not exist");
        acc.getPermissions().remove(privilege);
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(acc)
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_WRITE')")
    @RequestMapping(method = RequestMethod.PUT, path = "/privilege/update")
    public ResponseEntity<?> addPrivilege(@RequestParam(value = "accountId") int accountId,
                                       @RequestParam(value = "privilegeId") int privilegeId) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountService.updatePermission(accountId, privilegeId))
                .build(), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ACCOUNT_DELETE')")
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
    public ResponseEntity<?> delete(@RequestParam(value = "accountId") int accountId) {
        return new ResponseEntity<>(new RESTResponse.Success()
                .addData(accountService.delete(accountId))
                .build(), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorization = request.getHeader(AUTHORIZATION);
        if (authorization != null && authorization.startsWith("Bearer ")) {
            try {
                String refresh_token = authorization.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = accountService.getUserByUsername(username);

                String access_token = JWT.create().withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 24 * 360 * 100))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", (List) user.getRoles())
                        .sign(algorithm);

                HashMap<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                HashMap<String, String> errors = new HashMap<>();
                errors.put("error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), errors);
            }
        } else {
            throw new RuntimeException("Refresh token is missing.");
        }
    }
}
