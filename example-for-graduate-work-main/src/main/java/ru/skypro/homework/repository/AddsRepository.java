package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.bd.dto.AddDto;
import ru.skypro.homework.bd.entity.Add;
import ru.skypro.homework.bd.entity.User;

import java.util.List;

@Repository
public interface AddsRepository extends JpaRepository<Add, Long> {

    Add findAddsById(long id);

    List<Add> findByUser(User user);
    @Modifying
    @Query(value = "DELETE FROM add a WHERE a.image = :image", nativeQuery = true)
    void delete(@Param("image") long image);


}
