package ro.pickupservice.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.pickupservice.controllers.user.bean.request.GetNearbyUsersRequest;
import ro.pickupservice.controllers.user.bean.response.GetNearbyUsersResponse;
import ro.pickupservice.data.user.entity.User;
import ro.pickupservice.data.user_friends.entity.UserFriends;
import ro.pickupservice.exception.CustomException;
import ro.pickupservice.services.user.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ResponseEntity user(Principal principal) {
        return new ResponseEntity(principal, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserByEmail", method = RequestMethod.POST)
    public ResponseEntity<User> getUserByEmail(@RequestBody String email) {
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserFriendsById/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<UserFriends>> getAllUsers(@PathVariable Long userId) {
        List<UserFriends> user = userService.getUserFriends(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<List<User>> user() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/setUser", method = RequestMethod.POST)
    public ResponseEntity<User> setUser(@RequestBody User user) throws CustomException {
        User userResponse = userService.setUser(user);
        return new ResponseEntity<User>(userResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/getNearbyUsers", method = RequestMethod.POST)
    public ResponseEntity<GetNearbyUsersResponse> getNearbyUsers(GetNearbyUsersRequest request) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
