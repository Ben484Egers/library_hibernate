package org.benunasat.library.users;

import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class UserDAO {


    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getAllUsers() {
        System.out.println("Getting all users.....");
//        memberRepository.findAll().stream().map(UserMapper::entityToDTO).toList();
        return null;
    }
    public User create(User newUser) {
        System.out.println("Creating new user.....");
        return null;
    }
    public User update(User updatedUser) {
        System.out.println("Updating user with id: "+ updatedUser.getId());

        return null;
    }

    public boolean deleteUser (Long id) {
        System.out.println("Deleting user with id: "+ id);
        return true;
    }

    public Optional<User> findUserById(Long id) {
        System.out.println("Finding user by id....: " + id);
        return Optional.of(null);
    }

    public Optional<User> findUserByEmail (String email) {
        System.out.println("Finding user by email: "+ email);
        return Optional.empty();
    }
}
