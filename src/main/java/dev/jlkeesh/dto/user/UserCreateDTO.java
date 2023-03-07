package dev.jlkeesh.dto.user;

public record UserCreateDTO(String username, String password, String confirmPassword) {
}
