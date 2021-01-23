package com.aeiou.file.uploader.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aeiou.file.uploader.entity.UrlShortner;

// TODO: Auto-generated Javadoc
/**
 * The Interface UrlShortnerRepo.
 */
public interface UrlShortnerRepo extends CrudRepository<UrlShortner, String> {
	
	/**
	 * Find by short url.
	 *
	 * @param shortUrl the short url
	 * @return the url shortner
	 */
	UrlShortner findByShortUrl(String shortUrl);
	
	List<UrlShortner> findByEmailId(String emailId);
}
