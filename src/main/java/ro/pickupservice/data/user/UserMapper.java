package ro.pickupservice.data.user;

import ro.pickupservice.controllers.user.bean.request.CreateUserRequest;
import ro.pickupservice.data.user.entity.User;

public class UserMapper {
    public static User mapUserRequestToUser(CreateUserRequest request) {
        User user = new User();
        user.setCity(user.getCity());
        user.setCountry(user.getCountry());
        user.setEmail(user.getEmail());
        user.setFacebookId(user.getFacebookId());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setUsername(user.getUsername());
        return user;
    }
}
