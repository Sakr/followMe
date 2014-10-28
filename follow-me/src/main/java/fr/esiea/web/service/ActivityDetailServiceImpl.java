package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.ActivityDetailDao;
import fr.esiea.web.model.ActivityDetail;

@Service
public class ActivityDetailServiceImpl implements ActivityDetailService{


	private ActivityDetailDao ActivityDetailDao;

	public void setActivityDetailDAO(ActivityDetailDao activityDetailDao) {
		this.ActivityDetailDao = activityDetailDao;
	}

	@Override
	@Transactional
	public List<ActivityDetail> listActivityDetail() {
		return this.ActivityDetailDao.getAllActivityDetail();
	}

	@Override
	@Transactional
	public ActivityDetail getActivityDetailById(int id) {
		return this.ActivityDetailDao.getActivityDetailById(id);
	}

	@Override
	@Transactional
	public void createActivityDetail(ActivityDetail activityDetail) {
		this.ActivityDetailDao.createActivityDetail(activityDetail);
		
	}

	@Override
	@Transactional
	public void updateActivityDetail(ActivityDetail activityDetail) {
		this.ActivityDetailDao.updateActivityDetail(activityDetail);
		
	}

	@Override
	@Transactional
	public void deleteActivityDetail(int id) {
		this.ActivityDetailDao.deleteActivityDetail(id);
	}

}
