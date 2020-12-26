package com.aeiou.file.uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aeiou.file.uploader.service.RetriveService;

// TODO: Auto-generated Javadoc
/**
 * The Class RetriveController.
 */
@RestController
@RequestMapping("/v1/retrive")
public class RetriveController {
	
	/** The retrive service. */
	@Autowired
	RetriveService retriveService;
	
	/**
	 * Serve file.
	 *
	 * @param filename the filename
	 * @return the response entity
	 */
	@GetMapping("/getFileByFileName")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@RequestParam String filename) {

		Resource file = retriveService.loadFileAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}
