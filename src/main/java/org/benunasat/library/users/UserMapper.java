package org.benunasat.library.users;

public class UserMapper {


    public static UserDTO entityToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .address(user.getAddress())
                .phoneNumber(user.getPhoneNumber())
                .dayOfBirth(user.getDayOfBirth())
                .role(user.getRole())
                .build();
    }

//    public static User dtoToEntity(UserUpdateDetails userUpdateDetails, String newPassword) {
//        return User.builder()
//                .id(userUpdateDetails.id())
//                .firstName(userUpdateDetails.firstName())
//                .lastName(userUpdateDetails.lastName())
//                .email(userUpdateDetails.email())
//                .address(userUpdateDetails.address())
//                .phoneNumber(userUpdateDetails.phoneNumber())
//                .dayOfBirth(userUpdateDetails.dayOfBirth())
//                .password(newPassword)
//                .build();
//    }
    public static User insertUpdatedFields(UserUpdateDetails userUpdateDetails, User oldDetailsUser) {
        return User.builder()
                .id(oldDetailsUser.getId())
                .firstName(userUpdateDetails.firstName())
                .lastName(userUpdateDetails.lastName())
                .email(userUpdateDetails.email())
                .address(userUpdateDetails.address())
                .phoneNumber(userUpdateDetails.phoneNumber())
                .dayOfBirth(userUpdateDetails.dayOfBirth())
                .password(oldDetailsUser.getPassword())
                .build();
    }


}

