package com.aeiou.file.uploader.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class ShortnerRequest.
 */
public class ShortnerRequest {

	/** The url. */
	private String url;
	
	/** The generate new url. */
	Boolean generateNewUrl;
	

	/**
	 * Gets the generate new url.
	 *
	 * @return the generate new url
	 */
	public Boolean getGenerateNewUrl() {
		return generateNewUrl;
	}

	/**
	 * Sets the generate new url.
	 *
	 * @param generateNewUrl the new generate new url
	 */
	public void setGenerateNewUrl(Boolean generateNewUrl) {
		this.generateNewUrl = generateNewUrl;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	

}
