package ru.skypro.homework.bd.muppas;

import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.Role;
import ru.skypro.homework.bd.dto.UserDto;
import ru.skypro.homework.bd.entity.User;
@Service
public class UserMapper {
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setRole(Role.of(user.getRole()));
        return userDto;
    }

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setId(user.getId());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setRole(Role.of(userDto.getRole()));
        return user;
    }
}
