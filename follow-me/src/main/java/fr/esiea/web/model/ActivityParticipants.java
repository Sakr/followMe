package fr.esiea.web.model;

import java.io.Serializable;

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
@Table(name="activity_participants")
public class ActivityParticipants implements Serializable{
	
	private static final long serialVersionUID = -7586169084888167513L;
	private int id;
	private ActivityDetail activityDetail;
	private User participant;
	private boolean accepted;

	/**
	 * 
	 * @param id
	 * @param activityDetail
	 * @param participant
	 */
	public ActivityParticipants(int id, ActivityDetail activityDetail, User participant) {
		this.id = id;
		this.activityDetail = activityDetail;
		this.participant = participant;
	}
	
	public ActivityParticipants() {
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
	@JoinColumn(name="id_activity")
	public ActivityDetail getActivityDetail() {
		return activityDetail;
	}

	public void setActivityDetail(ActivityDetail activityDetail) {
		this.activityDetail = activityDetail;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name="id_participant")
	public User getParticipant() {
		return participant;
	}

	public void setParticipant(User participant) {
		this.participant = participant;
	}

	
	@Column(name="accepted")
	public boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	@Override
	public String toString() {
		return "ActivityParticipants [id=" + id + ", activityDetail="
				+ activityDetail + ", participant=" + participant + "]";
	}

	
}
