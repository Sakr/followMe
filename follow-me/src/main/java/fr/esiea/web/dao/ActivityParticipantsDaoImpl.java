package fr.esiea.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiea.web.model.ActivityParticipants;

public class ActivityParticipantsDaoImpl implements ActivityParticipantsDao{

	private static final Logger logger = LoggerFactory.getLogger(ActivityParticipantsDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityParticipants> getAllActivityParticipant() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ActivityParticipants> ActivityParticipantList = session.createQuery("from ActivityParticipant").list();
		for(ActivityParticipants p : ActivityParticipantList){
			logger.info("ActivityParticipant List::"+p);
		}
		return ActivityParticipantList;
	}

	@Override
	public ActivityParticipants getActivityParticipantById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ActivityParticipants p = (ActivityParticipants) session.load(ActivityParticipants.class, new Integer(id));
		logger.info("ActivityParticipant loaded successfully, ActivityParticipant details="+p);
		return p;
	}

	@Override
	public void createActivityParticipant(ActivityParticipants activityParticipant) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(activityParticipant);
		logger.info("ActivityParticipant saved successfully, ActivityParticipant Details="+activityParticipant);
	}

	@Override
	public void updateActivityParticipant(ActivityParticipants activityParticipant) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(activityParticipant);
		logger.info("ActivityParticipant updated successfully, ActivityParticipant Details="+activityParticipant);
	}

	@Override
	public void deleteActivityParticipant(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ActivityParticipants ActivityParticipant = (ActivityParticipants) session.load(ActivityParticipants.class, new Integer(id));
		if(null != ActivityParticipant){
			session.delete(ActivityParticipant);
		}
		logger.info("ActivityParticipant deleted successfully, ActivityParticipant details="+ActivityParticipant);
	}

}
