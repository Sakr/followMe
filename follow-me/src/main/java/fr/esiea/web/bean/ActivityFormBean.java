package fr.esiea.web.bean;

import java.io.Serializable;
import java.util.Date;


public class ActivityFormBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7090920111733626331L;
	
	private int participantsNumber;
	private int availablePlaces;
	private String description;
	private Date dateCreation;
	private Date effectiveDate;
	private String nameActivity;
	private int duration;
	private int difficulty;
	
	private String number;
	private String street;
	private String establishment;
	private String city;
	private String postcode;
	
	private int activityNameId;

	
	
	/**
	 * 
	 */
	public ActivityFormBean() {
		super();
	}

	public int getParticipantsNumber() {
		return participantsNumber;
	}

	public void setParticipantsNumber(int participantsNumber) {
		this.participantsNumber = participantsNumber;
	}

	public int getAvailablePlaces() {
		return availablePlaces;
	}

	public void setAvailablePlaces(int availablePlaces) {
		this.availablePlaces = availablePlaces;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getNameActivity() {
		return nameActivity;
	}

	public void setNameActivity(String nameActivity) {
		this.nameActivity = nameActivity;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
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

	public int getActivityNameId() {
		return activityNameId;
	}

	public void setActivityNameId(int activityNameId) {
		this.activityNameId = activityNameId;
	}
	
	
	
	
	
}
