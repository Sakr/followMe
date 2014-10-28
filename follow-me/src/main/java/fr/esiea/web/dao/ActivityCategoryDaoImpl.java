package fr.esiea.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiea.web.model.ActivityCategory;

public class ActivityCategoryDaoImpl implements ActivityCategoryDao{

	private static final Logger logger = LoggerFactory.getLogger(ActivityCategoryDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityCategory> getAllActivityCategory() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ActivityCategory> ActivityCategoryList = session.createQuery("from ActivityCategory").list();
		for(ActivityCategory p : ActivityCategoryList){
			logger.info("ActivityCategory List::"+p);
		}
		return ActivityCategoryList;
	}

	@Override
	public ActivityCategory getActivityCategoryById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ActivityCategory p = (ActivityCategory) session.load(ActivityCategory.class, new Integer(id));
		logger.info("ActivityCategory loaded successfully, ActivityCategory details="+p);
		return p;
	}

	@Override
	public void createActivityCategory(ActivityCategory activityCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(activityCategory);
		logger.info("ActivityCategory saved successfully, ActivityCategory Details="+activityCategory);
	}

	@Override
	public void updateActivityCategory(ActivityCategory activityCategory) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(activityCategory);
		logger.info("ActivityCategory updated successfully, ActivityCategory Details="+activityCategory);
	}

	@Override
	public void deleteActivityCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ActivityCategory activityCategory = (ActivityCategory) session.load(ActivityCategory.class, new Integer(id));
		if(null != activityCategory){
			session.delete(activityCategory);
		}
		logger.info("ActivityCategory deleted successfully, ActivityCategory details="+activityCategory);
	}

}
