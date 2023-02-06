package com.example.accessingdatamysql.service.repo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="STUDENTS") // This tells Hibernate to make a table out of this class
public class StudentEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID_STD", updatable=false)	
	private Integer idSTU;

	@Column(name="NAME_STU")
	private String nameSTU;

	@Column(name="CREDIT_STU")
	private String creditSTU;

	StudentEntity() {

	}
	StudentEntity(Integer idSTU, String name, Integer creditSTU) {
		this.idSTU = idSTU;
		this.nameSTU = nameSTU;
		this.creditSTU = creditSTU;
	}
	
	public String getCredit() {
		return creditSTU;
	}
	public Integer getId() {
		return idSTU;
	}
	public String getName() {
		return nameSTU;
	}
	public void setCredit(String creditSTU) {
		this.creditSTU = creditSTU;
	}
	public void setId(Integer idSTU) {
		this.idSTU = idSTU;
	}
	public void setName(String nameSTU) {
		this.nameSTU = nameSTU;
	}
}
