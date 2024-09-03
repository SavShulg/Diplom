package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.NewPassword;
import ru.skypro.homework.bd.dto.RegisterDto;
import ru.skypro.homework.bd.dto.UserDto;
import ru.skypro.homework.bd.entity.User;
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



    public AuthServiceImpl(UserDetailsManager manager,
                           PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.manager = manager;
        this.encoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        var user = userRepository.findByUserName(userName);
        return encoder.matches(password, user.getPassword());
    }

    @Override
    public boolean register(RegisterDto register) {
        if (manager.userExists(register.getUsername())) {
            return false;
        }
        User user = new User();
        user.setUserName(register.getUsername());
        user.setRole(register.getRole());
        user.setPassword(encoder.encode(register.getPassword()));
        user.setFirstName(register.getFirstName());
        user.setPhone(register.getPhone());
        user.setLastName(register.getLastName());
        userRepository.save(user);
        return true;
    }



}
