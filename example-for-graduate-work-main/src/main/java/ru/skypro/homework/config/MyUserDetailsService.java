package ru.skypro.homework.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.entity.User;
import ru.skypro.homework.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private final MyUserDetails myUserDetails;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return myUserDetails;
    }
}