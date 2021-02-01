package com.aeiou.file.uploader.repo;

import org.springframework.data.repository.CrudRepository;

import com.aeiou.file.uploader.entity.UserSubscriptions;

public interface SubscriptionRepo extends CrudRepository<UserSubscriptions, String>{

}
