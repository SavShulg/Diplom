package ru.skypro.homework.repository;

import ru.skypro.homework.bd.dto.RegisterDto;
import ru.skypro.homework.service.impl.AuthServiceImpl;

import java.util.Optional;

public interface AuthRepository {
    boolean login(String userName, String password);

    boolean register(RegisterDto register);


}
