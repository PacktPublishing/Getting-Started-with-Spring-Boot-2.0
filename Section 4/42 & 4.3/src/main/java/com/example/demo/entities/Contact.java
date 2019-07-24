package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private int id;
	
	@Column(name="adress")
	private String adress;
	@Column(name="city")
	private String city;
	
	@OneToOne(mappedBy="contact")
	private Person person;

	public Contact()
	{
		setAdress(" ");
		setCity(" ");
	}
	
	public Contact(String adress, String city)
	{
		setAdress(adress);
		setCity(city);
	}
	public String getAdress() {
		return adress;
	}


	public void setAdress(String address) {
		this.adress = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}
	
}
