package fr.esiea.web.bean;

import java.io.Serializable;

public class AccountFormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6544362802156283452L;
	
	private String firstName;
	private String name;
	private String mail;
	private String login;
	private String password;
	private byte[] photo;
	private String phoneNumber;
	private String number;
	private String street;
	private String establishment;
	private String city;
	private String postcode;
	
	/**
	 * @param firstName
	 * @param name
	 * @param mail
	 * @param login
	 * @param password
	 * @param photo
	 * @param phoneNumber
	 * @param number
	 * @param street
	 * @param establishment
	 * @param city
	 * @param postcode
	 */
	public AccountFormBean(String firstName, String name, String mail,
			String login, String password, byte[] photo, String phoneNumber,
			String number, String street, String establishment, String city,
			String postcode) {
		this.firstName = firstName;
		this.name = name;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.photo = photo;
		this.phoneNumber = phoneNumber;
		this.number = number;
		this.street = street;
		this.establishment = establishment;
		this.city = city;
		this.postcode = postcode;
	}
	/**
	 * 
	 */
	public AccountFormBean() {
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getEstablishment() {
		return establishment;
	}
	public void setEstablishment(String establishment) {
		this.establishment = establishment;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}
