package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.bd.dto.AddDto;
import ru.skypro.homework.bd.entity.Add;

@Repository
public interface AddsRepository extends JpaRepository<Add, Long> {

    Add findAddsById(long id);



}
