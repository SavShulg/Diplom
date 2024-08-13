package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.dto.Add;

import java.util.List;
@Repository
public interface AddsRepository extends JpaRepository<Add, Long> {

    Add findAddsById(long id);

}
