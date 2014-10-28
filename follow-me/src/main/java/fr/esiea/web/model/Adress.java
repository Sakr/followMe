package fr.esiea.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "adress")
public class Adress implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5772748487942252584L;
	private int id;
	private int number;
	private String street;
	private String establishment;
	private String city;
	private int postcode;
	private Double latitude;
	private Double longitude;
	
	/**
	 * @param id
	 * @param number
	 * @param street
	 * @param establishment
	 * @param postcode
	 * @param latitude
	 * @param longitude
	 */
	public Adress(int id, int number, String street, String establishment,String city,
			int postcode, Double latitude, Double longitude) {
		this.id = id;
		this.number = number;
		this.street = street;
		this.establishment = establishment;
		this.city = city;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Adress() {
	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="number")
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Column(name="street")
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(name="establishment")
	public String getEstablishment() {
		return establishment;
	}
	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}
	
	@Column(name="city")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="postcode")
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	@Column(name="latitude")
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	@Column(name="longitude")
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", number=" + number + ", street=" + street
				+ ", establishment=" + establishment + ", city=" + city
				+ ", postcode=" + postcode + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
}
