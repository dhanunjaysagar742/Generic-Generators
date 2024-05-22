package in.dj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.dj.entity.User;
import in.dj.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserRepo repo;
	
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User controller) {
		repo.save(controller);
		return "ok";
	}
	
	
}
