package fr.esiea.web.model;

import java.io.Serializable;
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
@Table(name="activity_detail")
public class ActivityDetail implements Serializable{

	
	private static final long serialVersionUID = -7481516616121199576L;
	
	private int id;
	private User creator;
	private int participantsNumber;
	private int availablePlaces;
	private String description;
	private Date dateCreation;
	private Date effectiveDate;
	private ActivityName nameActivity;
	private int duration;
	private int difficulty;
	private Adress adress;
	/**
	 * 
	 * @param id
	 * @param creator
	 * @param participantsNumber
	 * @param availablePlaces
	 * @param description
	 * @param dateCreation
	 * @param effectiveDate
	 * @param nameActivity
	 * @param duration
	 * @param difficulty
	 * @param adress
	 */
	public ActivityDetail(int id, User creator, int participantsNumber,
			int availablePlaces, String description, Date dateCreation,
			Date effectiveDate, ActivityName nameActivity, int duration,
			int difficulty, Adress adress) {
		this.id = id;
		this.creator = creator;
		this.participantsNumber = participantsNumber;
		this.availablePlaces = availablePlaces;
		this.description = description;
		this.dateCreation = dateCreation;
		this.effectiveDate = effectiveDate;
		this.nameActivity = nameActivity;
		this.duration = duration;
		this.difficulty = difficulty;
		this.adress = adress;
	}
	
	public ActivityDetail() {
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
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name="id_creator")
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	@Column(name="participants_number")
	public int getParticipantsNumber() {
		return participantsNumber;
	}
	public void setParticipantsNumber(int participantsNumber) {
		this.participantsNumber = participantsNumber;
	}
	
	@Column(name="available_places")
	public int getAvailablePlaces() {
		return availablePlaces;
	}
	public void setAvailablePlaces(int availablePlaces) {
		this.availablePlaces = availablePlaces;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="date_creation")
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	@Column(name="effective_date")
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name="id_name_activity")
	public ActivityName getNameActivity() {
		return nameActivity;
	}
	public void setNameActivity(ActivityName nameActivity) {
		this.nameActivity = nameActivity;
	}
	
	@Column(name="duration")
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	@Column(name="difficulty")
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name="id_adress")
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "ActivityDetail [id=" + id + ", creator=" + creator
				+ ", participantsNumber=" + participantsNumber
				+ ", availablePlaces=" + availablePlaces + ", description="
				+ description + ", dateCreation=" + dateCreation
				+ ", effectiveDate=" + effectiveDate + ", nameActivity="
				+ nameActivity + ", duration=" + duration + ", difficulty="
				+ difficulty + ", adress=" + adress + "]";
	}
}
