package com.persistent.tourism.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TourismUser {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;
	private String mobNo;
	private String firstName;
	private String lastName;
	private String password;
	

	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TourismUser [mobNo=" + mobNo + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", id=" + id + "]";
	}

}
