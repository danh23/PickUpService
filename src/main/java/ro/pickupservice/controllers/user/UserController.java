package ro.pickupservice.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.pickupservice.controllers.user.bean.request.CreateUserRequest;
import ro.pickupservice.controllers.user.bean.request.GetNearbyUsersRequest;
import ro.pickupservice.controllers.user.bean.response.GetNearbyUsersResponse;
import ro.pickupservice.controllers.user.bean.response.UserDto;
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

    @RequestMapping(value = "/getUserById/{userId}", method = RequestMethod.POST)
    public ResponseEntity<UserDto> getUserById(@RequestBody Long userId) {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserByEmail", method = RequestMethod.POST)
    public ResponseEntity<UserDto> getUserByEmail(@RequestBody String email) {
        UserDto user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getUserFriendsById/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<UserFriends>> getAllUsers(@PathVariable Long userId) {
        List<UserFriends> user = userService.getUserFriends(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>> user() {
        List<UserDto> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Long> createUser(@RequestBody CreateUserRequest request) throws CustomException {
        Long response = userService.setUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/getNearbyUsers", method = RequestMethod.POST)
    public ResponseEntity<GetNearbyUsersResponse> getNearbyUsers(GetNearbyUsersRequest request) {
        return new ResponseEntity(null, HttpStatus.OK);
    }
}
