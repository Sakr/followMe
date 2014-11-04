package fr.esiea.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiea.web.model.ActivityName;

public class ActivityNameDaoImpl implements ActivityNameDao{

	private static final Logger logger = LoggerFactory.getLogger(ActivityNameDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityName> getAllActivityName() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ActivityName> ActivityNameList = session.createQuery("from ActivityName").list();
		for(ActivityName p : ActivityNameList){
			logger.info("ActivityName List::"+p);
		}
		return ActivityNameList;
	}

	@Override
	public ActivityName getActivityNameById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ActivityName p = (ActivityName) session.load(ActivityName.class, new Integer(id));
		logger.info("ActivityName loaded successfully, ActivityName details="+p);
		return p;
	}

	@Override
	public void createActivityName(ActivityName activityName) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(activityName);
		logger.info("ActivityName saved successfully, ActivityName Details="+activityName);
	}

	@Override
	public void updateActivityName(ActivityName activityName) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(activityName);
		logger.info("ActivityName updated successfully, ActivityName Details="+activityName);
	}

	@Override
	public void deleteActivityName(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ActivityName activityName = (ActivityName) session.load(ActivityName.class, new Integer(id));
		if(null != activityName){
			session.delete(activityName);
		}
		logger.info("ActivityName deleted successfully, ActivityName details="+activityName);
	}

}
