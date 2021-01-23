package com.aeiou.file.uploader.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeiou.file.uploader.dto.StatusUpdateRequest;
import com.aeiou.file.uploader.entity.UrlShortner;
import com.aeiou.file.uploader.repo.UrlShortnerRepo;

@Service
public class StatusUpdateServiceImpl implements StatusUpdateService {

	@Autowired
	private UrlShortnerRepo urlShortnerRepo;
	
	@Override
	public String updateStatus(StatusUpdateRequest statusUpdateRequest) {
		// TODO Auto-generated method stub
		Optional<UrlShortner> urlShortners = urlShortnerRepo.findById(statusUpdateRequest.getId());
		UrlShortner urlShortner=urlShortners.get();
		urlShortner.setIsActive(statusUpdateRequest.getIsActive());
		urlShortner.setUpdatedDateTime(new Date());
		urlShortnerRepo.save(urlShortner);
		return urlShortner.getId();
	}

}
