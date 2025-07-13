package com.lcs.finsight.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDto {

    @NotBlank(message = "O nome do usuário não pode ser vazio.")
    private String name;

    @NotBlank(message = "O email do usuário não pode ser vazio.")
    @Email(message = "Formato de e-mail inválido.")
    private String email;

    @NotBlank(message = "A senha do usuário não pode ser vazia.")
    private String password;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
