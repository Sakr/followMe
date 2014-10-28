package fr.esiea.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiea.web.model.ActivityDetail;

public class ActivityDetailDaoImpl implements ActivityDetailDao{

	private static final Logger logger = LoggerFactory.getLogger(ActivityDetailDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ActivityDetail> getAllActivityDetail() {
		Session session = this.sessionFactory.getCurrentSession();
		List<ActivityDetail> activityDetailList = session.createQuery("from ActivityDetail").list();
		for(ActivityDetail p : activityDetailList){
			logger.info("ActivityDetail List::"+p);
		}
		return activityDetailList;
	}

	@Override
	public ActivityDetail getActivityDetailById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		ActivityDetail p = (ActivityDetail) session.load(ActivityDetail.class, new Integer(id));
		logger.info("ActivityDetail loaded successfully, ActivityDetail details="+p);
		return p;
	}

	@Override
	public void createActivityDetail(ActivityDetail activityDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(activityDetail);
		logger.info("ActivityDetail saved successfully, ActivityDetail Details="+activityDetail);
	}

	@Override
	public void updateActivityDetail(ActivityDetail activityDetail) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(activityDetail);
		logger.info("ActivityDetail updated successfully, ActivityDetail Details="+activityDetail);
	}

	@Override
	public void deleteActivityDetail(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ActivityDetail activityDetail = (ActivityDetail) session.load(ActivityDetail.class, new Integer(id));
		if(null != activityDetail){
			session.delete(activityDetail);
		}
		logger.info("ActivityDetail deleted successfully, ActivityDetail details="+activityDetail);
	}

}
