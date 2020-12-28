package com.aeiou.file.uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aeiou.file.uploader.dto.UploadResponse;
import com.aeiou.file.uploader.service.UploadService;

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
		String shortUrl=uploadService.upload(file);
		return new ResponseEntity<>(new UploadResponse(200, "Success",shortUrl), HttpStatus.ACCEPTED);
	}
}
