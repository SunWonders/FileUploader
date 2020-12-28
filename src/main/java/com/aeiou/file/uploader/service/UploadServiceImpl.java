package com.aeiou.file.uploader.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.aeiou.file.uploader.dto.ShortnerRequest;
import com.aeiou.file.uploader.dto.ShortnerResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class UploadServiceImpl.
 */
@Service
public class UploadServiceImpl implements UploadService {

	/** The file path. */
	@Value("${image.uploader.storage.path}")
	private String filePath;

	@Value("${fileuploder.http.base.url}")
	private String httpBaseUrl;

	@Value("${urlshortner.url}")
	private String shortUrl;

	/**
	 * Upload.
	 *
	 * @param file the file
	 */
	@Override
	public String upload(MultipartFile file) {
		String httpUrl = "";
		try {

			String randomFilePath = UUID.randomUUID().toString();
			if (file.isEmpty()) {
				// return null;
			}
			Files.createDirectories(Paths.get(filePath + randomFilePath + "/"));
			Path destinationFile = Paths.get(filePath + randomFilePath + "/")
					.resolve(Paths.get(file.getOriginalFilename())).normalize().toAbsolutePath();
			if (!destinationFile.getParent().equals(Paths.get(filePath + randomFilePath + "/").toAbsolutePath())) {

			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
			}
			httpUrl = httpBaseUrl + "?filename=" + file.getOriginalFilename() + "&uniqueCode=" + randomFilePath;
			httpUrl=getShortUrl(httpUrl);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return httpUrl;
	}

	public String getShortUrl(String oldUrl) {
		String responseUrl = "";
		RestTemplate restTemplate = new RestTemplate();
		URI uri;
		try {
			uri = new URI(shortUrl);
			ShortnerRequest shortnerRequest = new ShortnerRequest();
			shortnerRequest.setUrl(oldUrl);
			ResponseEntity<ShortnerResponse> result = restTemplate.postForEntity(uri, shortnerRequest,
					ShortnerResponse.class);
			responseUrl = result.getBody().getShortUrl();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
		return responseUrl;
	}

}
