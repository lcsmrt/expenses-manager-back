package com.lcs.finsight.services;

import com.lcs.finsight.dtos.request.UserRequestDTO;
import com.lcs.finsight.dtos.response.UserResponseDTO;
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
    public User create(UserRequestDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.getPassword());
        user.setPassword(encryptedPassword);

        return userRepository.save(user);
    }

    @Transactional
    public User update(Long id, UserRequestDTO dto) {
        User existingUser = findById(id);

        existingUser.setName(dto.getName());
        existingUser.setEmail(dto.getEmail());
        existingUser.setPassword(dto.getPassword());

        return userRepository.save(existingUser);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponseDTO mapToResponseDTO(User user) {
        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
    }

}
