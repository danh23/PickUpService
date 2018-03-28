package ro.pickupservice.data.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.pickupservice.data.user.entity.User;

import java.util.List;

@Service
public class UserProvider {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findOne(id);
    }

    public User findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
