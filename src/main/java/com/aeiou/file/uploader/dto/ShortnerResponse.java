package com.aeiou.file.uploader.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class ShortnerResponse.
 */
public class ShortnerResponse {
	
	/** The status. */
	private Integer status;

	/** The message. */
	private String message;

	/** The short url. */
	private String shortUrl;

	/**
	 * Gets the short url.
	 *
	 * @return the short url
	 */
	public String getShortUrl() {
		return shortUrl;
	}

	/**
	 * Sets the short url.
	 *
	 * @param shortUrl the new short url
	 */
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Instantiates a new shortner response.
	 *
	 * @param status the status
	 * @param message the message
	 * @param shortUrl the short url
	 */
	public ShortnerResponse(Integer status, String message, String shortUrl) {
		super();
		this.status = status;
		this.message = message;
		this.shortUrl = shortUrl;
	}

	/**
	 * Instantiates a new shortner response.
	 */
	public ShortnerResponse() {
		super();
	}

}
