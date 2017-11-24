package ro.pickupservice.data.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.pickupservice.data.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findOneByEmail(String email);
}
