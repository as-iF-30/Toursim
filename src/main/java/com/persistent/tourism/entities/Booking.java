package com.persistent.tourism.entities;

import java.time.LocalDate;
//import java.util.Date; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int bid; //booking id
	private String uid; //user id
	private Long pid; //package id
	private double cost;
	private String name;
	private String email;
	private int noOfPeople;
	private LocalDate date;

	public Booking() {

	}

	public Booking(int bid, String uid, Long pid, double cost, String name, String email, int noOfPeople,LocalDate date) {
		super();
		this.bid = bid;
		this.uid = uid;
		this.pid = pid;
		this.cost = cost;
		this.name = name;
		this.email = email;
		this.noOfPeople = noOfPeople;
		this.date = date;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public LocalDate getDate() {
		return date;
	} 
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Booking [bid=" + bid + ", uid=" + uid + ", pid=" + pid + ", cost=" + cost + ", name=" + name
				+ ", email=" + email + ", noOfPeople=" + noOfPeople + ", date=" + date + "]";
	}


}
