package com.app.user.service;

import com.app.user.client.dto.FoodDto;
import com.app.user.dto.UserDto;

import java.util.List;


public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
    void deleteUserById(Long id);

    List<FoodDto> getAllFoods();
}
