package org.benunasat.library.auth;

import org.benunasat.library.config.JPAConfig;
import org.benunasat.library.users.User;
import org.benunasat.library.users.UserDAO;
import org.benunasat.library.users.UserDTO;
import org.benunasat.library.users.UserMapper;

public class AuthService {

    private final UserDAO userDao;

    public AuthService() {
        this.userDao = new UserDAO(JPAConfig.getEntityManager());
    }


    public AuthResponse register(UserRegisterRequest request) {
        User newUser = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .dayOfBirth(request.getDayOfBirth())
                .build();

        User newUserResponse = userDao.create(newUser);

        UserDTO userDTO = UserMapper.entityToDTO(newUserResponse);

        return AuthResponse.builder().user(userDTO).build();
    }

    public AuthResponse authenticate(AuthenticationRequest request) {

        User user = userDao.findUserByEmail(request.getEmail())
                .orElseThrow();

        if(!verifyPassword(request.getPassword(),  user.getPassword())){
            System.out.println("INCORRECT PASSWORD");
//            System.out.println(user.getPassword());
            return AuthResponse.builder()
                    .user(null)
                    .build();
        }

        UserDTO userDTO = UserMapper.entityToDTO(user);

        return AuthResponse.builder()
                .user(userDTO)
                .build();
    }

    private boolean verifyPassword(String givenPassword, String dbPassword) {
        return givenPassword.equals(dbPassword);
    }

}
