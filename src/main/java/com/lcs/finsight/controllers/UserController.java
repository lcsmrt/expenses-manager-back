package com.lcs.finsight.controllers;

import com.lcs.finsight.dtos.request.UserRequestDTO;
import com.lcs.finsight.dtos.response.UserResponseDTO;
import com.lcs.finsight.models.User;
import com.lcs.finsight.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finsight/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        UserResponseDTO response = userService.mapToResponseDTO(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<User> users = userService.findAll();
        List<UserResponseDTO> response = users.stream()
                .map(userService::mapToResponseDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO dto) {
        User createdUser = userService.create(dto);
        UserResponseDTO response = userService.mapToResponseDTO(createdUser);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDTO dto) {
        User updatedUser = userService.update(id, dto);
        UserResponseDTO response = userService.mapToResponseDTO(updatedUser);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
