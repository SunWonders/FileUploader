package com.sun.wonders.image.uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.wonders.image.uploader.dto.UploadResponse;
import com.sun.wonders.image.uploader.service.UploadService;

// TODO: Auto-generated Javadoc
/**
 * The Class UploadController.
 */
@RestController
@RequestMapping("/v1")
public class UploadController {

	/** The upload service. */
	@Autowired
	private UploadService uploadService;

	/**
	 * Upload.
	 *
	 * @param file the file
	 * @return the response entity
	 */
	@PostMapping("/upload")
	public ResponseEntity<UploadResponse> upload(@RequestParam("file") MultipartFile file) {
		uploadService.upload(file);
		UploadResponse response = new UploadResponse();
		response.setMessage("Success");
		response.setStatus(200);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
}
