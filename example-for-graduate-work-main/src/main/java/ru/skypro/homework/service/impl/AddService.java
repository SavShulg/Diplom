package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Add;
import ru.skypro.homework.repository.AddsRepository;

import java.util.Collection;

@Service
public class AddService  {

    private final AddsRepository addsRepository;

    public AddService(AddsRepository addsRepository) {
        this.addsRepository = addsRepository;
    }

    public Add addingAnAd(Add adds) {
        return addsRepository.save(adds);

    }

    public Add editAdd(Add adds) {
        return addsRepository.save(adds);
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
