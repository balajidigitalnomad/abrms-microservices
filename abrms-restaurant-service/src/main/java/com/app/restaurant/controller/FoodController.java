package com.app.restaurant.controller;

import com.app.restaurant.dto.FoodDto;
import com.app.restaurant.service.FoodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodDto> createFood(@Valid @RequestBody FoodDto foodDto){
        return ResponseEntity.ok().body(foodService.createFood(foodDto));
    }

    @GetMapping
    public ResponseEntity<List<FoodDto>> getAllFoods() {
        return ResponseEntity.ok().body(foodService.getAllFoods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodDto> getFoodById(@PathVariable Long id){
        return ResponseEntity.ok().body(foodService.getFoodById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodDto> updateFood(@Valid @PathVariable Long id, @Valid @RequestBody  FoodDto foodDto){
        return ResponseEntity.ok().body(foodService.updateFood(foodDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoodById(@PathVariable Long id){
        foodService.deleteFoodById(id);
        return ResponseEntity.ok().body("Food item deleted Successfully.");
    }

}
