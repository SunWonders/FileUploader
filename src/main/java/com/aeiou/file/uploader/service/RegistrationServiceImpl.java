package com.aeiou.file.uploader.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aeiou.file.uploader.dto.RegisterRequest;
import com.aeiou.file.uploader.entity.Users;
import com.aeiou.file.uploader.repo.UsersRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public String register(RegisterRequest registerRequest) {

		Users users = usersRepository.findByUsername(registerRequest.getEmailId());
		if (users == null) {
			users = new Users();
			users.setUsername(registerRequest.getEmailId());
			users.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
			users.setIsVerified(true);
			users.setInsertedDateTime(new Date());
			users.setIsEnabled(true);
			users.setTypeOfUser("CUSTOMER");
		} else {
			users.setPassword(new BCryptPasswordEncoder().encode(registerRequest.getPassword()));
			users.setUpdatedDateTime(new Date());
		}
		usersRepository.save(users);

		return users.getId();

	}
}
