package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.ActivityParticipantsDao;
import fr.esiea.web.model.ActivityParticipants;

@Service
public class ActivityParticipantsServiceImpl implements ActivityParticipantsService {


	private ActivityParticipantsDao ActivityParticipantsDao;

	public void setActivityParticipantsDAO(ActivityParticipantsDao ActivityParticipantsDao) {
		this.ActivityParticipantsDao = ActivityParticipantsDao;
	}

	@Override
	@Transactional
	public List<ActivityParticipants> listActivityParticipants() {
		return this.ActivityParticipantsDao.getAllActivityParticipant();
	}

	@Override
	@Transactional
	public ActivityParticipants getActivityParticipantsById(int id) {
		return this.ActivityParticipantsDao.getActivityParticipantById(id);
	}

	@Override
	@Transactional
	public void createActivityParticipants(ActivityParticipants ActivityParticipants) {
		this.ActivityParticipantsDao.createActivityParticipant(ActivityParticipants);
		
	}

	@Override
	@Transactional
	public void updateActivityParticipants(ActivityParticipants ActivityParticipants) {
		this.ActivityParticipantsDao.updateActivityParticipant(ActivityParticipants);
		
	}

	@Override
	@Transactional
	public void deleteActivityParticipants(int id) {
		this.ActivityParticipantsDao.deleteActivityParticipant(id);
	}

}
