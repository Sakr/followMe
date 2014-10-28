package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.model.ActivityDetail;

public interface ActivityDetailService {
	public ActivityDetail getActivityDetailById(int activityDetailId);
	public List<ActivityDetail> listActivityDetail();
	public void createActivityDetail(ActivityDetail activityDetail);
	public void updateActivityDetail(ActivityDetail activityDetail);
	public void deleteActivityDetail(int id);
}
