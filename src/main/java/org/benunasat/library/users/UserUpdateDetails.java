package org.benunasat.library.users;

import lombok.Builder;
import java.time.LocalDate;

@Builder
public record UserUpdateDetails(Long id, String firstName, String lastName, String email, String address, String phoneNumber, LocalDate dayOfBirth) {
}

