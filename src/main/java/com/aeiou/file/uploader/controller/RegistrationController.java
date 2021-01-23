package com.aeiou.file.uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeiou.file.uploader.dto.RegisterRequest;
import com.aeiou.file.uploader.dto.RegisterResponse;
import com.aeiou.file.uploader.service.RegistrationService;

@RestController
@RequestMapping("/v1")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping(path = "/register", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<RegisterResponse> register(@RequestBody final RegisterRequest registerRequest) {
		RegisterResponse response = new RegisterResponse();
		try {
			String status = registrationService.register(registerRequest);

			if (status != null && !status.isEmpty()) {
				response.setMessage("Success");
				response.setStatus(200);
				return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			} else {
				response.setMessage("Failure");
				response.setStatus(2001);
				return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {

			response.setMessage("Failure");
			response.setStatus(500);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
