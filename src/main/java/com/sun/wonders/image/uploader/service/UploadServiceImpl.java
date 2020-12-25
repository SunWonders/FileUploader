package com.sun.wonders.image.uploader.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

// TODO: Auto-generated Javadoc
/**
 * The Class UploadServiceImpl.
 */
@Service
public class UploadServiceImpl implements UploadService {

	/** The file path. */
	@Value("${image.uploader.storage.path}")
	private String filePath;

	/**
	 * Upload.
	 *
	 * @param file the file
	 */
	@Override
	public void upload(MultipartFile file) {

		try {
			if (file.isEmpty()) {

			}
			Path destinationFile = Paths.get(filePath).resolve(Paths.get(file.getOriginalFilename())).normalize()
					.toAbsolutePath();
			if (!destinationFile.getParent().equals(Paths.get(filePath).toAbsolutePath())) {

			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
