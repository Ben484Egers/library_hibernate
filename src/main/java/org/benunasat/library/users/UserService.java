package org.benunasat.library.users;

import org.benunasat.library.config.JPAConfig;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final UserDAO userDAO;

    public UserService(){
        this.userDAO = new UserDAO(JPAConfig.getEntityManager());
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.getAllUsers().stream().map(UserMapper::entityToDTO).toList();
    }

    public UserDTO getUserByEmail(String email) {

        Optional<User> optionalUser = userDAO.findUserByEmail(email);

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("NO USER FOUND WITH ID");
        }

        return UserMapper.entityToDTO(optionalUser.get());
    }

    public UserDTO getUserById(Long id) {

        Optional<User> optionalUser = userDAO.findUserById(id);

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("NO USER FOUND WITH ID");
        }

        return UserMapper.entityToDTO(optionalUser.get());
    }


    public UserDTO updateUserDetails(UserUpdateDetails userUpdateDetails) {
        Optional<User> userOldDetails = userDAO.findUserByEmail(userUpdateDetails.email());
        if (userOldDetails.isEmpty()) {
            throw new IllegalStateException();
        }
        User updatedUser = userDAO.update(UserMapper.insertUpdatedFields(userUpdateDetails, userOldDetails.get()));
        return UserMapper.entityToDTO(updatedUser);
    }

    public UserDTO updateUserPassword(UserUpdatePassword userUpdatePassword) {
        Optional<User> userOldPassword = userDAO.findUserById(userUpdatePassword.id());
        if (userOldPassword.isEmpty()) {
            throw new IllegalStateException();
        }

        User dbUser = userOldPassword.get();
        dbUser.setPassword(userUpdatePassword.password());

        User updatedUser = userDAO.update(dbUser);
        return UserMapper.entityToDTO(updatedUser);
    }

    public boolean deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }

}
