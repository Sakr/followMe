package fr.esiea.web.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "user")
public class User implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3626151076720697360L;

	private int id;
	private String firstName;
	private String name;
	private String mail;
	private String login;
	private String password;
	private byte[] photo;
	private Adress adress;
	private int phoneNumber;
	private boolean disabled;
	private Date dateCreation;
	
	
	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param name
	 * @param mail
	 * @param login
	 * @param password
	 * @param photo
	 * @param idAdress
	 * @param phoneNumber
	 * @param disabled
	 * @param dateCreation
	 */
	public User(int id, String firstName, String name, String mail,
			String login, String password, byte[] photo, Adress adress,
			int phoneNumber, boolean disabled, Date dateCreation) {
		this.id = id;
		this.firstName = firstName;
		this.name = name;
		this.mail = mail;
		this.login = login;
		this.password = password;
		this.photo = photo;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.disabled = disabled;
		this.dateCreation = dateCreation;
	}


	public User() {
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
	
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="mail")
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name="login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="photo")
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name="id_adress")
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	@Column(name="phone_number")
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="disabled")
	public boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	@Column(name="date_creation")
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", name=" + name
				+ ", mail=" + mail + ", login=" + login + ", password="
				+ password + ", photo=" + Arrays.toString(photo)
				+ ", idAdress=" + adress + ", phoneNumber=" + phoneNumber
				+ ", disabled=" + disabled + ", dateCreation=" + dateCreation
				+ "]";
	}
}
