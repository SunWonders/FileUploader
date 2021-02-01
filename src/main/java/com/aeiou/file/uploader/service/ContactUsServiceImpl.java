package com.aeiou.file.uploader.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeiou.file.uploader.dto.ContactUsRequest;
import com.aeiou.file.uploader.entity.ContactUs;
import com.aeiou.file.uploader.repo.ContactUsRepo;

@Service
public class ContactUsServiceImpl implements ContactUsService {
	
	@Autowired
	private ContactUsRepo contactUsRepo;

	@Override
	public String save(ContactUsRequest contactUsRequest) {
		ContactUs contactUs=new ContactUs();
		contactUs.setCompanyName(contactUsRequest.getCompanyName());
		contactUs.setEmailId(contactUsRequest.getEmailId());
		contactUs.setInsertedDateTime(new Date());
		contactUs.setMessage(contactUsRequest.getMessage());
		contactUs.setName(contactUsRequest.getName());
		contactUs.setPhoneNumber(contactUsRequest.getPhoneNumber());
		contactUs.setUpdatedDateTime(new Date());
		return contactUsRepo.save(contactUs).getId();
	}

}
