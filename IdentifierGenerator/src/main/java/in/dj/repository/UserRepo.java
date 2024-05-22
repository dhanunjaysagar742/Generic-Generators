package in.dj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.dj.entity.User;

public interface UserRepo extends JpaRepository<User, String>{
	

}
