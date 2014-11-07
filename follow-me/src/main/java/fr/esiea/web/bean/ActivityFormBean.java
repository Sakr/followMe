package fr.esiea.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.esiea.web.model.ActivityName;


public class ActivityFormBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7090920111733626331L;
	
	private String participantsNumber;
	private String availablePlaces;
	private String description;
	private Date dateCreation;
	private Date effectiveDate;
	private String nameActivity;
	private String duration;
	private String difficulty;
	
	private String number;
	private String street;
	private String establishment;
	private String city;
	private String postcode;
	
	private String activityNameId;

	private List<ActivityName> listNameActivity=new ArrayList<ActivityName>();
	
	/**
	 * 
	 */
	public ActivityFormBean() {
		super();
	}

	public String getParticipantsNumber() {
		return participantsNumber;
	}

	public void setParticipantsNumber(String participantsNumber) {
		this.participantsNumber = participantsNumber;
	}

	public String getAvailablePlaces() {
		return availablePlaces;
	}

	public void setAvailablePlaces(String availablePlaces) {
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
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

	public String getActivityNameId() {
		return activityNameId;
	}

	public void setActivityNameId(String activityNameId) {
		this.activityNameId = activityNameId;
	}

	public List<ActivityName> getListNameActivity() {
		return listNameActivity;
	}

	public void setListNameActivity(List<ActivityName> listNameActivity) {
		this.listNameActivity = listNameActivity;
	}
}
