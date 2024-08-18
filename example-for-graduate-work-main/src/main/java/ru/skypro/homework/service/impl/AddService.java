package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;


import ru.skypro.homework.bd.dto.AddDto;
import ru.skypro.homework.bd.entity.Add;
import ru.skypro.homework.bd.muppas.AddMap;
import ru.skypro.homework.repository.AddsRepository;

import java.util.Collection;

@Service
public class AddService  {

    private final AddsRepository addsRepository;

    private final AddMap addMap;

    public AddService(AddsRepository addsRepository, AddMap addMap) {
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
