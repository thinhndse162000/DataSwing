package com.vn.demo.Service;

import java.util.List;

import com.vn.demo.Domain.User;
import com.vn.demo.Request.CreateRequest;
import com.vn.demo.Request.UpdateRequest;

public interface UserService {
	User getByName(String name);
	List<User> getAll();
	void creatUser(CreateRequest request);
	void updateUser(UpdateRequest request,Integer id);
}
