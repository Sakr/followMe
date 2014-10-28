package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.model.ActivityCategory;

public interface ActivityCategoryService {
	public ActivityCategory getActivityCategoryById(int activityCategoryId);
	public List<ActivityCategory> listActivityCategory();
	public void createActivityCategory(ActivityCategory activityCategory);
	public void updateActivityCategory(ActivityCategory activityCategory);
	public void deleteActivityCategory(int id);
}
