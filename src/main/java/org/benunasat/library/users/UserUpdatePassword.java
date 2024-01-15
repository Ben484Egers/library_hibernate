package org.benunasat.library.users;

import lombok.Builder;

@Builder
public record UserUpdatePassword (Long id, String password) {
}
