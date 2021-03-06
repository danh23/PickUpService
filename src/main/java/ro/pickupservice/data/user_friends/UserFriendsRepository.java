package ro.pickupservice.data.user_friends;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.user_friends.entity.UserFriends;
import ro.pickupservice.data.user_friends.entity.UserFriendsPk;

@Repository
public interface UserFriendsRepository extends JpaRepository<UserFriends, UserFriendsPk> {

	public List<UserFriends> findByUser(Long userId);
}
