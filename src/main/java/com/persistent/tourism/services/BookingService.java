package com.persistent.tourism.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.tourism.entities.Booking;

import com.persistent.tourism.repos.BookingRepository;

@Service
@Transactional
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepo;

	public List<Booking> findByUser(String uid){
		return bookingRepo.findByuid(uid);
		
	}
	
	public void deleteBooking(int bid) {
		bookingRepo.deleteBybid(bid);
	}

	public void deleteByUser(String uid) {
		bookingRepo.deleteByUid(uid);
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
	}
	
	public void saveBooking(Booking booking) {
		bookingRepo.save(booking);//noted
	}

	
}
