package com.app.user.client;

import com.app.user.client.dto.FoodDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="ABRMS-RESTAURANT-SERVICE")
public interface RestaurantClient {


    @GetMapping("/api/foods")
    List<FoodDto> getAllFoods();


}
