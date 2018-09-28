package th.co.maximus.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.co.maximus.auth.model.UserDto;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserDto, Long> {
	
    UserDto findByUsername(String username);
    
}
