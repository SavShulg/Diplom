package ru.skypro.homework.bd.muppas;

import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.LoginDto;
import ru.skypro.homework.bd.entity.Login;
@Service
public class LoginMapper {
    public LoginDto toDto(Login login) {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(login.getUsername());
        loginDto.setPassword(login.getPassword());
        loginDto.setId(login.getId());
        return loginDto;
    }

    public Login toEntity(LoginDto loginDto) {
        Login login = new Login();
        login.setUsername(loginDto.getUsername());
        login.setPassword(loginDto.getPassword());
        login.setId(loginDto.getId());
        return login;
    }
}
