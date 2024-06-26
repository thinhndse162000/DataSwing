package com.vn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vn.demo.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select sp from User sp where sp.name = :name")
	User getUserByName(String name);
	
	@Query("select count(sp) from User sp")
	Integer getNumberOfUser();
}
