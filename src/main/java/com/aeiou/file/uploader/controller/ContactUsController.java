package com.aeiou.file.uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeiou.file.uploader.dto.ContactUsRequest;
import com.aeiou.file.uploader.dto.ContactUsResponse;
import com.aeiou.file.uploader.service.ContactUsService;

@RestController
@RequestMapping("/v1")
public class ContactUsController {

	@Autowired
	private ContactUsService contactUsService;

	@PostMapping(path = "/contact", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ContactUsResponse> contact(@RequestBody final ContactUsRequest contactUsRequest) {
		ContactUsResponse response = new ContactUsResponse();
		try {
			String status = contactUsService.save(contactUsRequest);

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
