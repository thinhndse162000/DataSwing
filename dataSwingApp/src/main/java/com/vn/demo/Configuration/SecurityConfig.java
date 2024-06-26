package com.vn.demo.Configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.vn.demo.Service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	private final UserService service;

	public SecurityConfig(UserService service) {
		this.service = service;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.cors(cors -> cors.disable())
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers(
						"main/webapp/WEB-INF/views/*",
						"/css/**",
						"user/*",
						"/login"
						).permitAll()
				.anyRequest().authenticated())
			.formLogin(login -> login
					.loginPage("/login").permitAll()
//					.loginProcessingUrl("/login").permitAll()
//					.defaultSuccessUrl("/user/").permitAll()
					)
					.logout(logout -> logout.permitAll());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		List<UserDetails> userDetailsList = new ArrayList<>();
		for (com.vn.demo.Domain.User user : service.getAll()) {
			UserDetails userDetails = User.withDefaultPasswordEncoder().username(user.getName())
					.password(user.getPassword()).roles(user.getRole()).build();
			userDetailsList.add(userDetails);
		}
		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(userDetailsList);

		return userDetailsManager;
	}
}
