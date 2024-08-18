package ru.skypro.homework.bd.muppas;

import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.RegisterDto;
import ru.skypro.homework.bd.entity.Register;

@Service
public class RegisterMupp {
    public RegisterDto toDto(Register register) {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername(register.getUsername());
        registerDto.setFirstName(register.getFirstName());
        registerDto.setLastName(register.getLastName());
        registerDto.setRole(register.getRole());
        registerDto.setPassword(register.getPassword());
        registerDto.setId(register.getId());
        registerDto.setPhone(register.getPhone());
        return registerDto;
    }
    public Register toEntity(RegisterDto registerDto) {
        Register register = new Register();
        register.setUsername(registerDto.getUsername());
        register.setFirstName(registerDto.getFirstName());
        register.setLastName(registerDto.getLastName());
        register.setRole(registerDto.getRole());
        register.setPassword(registerDto.getPassword());
        register.setId(registerDto.getId());
        register.setPhone(registerDto.getPhone());
        return register;
    }
}
