package com.persistent.tourism.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.persistent.tourism.entities.TourismUser;
import com.persistent.tourism.repos.UserRepo;

@Service
@Transactional
public class ContService {

	@Autowired
	private UserRepo userRepo;
	
	public Boolean SaveUser(TourismUser tourismUser) {
		if(userRepo.findByMobNo(tourismUser.getMobNo()).isPresent()) {
			return false;
		}
		userRepo.save(tourismUser);
		return true;
	}
	
	@Transactional
	public void deleteUser(String mobNo) {
		userRepo.deleteByMobNo(mobNo);
	}
	
	
	
}
