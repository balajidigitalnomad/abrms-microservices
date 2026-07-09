package com.app.user.service;

import com.app.user.client.RestaurantClient;
import com.app.user.client.dto.FoodDto;
import com.app.user.dto.UserDto;
import com.app.user.entity.User;
import com.app.user.event.UserCreatedEvent;
import com.app.user.exception.UserNotFoundException;
import com.app.user.kafka.producer.UserKafkaProducer;
import com.app.user.mapper.UserMapper;
import com.app.user.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
   private final UserRepository userRepository;
   private final UserMapper userMapper;
   private final RestaurantClient restaurantClient;
   private final UserKafkaProducer userKafkaProducer;


   @Override
    public UserDto createUser(UserDto userDto){
       User user = userMapper.toEntity(userDto);
       User savedUser = userRepository.save(user);

       // Building & Publishing a User created event here.
       UserCreatedEvent event = UserCreatedEvent.builder()
               .userId(savedUser.getUserId())
               .firstName(savedUser.getFirstName())
               .lastName(savedUser.getLastName())
               .email(savedUser.getEmailId())
               .build();
       userKafkaProducer.publishUserCreatedEvent(event);


        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto){
       User user= userRepository.findById(userDto.getUserId()).orElseThrow(()->new UserNotFoundException("User Not found."));
       userMapper.updateUserEntity(userDto,user);
       return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(Long id){
       User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User Not found."));
       return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers(){
       return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    public void deleteUserById(Long userId ){
       userRepository.deleteById(userId);
    }

    @CircuitBreaker(name ="restaurantService", fallbackMethod = "getAllFoodsFallback")
    @Override
    public List<FoodDto> getAllFoods() {
        return restaurantClient.getAllFoods();
    }

    public List<FoodDto> getAllFoodsFallback(Exception e){

        FoodDto foodDto = FoodDto.builder()
                .foodId(0L)
                .foodCategoryId(0l)
                .foodName("Restaurant Service Temporarily unavailable.")
                .foodPrice(0.0)
                .isActive(false)
                .build();

        return List.of(foodDto);


    }
}
