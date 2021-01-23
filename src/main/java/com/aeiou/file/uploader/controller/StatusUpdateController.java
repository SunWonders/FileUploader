package com.aeiou.file.uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeiou.file.uploader.dto.StatusUpdateRequest;
import com.aeiou.file.uploader.dto.StatusUpdateResponse;
import com.aeiou.file.uploader.service.StatusUpdateService;

@RestController
@RequestMapping("/v1/status")
public class StatusUpdateController {

	@Autowired
	private StatusUpdateService statusUpdateService;

	@PostMapping(path = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StatusUpdateResponse> update(@RequestBody final StatusUpdateRequest statusUpdateRequest) {
		StatusUpdateResponse response = new StatusUpdateResponse();
		try {
			String savedId = statusUpdateService.updateStatus(statusUpdateRequest);

			if (savedId != null && !savedId.isEmpty()) {
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
