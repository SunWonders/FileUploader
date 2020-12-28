package com.aeiou.file.uploader.service;

import java.nio.file.Path;

import org.springframework.core.io.Resource;

// TODO: Auto-generated Javadoc
/**
 * The Interface RetriveService.
 */
public interface RetriveService {

	/**
	 * Gets the file.
	 *
	 * @param filename the filename
	 * @return the file
	 */
	Path getFile(String filename);

	/**
	 * Load file as resource.
	 *
	 * @param filename the filename
	 * @return the resource
	 */
	Resource loadFileAsResource(String filename);

	Resource loadFileAsResourceWithUniqueCode(String uniqueCode, String filename);

}
