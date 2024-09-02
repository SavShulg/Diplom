package ru.skypro.homework.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.Role;
import ru.skypro.homework.bd.entity.User;
import ru.skypro.homework.repository.UserRepository;

import java.util.Objects;

@Service
public class CustomUserDetailsManager implements UserDetailsManager {

    private final UserRepository userRepository;

    public CustomUserDetailsManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void createUser(UserDetails userDetails) {
        User user1 = new User();
        user1.setEmail(userDetails.getUsername());
        user1.setPassword(userDetails.getPassword());

        Objects.equals(user1.getPhone(), user1.getPhone());
        user1.setRole(Role.valueOf(userDetails.getAuthorities().stream().findFirst().orElseThrow().getAuthority().replace("ROLE_", "")));
        userRepository.save(user1);
    }

    @Override
    public void updateUser(UserDetails user) {
        User user2 = new User();
        user2.setEmail(user.getUsername());
        user2.setPassword(user.getPassword());
        user2.setRole(Role.valueOf(user.getAuthorities().stream().findFirst().orElseThrow().getAuthority().replace("ROLE_", "")));
        userRepository.save(user2);
    }


    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(Long.valueOf(username));
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        Authentication aus = SecurityContextHolder.getContext().getAuthentication();
        aus.getName();
        User user3 = new User();
        user3.setPassword(user3.getPassword());
        userRepository.save(user3);

    }

    @Override
    public boolean userExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
