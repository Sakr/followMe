package fr.esiea.web.dao;

import java.util.List;

import fr.esiea.web.model.ActivityCategory;

public interface ActivityCategoryDao {
	public ActivityCategory getActivityCategoryById(int id);
	public List<ActivityCategory> getAllActivityCategory();
	public void createActivityCategory(ActivityCategory activityCategory);
	public void updateActivityCategory(ActivityCategory activityCategory);
	public void deleteActivityCategory(int id);
}
