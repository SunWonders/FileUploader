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
	
	/** The count to download. */
	private Integer countToDownload;

	/** The no of times downloaded. */
	private Integer noOfTimesDownloaded;

	/** The client ip address. */
	private String clientIpAddress;

	/** The email id. */
	private String emailId;
	
	/** The user name. */
	private String userName;
	
	
	private Long sizeOfFile;

	public Integer getCountToDownload() {
		return countToDownload;
	}

	public void setCountToDownload(Integer countToDownload) {
		this.countToDownload = countToDownload;
	}

	public Integer getNoOfTimesDownloaded() {
		return noOfTimesDownloaded;
	}

	public void setNoOfTimesDownloaded(Integer noOfTimesDownloaded) {
		this.noOfTimesDownloaded = noOfTimesDownloaded;
	}

	public String getClientIpAddress() {
		return clientIpAddress;
	}

	public void setClientIpAddress(String clientIpAddress) {
		this.clientIpAddress = clientIpAddress;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getSizeOfFile() {
		return sizeOfFile;
	}

	public void setSizeOfFile(Long sizeOfFile) {
		this.sizeOfFile = sizeOfFile;
	}

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
