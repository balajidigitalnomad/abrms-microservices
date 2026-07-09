package com.app.restaurant.mapper;

import com.app.restaurant.dto.FoodDto;
import com.app.restaurant.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodDto toDto(Food food);
    Food toEntity(FoodDto foodDto);
    void updateFoodDto(FoodDto foodDto, @MappingTarget Food food);
}
