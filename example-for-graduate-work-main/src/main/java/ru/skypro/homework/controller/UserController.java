package ru.skypro.homework.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.bd.dto.UserDto;
import ru.skypro.homework.bd.entity.NewPassword;
import ru.skypro.homework.service.impl.AuthServiceImpl;
import ru.skypro.homework.service.impl.UserServise;
@PreAuthorize(("ROLE_VIEWER"))
@RestController
@RequestMapping("/User")
public class UserController {
    private final UserServise userServise;
    private final AuthServiceImpl authService;

    @Autowired
    public UserController(UserServise userServise, AuthServiceImpl authService) {
        this.userServise = userServise;
        this.authService = authService;

    }

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(new UserDto());
    }

    @PutMapping
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto user) {
        UserDto foundUser = userServise.editUser(user);
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundUser);
    }

    @PutMapping( "/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long UserId, @RequestBody UserDto user) {
        return ResponseEntity.ok(new UserDto());
    }

    @GetMapping
    public ResponseEntity findUser(@RequestParam(required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok(userServise.findAddById(id));
        }
        return ResponseEntity.ok(userServise.getAllAdd());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        userServise.deleteAdd(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/set_password")
    public NewPassword setPassword(@RequestBody @NotNull NewPassword newPassword, @NotNull Authentication authentication) {
        NewPassword resultPassword = new NewPassword();
        authService.changePassword(
                        authentication.getName(),
                        newPassword.getCurrentPassword(),
                        newPassword.getNewPassword()
                )
                .ifPresent(resultPassword::setCurrentPassword);
        return resultPassword;
    }
}
