package com.lcs.finsight.dtos.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

    @NotBlank(message = "O email do usuário não pode ser vazio.")
    private String email;

    @NotBlank(message = "A senha do usuário não pode ser vazia.")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
