package com.karthi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.karthi.Repository.UserRepository;

import com.karthi.form.RegistrationForm;
import com.karthi.model.User;
/*import com.karthi.util.EmailUtil;*/

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/*@Autowired
	private EmailUtil emailUtil;*/

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public User findByEmailAndPassword(String email, String password) {
		User hashedPassword = userRepository.findByEmail(email);

		boolean isValid = passwordEncoder.matches(password, hashedPassword.getPassword());

		if (isValid) {
			return userRepository.findByEmailAndPassword(email, hashedPassword.getPassword());
		} else {
			return null;
		}
	}

	public void register(RegistrationForm regUserForm) throws Exception {

		User user = userRepository.findByEmail(regUserForm.getEmail());
		System.out.println("Is email already exists? " + user);

		if (user != null) {
			throw new Exception("Email already exists!!!");
		}

		String hashedPassword = passwordEncoder.encode(regUserForm.getPassword());
		System.out.println(hashedPassword);
		User userObj = new User();
		userObj.setName(regUserForm.getName());
		userObj.setEmail(regUserForm.getEmail());
		userObj.setPassword(hashedPassword);
		userRepository.save(userObj);

			}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
