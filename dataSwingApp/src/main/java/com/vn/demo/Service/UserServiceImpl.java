package com.vn.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vn.demo.Domain.User;
import com.vn.demo.Repository.UserRepository;
import com.vn.demo.Request.CreateRequest;
import com.vn.demo.Request.UpdateRequest;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	
	public UserServiceImpl (UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public User getByName(String name) {
		User user = repository.getUserByName(name);
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> users = repository.findAll();
		return users;
	}

	@Override
	public void creatUser(CreateRequest request) {
		User user = new User();
		
		user.setId(repository.getNumberOfUser() +1 );
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		
		repository.save(user);
	}

	@Override
	public void updateUser(UpdateRequest request,Integer id) {
		User user = repository.findById(id).orElseThrow();
		
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setRole(request.getRole());
		
		repository.save(user);
		
	}

}
