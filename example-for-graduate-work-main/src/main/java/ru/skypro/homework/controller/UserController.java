package ru.skypro.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.bd.dto.UserDto;
import ru.skypro.homework.service.impl.UserServise;

@RestController
@RequestMapping("/User")
public class UserController {
    private final UserServise userServise;

    @Autowired
    public UserController(UserServise userServise) {
        this.userServise = userServise;

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

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return ResponseEntity.ok(new UserDto());
    }

    @GetMapping
    public ResponseEntity findUser(@RequestParam(required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok(userServise.findAddById(id));
        }
        return ResponseEntity.ok(userServise.getAllAdd());
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userServise.deleteAdd(id);
        return ResponseEntity.ok().build();
    }
}
