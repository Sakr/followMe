package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.model.ActivityName;

public interface ActivityNameService {
	public ActivityName getActivityNameById(int ActivityNameId);
	public List<ActivityName> listActivityName();
	public void createActivityName(ActivityName activityName);
	public void updateActivityName(ActivityName activityName);
	public void deleteActivityName(int id);
}
