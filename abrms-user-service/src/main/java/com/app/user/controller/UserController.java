package com.app.user.controller;

import com.app.user.client.dto.FoodDto;
import com.app.user.dto.UserDto;
import com.app.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userService.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok().body(userService.updateUser(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User Deleted Successfully.");
    }

    @GetMapping("/foods")
    public ResponseEntity<List<FoodDto>> getAllFoods() {
        return ResponseEntity.ok(userService.getAllFoods());
    }
}
