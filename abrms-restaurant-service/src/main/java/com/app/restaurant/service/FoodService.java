package com.app.restaurant.service;

import com.app.restaurant.dto.FoodDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodService {
    FoodDto createFood(FoodDto foodDto);

    FoodDto updateFood(FoodDto foodDto);

    FoodDto getFoodById(Long id);

    List<FoodDto> getAllFoods();

    void deleteFoodById(Long id);

}