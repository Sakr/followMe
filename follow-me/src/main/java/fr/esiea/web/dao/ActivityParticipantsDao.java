package fr.esiea.web.dao;

import java.util.List;

import fr.esiea.web.model.ActivityParticipants;

public interface ActivityParticipantsDao {
	public ActivityParticipants getActivityParticipantById(int id);
	public List<ActivityParticipants> getAllActivityParticipant();
	public void createActivityParticipant(ActivityParticipants activityParticipants);
	public void updateActivityParticipant(ActivityParticipants activityParticipants);
	public void deleteActivityParticipant(int id);
}
