package com.persistent.tourism.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.persistent.tourism.entities.TourismUser;


public interface UserRepo extends JpaRepository<TourismUser, Long> {

	Optional<TourismUser> findByMobNo(String mobNo);

	void deleteByMobNo(String mobNo);
}
