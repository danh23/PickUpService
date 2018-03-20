package ro.pickupservice.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.data.user.UserRepository;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.data.user_friends.UserFriendsRepository;
import ro.pickupservice.data.user_friends.entity.UserFriends;
import ro.pickupservice.exception.CustomException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFriendsRepository userFriendsRepository;

    public User getUserById(Long id){
        return userRepository.findOne(id);
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findOneByEmail(email);
        return user;
    }

    public User setUser(User user) {
        try {
            User dbUser = userRepository.findOneByEmail(user.getEmail());
            if (dbUser != null) {
                dbUser.setCity(user.getCity());
                dbUser.setCountry(user.getCountry());
                dbUser.setEmail(user.getEmail());
                dbUser.setFacebookId(user.getFacebookId());
                dbUser.setFirstName(user.getFirstName());
                dbUser.setLastName(user.getLastName());
                dbUser.setUsername(user.getUsername());
                return userRepository.saveAndFlush(dbUser);
            }
            return userRepository.saveAndFlush(user);
        } catch (Exception e) {
            throw new CustomException(0, e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserFriends> getUserFriends(Long userId) {
        return userFriendsRepository.findByUser(userId);
    }

}
