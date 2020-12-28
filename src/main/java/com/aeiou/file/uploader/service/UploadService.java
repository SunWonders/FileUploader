package com.aeiou.file.uploader.service;

import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Interface UploadService.
 */
public interface UploadService {
	
	/**
	 * Upload.
	 *
	 * @param file the file
	 */
	String upload(MultipartFile file);
}
