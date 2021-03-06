package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.ActivityDetailDao;
import fr.esiea.web.model.ActivityDetail;

@Service
public class ActivityDetailServiceImpl implements ActivityDetailService{


	private ActivityDetailDao activityDetailDao;

	public void setActivityDetailDAO(ActivityDetailDao activityDetailDao) {
		this.activityDetailDao = activityDetailDao;
	}

	@Override
	@Transactional
	public List<ActivityDetail> listActivityDetail() {
		return this.activityDetailDao.getAllActivityDetail();
	}

	@Override
	@Transactional
	public ActivityDetail getActivityDetailById(int id) {
		return this.activityDetailDao.getActivityDetailById(id);
	}

	@Override
	@Transactional
	public void createActivityDetail(ActivityDetail activityDetail) {
		this.activityDetailDao.createActivityDetail(activityDetail);
		
	}

	@Override
	@Transactional
	public void updateActivityDetail(ActivityDetail activityDetail) {
		this.activityDetailDao.updateActivityDetail(activityDetail);
		
	}

	@Override
	@Transactional
	public void deleteActivityDetail(int id) {
		this.activityDetailDao.deleteActivityDetail(id);
	}

}
