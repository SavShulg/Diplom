package ru.skypro.homework.repository;

import ru.skypro.homework.dto.Register;

public interface AuthRepository {
    boolean login(String userName, String password);

    boolean register(Register register);
}
