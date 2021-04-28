package com.persistent.tourism.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.persistent.tourism.entities.MyUserDetails;
import com.persistent.tourism.entities.TourismUser;
import com.persistent.tourism.repos.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<TourismUser> user = userRepo.findByMobNo(username);
		if(user.isPresent()) {
			return new MyUserDetails(user.get());
		}
		throw new UsernameNotFoundException("Invalid Details");
	}
	
	
}
