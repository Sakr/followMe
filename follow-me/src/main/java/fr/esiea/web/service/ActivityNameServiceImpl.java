package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.ActivityNameDao;
import fr.esiea.web.model.ActivityName;

@Service
public class ActivityNameServiceImpl implements ActivityNameService{


	private ActivityNameDao activityNameDao;

	public void setActivityNameDAO(ActivityNameDao activityNameDao) {
		this.activityNameDao = activityNameDao;
	}

	@Override
	@Transactional
	public List<ActivityName> listActivityName() {
		return this.activityNameDao.getAllActivityName();
	}

	@Override
	@Transactional
	public ActivityName getActivityNameById(int id) {
		return this.activityNameDao.getActivityNameById(id);
	}

	@Override
	@Transactional
	public void createActivityName(ActivityName activityName) {
		this.activityNameDao.createActivityName(activityName);
		
	}

	@Override
	@Transactional
	public void updateActivityName(ActivityName activityName) {
		this.activityNameDao.updateActivityName(activityName);
		
	}

	@Override
	@Transactional
	public void deleteActivityName(int id) {
		this.activityNameDao.deleteActivityName(id);
	}
}
