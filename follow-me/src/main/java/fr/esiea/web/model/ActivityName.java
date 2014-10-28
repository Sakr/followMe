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
@Table(name="activity_name")
public class ActivityName implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8262865524316630182L;
	
	private int id;
	private String name;
	private ActivityCategory activityCategory;
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param idCategory
	 */
	public ActivityName(int id, String name, ActivityCategory activityCategory) {
		this.id = id;
		this.name = name;
		this.activityCategory = activityCategory;
	}

	public ActivityName() {
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

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
	@JoinColumn(name="id_category")
	public ActivityCategory getIdCategory() {
		return activityCategory;
	}

	public void setIdCategory(ActivityCategory activityCategory) {
		this.activityCategory = activityCategory;
	}

	@Override
	public String toString() {
		return "ActivityName [id=" + id + ", name=" + name + ", idCategory="
				+ activityCategory + "]";
	}
}
