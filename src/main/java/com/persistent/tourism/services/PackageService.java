package com.persistent.tourism.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.tourism.entities.Pack;
import com.persistent.tourism.repos.PackageRepository;


@Service
public class PackageService {
	@Autowired
	private PackageRepository packageRepository;

	public List<Pack> getAllPackages() {
		return packageRepository.findAll();
	}

	public void savePack(Pack pack) {
		packageRepository.save(pack);
	}

	public Pack getPackageById(long id) {

		
		return packageRepository.findById(id).get();
	}

	public void deletePackageById(long id) {
		
		packageRepository.deleteById(id);
	}



}
