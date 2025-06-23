package com.lcs.finsight.services;

import com.lcs.finsight.dtos.request.UserRequestDto;
import com.lcs.finsight.dtos.response.UserResponseDto;
import com.lcs.finsight.models.User;
import com.lcs.finsight.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para o id: " + id));
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User create(UserRequestDto dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());


        String encryptedPassword = encoder.encode(dto.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, UserRequestDto dto) {
        User existingUser = findById(id);

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());

        String encryptedPassword = encoder.encode(dto.getPassword());
        existingUser.setPassword(encryptedPassword);

        return userRepository.save(existingUser);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponseDto mapToResponseDTO(User user) {
        return new UserResponseDto(user);
    }

}
