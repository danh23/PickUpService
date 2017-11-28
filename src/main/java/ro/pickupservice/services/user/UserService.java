package ro.pickupservice.services.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.pickupservice.controllers.user.bean.request.SetUserSportsRequest;
import ro.pickupservice.controllers.user.bean.response.SetUserSportsResponse;
import ro.pickupservice.data.sport.SportRepository;
import ro.pickupservice.data.sport.entity.Sport;
import ro.pickupservice.data.user.UserRepository;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.data.user_friends.UserFriendsRepository;
import ro.pickupservice.data.user_friends.entity.UserFriends;
import ro.pickupservice.exception.CustomException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private UserFriendsRepository userFriendsRepository;
	
	public User getUserByEmail(String email) {
		User user = userRepository.findOneByEmail(email);
		return user;
	}
	
	public User setUser(User user) {
		try{
			User dbUser = userRepository.findOneByEmail(user.getEmail());
			if(dbUser != null) {
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
		} catch(Exception e){
			throw new CustomException(0, e.getMessage());
		}
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public List<UserFriends> getUserFriends(Integer userId){
		return userFriendsRepository.findByUser(userId);
	}

	public SetUserSportsResponse setUserSports(SetUserSportsRequest request) {
		SetUserSportsResponse response = new SetUserSportsResponse();
		User user = userRepository.findOne(request.getUserId());
		userRepository.saveAndFlush(user);
		return response;
	}
}
