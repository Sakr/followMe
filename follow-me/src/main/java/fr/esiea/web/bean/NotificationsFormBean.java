package fr.esiea.web.bean;


public class NotificationsFormBean {
	
	private int idActivityParticipant;
	private int idUser;
	private String mail; 
	private String labelNotification;

	
	/**
	 * @param idActivityParticipant
	 * @param idUser
	 * @param labelNotification
	 */
	public NotificationsFormBean(int idActivityParticipant, int idUser,
			String labelNotification) {
		this.idActivityParticipant = idActivityParticipant;
		this.idUser = idUser;
		this.labelNotification = labelNotification;
	}

	/**
	 * 
	 */
	public NotificationsFormBean() {
	}

	public int getIdActivityParticipant() {
		return this.idActivityParticipant;
	}
	public void setIdActivityParticipant(int idActivityParticipant) {
		this.idActivityParticipant = idActivityParticipant;
	}

	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLabelNotification() {
		return labelNotification;
	}
	public void setLabelNotification(String labelNotification) {
		this.labelNotification = labelNotification;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
