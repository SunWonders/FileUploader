package com.aeiou.file.uploader.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class UploadResponse.
 */
public class UploadResponse {

	/** The status. */
	private Integer status;
	
	/** The message. */
	private String message;

	private String shortUrl;
	
	public String getShortUrl() {
		return shortUrl;
	}

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

	public UploadResponse(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public UploadResponse(Integer status, String message, String shortUrl) {
		super();
		this.status = status;
		this.message = message;
		this.shortUrl = shortUrl;
	}
	
}
