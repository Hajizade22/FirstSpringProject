package az.matrix.firstspringproject.controller;

import az.matrix.firstspringproject.dto.CarDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CarController {
    ArrayList<CarDto> car = new ArrayList<>();

    @GetMapping
    public String hello() {
        return "Hello Car";
    }

    @GetMapping("path")
    public String path(){
        return "Path Variable";
    }

    @PostMapping("create")
    public CarDto create(@RequestBody CarDto dto) {
        car.add(dto);
        return dto;
    }

    @GetMapping("all")
    public ArrayList<CarDto> all() {
        return car;
    }

    @GetMapping("get")
    public CarDto get(@RequestParam int index) {
        return car.get(index);
    }

    @DeleteMapping("delete")
    public CarDto deleted(@RequestParam int index) {
        return car.remove(index);
    }

    @PutMapping("update")
    public CarDto update(@RequestParam int index, @RequestBody CarDto updatedDto) {
        if (index >= 0 && index < car.size()) {
            car.set(index, updatedDto);
            return updatedDto;
        } else {
            throw new IllegalArgumentException("Invalid index");
        }

    }
}