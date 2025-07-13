package com.lcs.finsight.exceptions;

public class UserExceptions {

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(Long id) {
            super("Usuário não encontrado para o id " + id + " .");
        }
    }

    public static class EmailAlreadyUsedException extends RuntimeException {
        public EmailAlreadyUsedException(String email) {
            super("O e-mail " + email + " já está em uso.");
        }
    }
}
