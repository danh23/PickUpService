package ro.pickupservice.data.user;

import ro.pickupservice.controllers.user.bean.request.CreateUserRequest;
import ro.pickupservice.controllers.user.bean.response.UserDto;
import ro.pickupservice.data.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static User mapUserRequestToUser(CreateUserRequest request) {
        User user = new User();
        user.setCity(request.getCity());
        user.setCountry(request.getCountry());
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        return user;
    }

    public static UserDto mapUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setCity(user.getCity());
        userDto.setCountry(user.getCountry());
        return userDto;
    }

    public static List<UserDto> mapUserListToOrderDtoList(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for(User u: users){
            userDtos.add(mapUserToUserDto(u));
        }
        return userDtos;
    }
}
