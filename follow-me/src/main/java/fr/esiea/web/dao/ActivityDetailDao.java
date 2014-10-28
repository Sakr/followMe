package fr.esiea.web.dao;

import java.util.List;

import fr.esiea.web.model.ActivityDetail;

public interface ActivityDetailDao {
	public ActivityDetail getActivityDetailById(int id);
	public List<ActivityDetail> getAllActivityDetail();
	public void createActivityDetail(ActivityDetail activityDetail);
	public void updateActivityDetail(ActivityDetail activityDetail);
	public void deleteActivityDetail(int id);
}
