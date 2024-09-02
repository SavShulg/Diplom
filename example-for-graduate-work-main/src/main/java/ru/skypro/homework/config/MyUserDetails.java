package ru.skypro.homework.config;


import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import ru.skypro.homework.bd.dto.UserDetailsDto;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.skypro.homework.bd.entity.User;
import ru.skypro.homework.repository.UserRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Реализация интерфейса UserDetails для Spring Security,
 * обеспечивающая детали аутентификации и авторизации пользователя.
 */

@Component
@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyUserDetails implements UserDetails {


    private UserDetailsDto UserDetailsDto; // DTO, содержащий данные пользователя

    public MyUserDetails(UserRepository userRepository) {
    }


    // Возвращает коллекцию прав (ролей) пользователя
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Optional.ofNullable(UserDetailsDto)
                .map(t -> UserDetailsDto.getRole())
                .map(role -> "ROLE_" + role) // Добавляет префикс "ROLE_" к роли пользователя
                .map(SimpleGrantedAuthority::new) // Создает объект SimpleGrantedAuthority
                .map(Collections::singleton) // Оборачивает в одиночную коллекцию
                .orElse(Collections.emptySet()); // Возвращает пустую коллекцию, если роль не найдена
    }

    // Возвращает пароль пользователя
    @Override
    public String getPassword() {
        return Optional.ofNullable(UserDetailsDto)
                .map(UserDetailsDto::getPassword)
                .orElse(null).toString();
    }

    // Возвращает имя пользователя (email)
    @Override
    public String getUsername() {
        return Optional.ofNullable(UserDetailsDto)
                .map(UserDetailsDto::getUsername)
                .orElse(null).toString();
    }

    // Возвращает true, если учетная запись пользователя не просрочена
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Возвращает true, если учетная запись пользователя не заблокирована
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Возвращает true, если учетные данные пользователя не просрочены
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Возвращает true, если учетная запись включена
    @Override
    public boolean isEnabled() {
        return true;
    }
}