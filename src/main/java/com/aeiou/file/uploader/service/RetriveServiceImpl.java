package com.aeiou.file.uploader.service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.aeiou.file.uploader.entity.UrlShortner;
import com.aeiou.file.uploader.repo.UrlShortnerRepo;

// TODO: Auto-generated Javadoc
/**
 * The Class RetriveServiceImpl.
 */
@Service
public class RetriveServiceImpl implements RetriveService {

	/** The file path. */
	@Value("${image.uploader.storage.path}")
	private String filePath;

	@Autowired
	private UrlShortnerRepo urlShortnerRepo;

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

	public Path getFileWithUniqueCode(String uniqueCode, String filename) {
		return Paths.get(filePath + uniqueCode + "/").resolve(filename);
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

	@Override
	public Resource loadFileAsResourceWithUniqueCode(String uniqueCode, String filename) {
		try {
			Path file = getFileWithUniqueCode(uniqueCode, filename);
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

	@Override
	public List<UrlShortner> getAllFilesByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return urlShortnerRepo.findByEmailId(emailId);
	}
}
