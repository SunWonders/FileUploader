package com.aeiou.file.uploader.service;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.aeiou.file.uploader.dto.ShortnerRequest;
import com.aeiou.file.uploader.dto.ShortnerResponse;
import com.aeiou.file.uploader.util.CustomMailSender;

// TODO: Auto-generated Javadoc
/**
 * The Class UploadServiceImpl.
 */
@Service
public class UploadServiceImpl implements UploadService {

	private static final String[] HEADERS_TO_TRY = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP", "HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR" };

	/** The file path. */
	@Value("${image.uploader.storage.path}")
	private String filePath;

	@Value("${fileuploder.http.base.url}")
	private String httpBaseUrl;

	@Value("${urlshortner.url}")
	private String shortUrl;

	@Autowired
	private CustomMailSender mailSender;

	/**
	 * Upload.
	 *
	 * @param file the file
	 */
	@Override
	public String upload(MultipartFile file, HttpServletRequest request, String emailId, Integer countToDownload) {
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

			httpUrl = getShortUrl(request, emailId, countToDownload, httpUrl,file.getSize());

		} catch (Exception e) {
			e.printStackTrace();
			// try {
			// mailSender.confirmRegistration(e);
			// } catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
			// }
			return null;
		}
		return httpUrl;
	}

	private String getShortUrl(HttpServletRequest request, String emailId, Integer countToDownload, String httpUrl,Long sizeOfFile) {
		ShortnerRequest shortnerRequest = new ShortnerRequest();
		shortnerRequest.setUrl(httpUrl);
		shortnerRequest.setClientIpAddress(getClientIpAddress(request));
		shortnerRequest.setSizeOfFile(sizeOfFile);
		if (emailId != null && !emailId.isEmpty()) {
			shortnerRequest.setEmailId(emailId);
		}
		if (countToDownload != null) {
			if (countToDownload == 0) {
				countToDownload = 10;
			}
			shortnerRequest.setCountToDownload(countToDownload);
		}
		String responseUrl = "";
		RestTemplate restTemplate = new RestTemplate();
		URI uri;
		try {
			uri = new URI(shortUrl);

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

	private String getClientIpAddress(HttpServletRequest request) {
		for (String header : HEADERS_TO_TRY) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteAddr();
	}

}
