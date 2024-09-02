package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.NewPassword;
import ru.skypro.homework.bd.dto.RegisterDto;
import ru.skypro.homework.bd.dto.UserDto;
import ru.skypro.homework.bd.muppas.RegisterMapper;
import ru.skypro.homework.bd.muppas.UserMapper;
import ru.skypro.homework.repository.AuthRepository;
import ru.skypro.homework.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthRepository {

    private final UserDetailsManager manager;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    private final UserMapper userMupp;

    public AuthServiceImpl(UserDetailsManager manager,
                           PasswordEncoder passwordEncoder, UserRepository userRepository, UserMapper userMupp) {
        this.manager = manager;
        this.encoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userMupp = userMupp;
    }


    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(RegisterDto register) {
        if (manager.userExists(register.getUsername())) {
            return false;
        }
        manager.createUser(
                User.builder()
                        .passwordEncoder(this.encoder::encode)
                        .username(register.getFirstName())
                        .username(register.getLastName())
                        .username(register.getPhone())
                        .password(register.getPassword())
                        .username(register.getUsername())
                        .roles(register.getRole().name())
                        .build());
        return true;
    }



}
