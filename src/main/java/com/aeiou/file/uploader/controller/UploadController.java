package com.aeiou.file.uploader.controller;

import javax.servlet.http.HttpServletRequest;

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
	public ResponseEntity<UploadResponse> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			@RequestParam(value = "emailId", required = false) String emailId,
			@RequestParam(value = "countToDownload", required = false) Integer countToDownload) {
		try {

			String shortUrl = uploadService.upload(file, request, emailId, countToDownload);
			return new ResponseEntity<>(new UploadResponse(200, "Success", shortUrl), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(new UploadResponse(500, "Oops!! We are facing issues,please try again"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
