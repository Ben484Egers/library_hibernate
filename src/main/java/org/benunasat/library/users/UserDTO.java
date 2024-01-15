package org.benunasat.library.users;

import lombok.Builder;
import org.benunasat.library.enums.Role;

import java.time.LocalDate;

@Builder
public record UserDTO(Long id, String firstName, String lastName, String email, String address,
                      String phoneNumber, LocalDate dayOfBirth, Role role) {
}

