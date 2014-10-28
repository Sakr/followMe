package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.ActivityCategoryDao;
import fr.esiea.web.model.ActivityCategory;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService{


	private ActivityCategoryDao ActivityCategoryDao;

	public void setActivityCategoryDAO(ActivityCategoryDao activityCategoryDao) {
		this.ActivityCategoryDao = activityCategoryDao;
	}

	@Override
	@Transactional
	public List<ActivityCategory> listActivityCategory() {
		return this.ActivityCategoryDao.getAllActivityCategory();
	}

	@Override
	@Transactional
	public ActivityCategory getActivityCategoryById(int id) {
		return this.ActivityCategoryDao.getActivityCategoryById(id);
	}

	@Override
	@Transactional
	public void createActivityCategory(ActivityCategory activityCategory) {
		this.ActivityCategoryDao.createActivityCategory(activityCategory);
		
	}

	@Override
	@Transactional
	public void updateActivityCategory(ActivityCategory activityCategory) {
		this.ActivityCategoryDao.updateActivityCategory(activityCategory);
		
	}

	@Override
	@Transactional
	public void deleteActivityCategory(int id) {
		this.ActivityCategoryDao.deleteActivityCategory(id);
	}

}
