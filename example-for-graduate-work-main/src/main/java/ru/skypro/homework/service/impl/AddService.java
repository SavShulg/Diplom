package ru.skypro.homework.service.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


import ru.skypro.homework.bd.dto.AddDto;
import ru.skypro.homework.bd.entity.Add;
import ru.skypro.homework.bd.entity.Image;
import ru.skypro.homework.bd.muppas.AddMapper;
import ru.skypro.homework.repository.AddsRepository;
import ru.skypro.homework.repository.ImageRepository;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class AddService  {

    private final AddsRepository addsRepository;



    private final AddMapper addMap;

    public AddService(AddsRepository addsRepository, AddMapper addMap) {
        this.addsRepository = addsRepository;
        this.addMap = addMap;
    }


    public AddDto addingAnAd(AddDto adds) {
        var entity = addMap.toEntity(adds);
        var save = addsRepository.save(entity);
        return addMap.toDto(save);
    }

    public AddDto editAdd(AddDto adds) {
        var entity = addMap.toEntity(adds);
        var edit = addsRepository.save(entity);
        return addMap.toDto(edit);
    }
    // Только пользователи с ролью ADMIN могут выполнить этот метод или сам владелец
    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    public void deleteAdd(long id) {
        addsRepository.deleteById(id);
    }

    public Collection<Add> getAllAdd() {
        return addsRepository.findAll();
    }

    public Add findAddById(long id) {
        return addsRepository.findAddsById(id);
    }

}
