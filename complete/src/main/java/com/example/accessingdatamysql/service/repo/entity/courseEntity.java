package com.example.accessingdatamysql.service.repo.entity;

import java.sql.Timestamp;

import javax.swing.event.InternalFrameAdapter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="COURSE") // This tells Hibernate to make a table out of this class
public class CourseEntity{
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID", updatable=false)	
	private Integer id;

	@Column(name="NAME")
	private String name;

	@Column(name="CREDIT")
	private Integer credit;

	@Column(name="MAXSEAT", updatable=false)
	private Integer maxSeat;

	public CourseEntity(){

	}

	public CourseEntity(Integer id, String name, Integer credit, Integer maxSeat) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.maxSeat = maxSeat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public String getMaxSeat() {
		return maxSeat;
	}

	public void setMaxSeat(String maxSeat) {
		this.maxSeat = maxSeat;
	}

}
