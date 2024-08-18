package ru.skypro.homework.bd.muppas;

import org.springframework.stereotype.Service;
import ru.skypro.homework.bd.dto.AddDto;
import ru.skypro.homework.bd.entity.Add;
@Service
public class AddMap {

    public AddDto toDto(Add add) {
        AddDto addDto = new AddDto();
        addDto.setId(add.getId());
        addDto.setAuthorId(add.getAuthorId());
        addDto.setTitle(add.getTitle());
        addDto.setImage(add.getImage());
        addDto.setPrice(add.getPrice());
        return addDto;
    }

    public Add toEntity(AddDto addDto) {
        Add add = new Add();
        add.setId(addDto.getId());
        add.setAuthorId(addDto.getAuthorId());
        add.setTitle(addDto.getTitle());
        add.setImage(addDto.getImage());
        add.setPrice(addDto.getPrice());
        return add;
    }

}
