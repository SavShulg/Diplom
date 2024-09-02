package ru.skypro.homework.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.bd.dto.NewPassword;
import ru.skypro.homework.bd.dto.UserDto;
import ru.skypro.homework.bd.muppas.UserMapper;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.impl.AuthServiceImpl;
import ru.skypro.homework.service.impl.UserServise;

@PreAuthorize(("ROLE_VIEWER"))
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServise userServise;
    private final UserRepository userRepository;
    private final AuthServiceImpl authService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserServise userServise, UserRepository userRepository, AuthServiceImpl authService) {
        this.userServise = userServise;
        this.userRepository = userRepository;
        this.authService = authService;
        this.userMapper = new UserMapper();
    }


    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        userServise.userDto(user);
        userRepository.save(userMapper.toEntity(user));
        return null;
    }

    @PutMapping
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto user) {
        userServise.editUser(user);
        userRepository.save(userMapper.toEntity(user));
        UserDto foundUser = userServise.editUser(user);
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long userId, @RequestBody UserDto user) {
        userServise.userDto(user);
        userRepository.save(userMapper.toEntity(user));
        userServise.findAddById(userId);
        userRepository.findUserById(userId);
        return null;
    }


    @GetMapping
    public ResponseEntity<UserDto> findUser(@RequestParam Long id) {
        userServise.findAddById(id);
        userRepository.findUserById(id);
        return ResponseEntity.ok(userMapper.toDto(userServise.findAddById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        userServise.deleteAdd(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/set_password")
    public NewPassword setPassword(@RequestBody @NotNull NewPassword newPassword) {
        NewPassword resultPassword = new NewPassword();
        userServise.changePassword(
                        newPassword.getCurrentPassword(),
                        newPassword.getNewPassword()
                );
        return resultPassword;
    }
}
