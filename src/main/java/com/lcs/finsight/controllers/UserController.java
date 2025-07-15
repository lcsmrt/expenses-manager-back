package com.lcs.finsight.controllers;

import com.lcs.finsight.utils.ApiRoutes;
import com.lcs.finsight.dtos.request.UserRequestDto;
import com.lcs.finsight.dtos.response.UserResponseDto;
import com.lcs.finsight.models.User;
import com.lcs.finsight.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Usuários")
@RestController
@RequestMapping(ApiRoutes.USER)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Busca um usuário pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        User user = userService.findById(id);
        UserResponseDto response = userService.mapToResponseDTO(user);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Busca todos os usuários")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = userService.findAll();
        List<UserResponseDto> response = users.stream()
                .map(userService::mapToResponseDTO)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Cria um novo usuário")
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserRequestDto dto) {
        User createdUser = userService.create(dto);
        UserResponseDto response = userService.mapToResponseDTO(createdUser);
        return ResponseEntity.status(201).body(response);
    }

    @Operation(summary = "Atualiza um usuário")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody @Valid UserRequestDto dto) {
        User updatedUser = userService.update(id, dto);
        UserResponseDto response = userService.mapToResponseDTO(updatedUser);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Deleta um usuário")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
