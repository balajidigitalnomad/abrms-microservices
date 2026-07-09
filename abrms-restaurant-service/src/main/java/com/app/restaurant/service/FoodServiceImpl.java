package com.app.restaurant.service;

import com.app.restaurant.dto.FoodDto;
import com.app.restaurant.entity.Food;
import com.app.restaurant.exception.ResourceNotFoundException;
import com.app.restaurant.mapper.FoodMapper;
import com.app.restaurant.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public FoodDto createFood(FoodDto foodDto){
        return foodMapper.toDto(foodRepository.save(foodMapper.toEntity(foodDto)));
    }

    public FoodDto updateFood(FoodDto foodDto){
        Food food = foodRepository.findById(foodDto.getFoodId()).orElseThrow(()->new ResourceNotFoundException("Food not found."));
        foodMapper.updateFoodDto(foodDto, food);
        return foodMapper.toDto(foodRepository.save(food));
    }

    public FoodDto getFoodById(Long foodId){
        Food food = foodRepository.findById(foodId).orElseThrow(()->new ResourceNotFoundException("Food not found."));
        return foodMapper.toDto(food);
    }

    public List<FoodDto> getAllFoods(){
        return foodRepository.findAll().stream().map(foodMapper::toDto).toList();
    }

    public void deleteFoodById(Long foodId){
        foodRepository.deleteById(foodId);
    }
}
