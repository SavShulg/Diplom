package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ru.skypro.homework.bd.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);

    User findByUserName(String userName);


    @Query(value = "SELECT * FROM Users WHERE Users.username = ?1", nativeQuery = true)
    User findUserByUserName(String username);

}