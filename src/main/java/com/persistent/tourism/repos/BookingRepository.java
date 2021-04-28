package com.persistent.tourism.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistent.tourism.entities.Booking;


public interface BookingRepository extends JpaRepository<Booking,Long>{

	List<Booking> findByuid(String uid );

	void deleteBybid(int bid);

	void deleteByUid(String uid);

}
