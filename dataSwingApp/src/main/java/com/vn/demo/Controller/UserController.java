package com.vn.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vn.demo.Domain.User;
import com.vn.demo.Request.CreateRequest;
import com.vn.demo.Service.UserService;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService service;
	
	public UserController(UserService service) {
		this.service= service;
	}
	
	@GetMapping("/")
	public String listUser(Model model) {
		 List<User> users = service.getAll();
		 model.addAttribute("users", users);
		 System.out.println(users.get(0));
	     return "index";
	}
	
	@GetMapping("create")
	public String createUserForm(Model model) {
		CreateRequest createRequest = new CreateRequest();
		model.addAttribute("createRequest", createRequest);
		return "create";
	}
	
	@PostMapping("createUser")
	public String createUserForm(@ModelAttribute("createRequest") CreateRequest request) {
		System.out.println("API were call ");
		service.creatUser(request);
		return "index";
	}
}
