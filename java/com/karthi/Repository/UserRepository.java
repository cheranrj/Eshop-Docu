package com.karthi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karthi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmailAndPassword(String emailId, String password);

	public User findByEmail(String emailId);
}
