package devhelton.dtos;

import devhelton.enums.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
