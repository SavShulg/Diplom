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

@Service
public class CustomUserDetailsManager implements UserDetailsManager {

    private final UserRepository userRepository;

    public CustomUserDetailsManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void createUser(UserDetails userDetails) {
        User user1 = new User();
        user1.setUsername(userDetails.getUsername());
        user1.setPassword(userDetails.getPassword());
        user1.setRole(Role.valueOf( userDetails.getAuthorities().stream().findFirst().orElseThrow().getAuthority()));
    }

    @Override
    public void updateUser(UserDetails user) {
        User user2 = new User();
        user2.setUsername(user.getUsername());
        user2.setPassword(user.getPassword());
        user2.setRole(Role.valueOf( user.getAuthorities().stream().findFirst().orElseThrow().getAuthority()));
    }

    @Override
    public void deleteUser(String username) {
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        Authentication aus =  SecurityContextHolder.getContext().getAuthentication();
        aus.getName();

        
        //дописать изменения
    }

    @Override
    public boolean userExists(String username) {
        return false;//изменить проверку
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
