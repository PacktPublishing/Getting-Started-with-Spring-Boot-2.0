package com.example.demo.entities;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="firstname", length=20, nullable=false)
	private String firstName;
	
	@Column(name="lastname", length=20, nullable=false)
	private String lastName;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
	private Contact contact;
	
	public Person()
	{
		this.firstName="";
		this.lastName="";
	}
	
	public Person(String firstName, String lastName, Contact contact)
	{
		setFirstName(firstName);
		setLastName(lastName);
		this.contact=contact;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


}
