package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.model.ActivityParticipants;

public interface ActivityParticipantsService {
	
	public ActivityParticipants getActivityParticipantsById(int ActivityParticipantsId);
	public List<ActivityParticipants> listActivityParticipants();
	public void createActivityParticipants(ActivityParticipants ActivityParticipants);
	public void updateActivityParticipants(ActivityParticipants ActivityParticipants);
	public void deleteActivityParticipants(int id);
}
