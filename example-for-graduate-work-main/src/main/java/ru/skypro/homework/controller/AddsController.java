package ru.skypro.homework.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.bd.dto.AddDto;
import ru.skypro.homework.service.impl.AddService;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/Adds")
@RequiredArgsConstructor
public class AddsController {
    private final AddService addService;

    @PostMapping
    public AddDto addingAnAd(@RequestBody AddDto adds) {
        return addService.addingAnAd(adds);
    }

    @PutMapping
    public ResponseEntity<AddDto> editAdd(@RequestBody AddDto adds) {
        AddDto foundAdd = addService.editAdd(adds);
        if (foundAdd == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundAdd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddDto> updateAdd(@PathVariable Long id, @RequestBody AddDto adds) {
        return ResponseEntity.ok(new AddDto());
    }

    @GetMapping
    public ResponseEntity findAdd(@RequestParam(required = false) Long id) {
        if (id != null) {
            return ResponseEntity.ok(addService.findAddById(id));
        }
        return ResponseEntity.ok(addService.getAllAdd());
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAdd(@PathVariable Long id) {
        addService.deleteAdd(id);
        return ResponseEntity.ok().build();
    }

}
