package ru.skypro.homework.repository;

import ru.skypro.homework.bd.dto.RegisterDto;

public interface AuthRepository {
    boolean login(String userName, String password);

    boolean register(RegisterDto register);
}
