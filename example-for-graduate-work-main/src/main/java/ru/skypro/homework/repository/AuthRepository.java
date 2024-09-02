package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.bd.dto.NewPassword;
import ru.skypro.homework.bd.dto.RegisterDto;
import ru.skypro.homework.bd.entity.User;
import ru.skypro.homework.service.impl.AuthServiceImpl;

import java.util.Optional;

public interface AuthRepository {
    boolean login(String userName, String password);

    boolean register(RegisterDto register);

}
