package com.security.learning.program.entities.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
