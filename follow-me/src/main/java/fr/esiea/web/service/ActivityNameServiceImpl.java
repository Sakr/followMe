package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.ActivityNameDao;
import fr.esiea.web.model.ActivityName;

@Service
public class ActivityNameServiceImpl implements ActivityNameService{


	private ActivityNameDao ActivityNameDao;

	public void setActivityNameDAO(ActivityNameDao activityNameDao) {
		this.ActivityNameDao = activityNameDao;
	}

	@Override
	@Transactional
	public List<ActivityName> listActivityName() {
		return this.ActivityNameDao.getAllActivityName();
	}

	@Override
	@Transactional
	public ActivityName getActivityNameById(int id) {
		return this.ActivityNameDao.getActivityNameById(id);
	}

	@Override
	@Transactional
	public void createActivityName(ActivityName activityName) {
		this.ActivityNameDao.createActivityName(activityName);
		
	}

	@Override
	@Transactional
	public void updateActivityName(ActivityName activityName) {
		this.ActivityNameDao.updateActivityName(activityName);
		
	}

	@Override
	@Transactional
	public void deleteActivityName(int id) {
		this.ActivityNameDao.deleteActivityName(id);
	}
}
