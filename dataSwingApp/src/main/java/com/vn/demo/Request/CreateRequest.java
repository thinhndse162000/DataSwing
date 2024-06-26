package com.vn.demo.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRequest {
	private Integer id;
	private String name;
	private String role;
	private String email;
	private String password;
}
