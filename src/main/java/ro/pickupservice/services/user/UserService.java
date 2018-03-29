package ro.pickupservice.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.controllers.user.bean.request.CreateUserRequest;
import ro.pickupservice.controllers.user.bean.response.UserDto;
import ro.pickupservice.data.user.UserMapper;
import ro.pickupservice.data.user.UserProvider;
import ro.pickupservice.data.user.UserRepository;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.data.user_friends.UserFriendsRepository;
import ro.pickupservice.data.user_friends.entity.UserFriends;
import ro.pickupservice.exception.CustomException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserProvider userProvider;

    @Autowired
    private UserFriendsRepository userFriendsRepository;

    public UserDto getUserById(Long id){
        User user = userProvider.findUserById(id);
        if(user == null){
            throw new CustomException(2, "Userul nu exista");
        }
        UserDto userDto = UserMapper.mapUserToUserDto(user);
        return userDto;
    }

    public UserDto getUserByEmail(String email) {
        User user = userProvider.findOneByEmail(email);
        if(user == null){
            throw new CustomException(2, "Userul nu exista");
        }
        UserDto userDto = UserMapper.mapUserToUserDto(user);
        return userDto;
    }

    public Long setUser(CreateUserRequest request) {
        try {
            User user = userProvider.findOneByEmail(request.getEmail());
            if (user == null) {
                user = UserMapper.mapUserRequestToUser(request);
                return userProvider.createUser(user).getId();
            }
            else {
                throw new CustomException(1, "User deja existent");
            }
        } catch (Exception e) {
            throw new CustomException(0, e.getMessage());
        }
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userProvider.findAllUsers();
        List<UserDto> userDtos =UserMapper.mapUserListToOrderDtoList(users);
        return userDtos;
    }

    public List<UserFriends> getUserFriends(Long userId) {
        return userFriendsRepository.findByUser(userId);
    }

}
