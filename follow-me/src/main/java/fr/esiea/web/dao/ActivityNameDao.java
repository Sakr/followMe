package fr.esiea.web.dao;

import java.util.List;

import fr.esiea.web.model.ActivityName;

public interface ActivityNameDao {
	public ActivityName getActivityNameById(int id);
	public List<ActivityName> getAllActivityName();
	public void createActivityName(ActivityName activityName);
	public void updateActivityName(ActivityName activityName);
	public void deleteActivityName(int id);
}
