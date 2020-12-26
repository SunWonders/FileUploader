package com.aeiou.file.uploader.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class RetriveServiceImpl.
 */
@Service
public class RetriveServiceImpl implements RetriveService {

	/** The file path. */
	@Value("${image.uploader.storage.path}")
	private String filePath;

	/**
	 * Gets the file.
	 *
	 * @param filename the filename
	 * @return the file
	 */
	@Override
	public Path getFile(String filename) {
		return Paths.get(filePath).resolve(filename);
	}

	/**
	 * Load file as resource.
	 *
	 * @param filename the filename
	 * @return the resource
	 */
	@Override
	public Resource loadFileAsResource(String filename) {
		try {
			Path file = getFile(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				return null;

			}
		} catch (MalformedURLException e) {
			return null;
		}
	}

}
