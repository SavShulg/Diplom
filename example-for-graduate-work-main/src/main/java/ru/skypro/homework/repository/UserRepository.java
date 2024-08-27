package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.skypro.homework.bd.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);

    User findByUsername(String username);

    User findByPassword(String password);
}