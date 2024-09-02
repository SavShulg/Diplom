package ru.skypro.homework.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.NewPassword;
import ru.skypro.homework.bd.dto.UserDto;
import ru.skypro.homework.bd.entity.User;
import ru.skypro.homework.bd.muppas.UserMapper;
import ru.skypro.homework.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServise {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMupp;
    private final UserDetailsManager manager;
    public UserServise(UserRepository userRepository, PasswordEncoder encoder, UserMapper userMupp, UserDetailsManager manager) {
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
        this.userMupp = userMupp;
        this.manager = manager;
    }


    public UserDto userDto(UserDto user) {
        var entity = userMupp.toEntity(user);
        var save = userRepository.save(entity);
        return userMupp.toDto(save);
    }

    public UserDto editUser(UserDto user) {
        var entity = userMupp.toEntity(user);
        var edit = userRepository.save(entity);
        return userMupp.toDto(edit);
    }

    // Разрешить доступ только владельцу записи
    @PreAuthorize("#userId == authentication.principal.id")
    public List<User> getAllAdd() {
        return userRepository.findAll();
    }

    public User findAddById(long id) {
        return userRepository.findUserById(id);
    }

    // Только пользователи с ролью ADMIN и владелец записи
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    public void deleteAdd(long id) {
        userRepository.deleteById(id);
    }

    public void changePassword( String currentPassword, String newPassword) {
        manager.changePassword(currentPassword, newPassword);
    }

}


