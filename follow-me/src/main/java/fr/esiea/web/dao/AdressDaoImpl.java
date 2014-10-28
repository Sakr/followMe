package fr.esiea.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiea.web.model.Adress;

public class AdressDaoImpl implements AdressDao{

	private static final Logger logger = LoggerFactory.getLogger(AdressDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Adress> getAllAdress() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Adress> AdressList = session.createQuery("from Adress").list();
		for(Adress p : AdressList){
			logger.info("Adress List::"+p);
		}
		return AdressList;
	}

	@Override
	public Adress getAdressById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Adress p = (Adress) session.load(Adress.class, new Integer(id));
		logger.info("Adress loaded successfully, Adress details="+p);
		return p;
	}

	@Override
	public void createAdress(Adress Adress) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(Adress);
		logger.info("Adress saved successfully, Adress Details="+Adress);
	}

	@Override
	public void updateAdress(Adress Adress) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Adress);
		logger.info("Adress updated successfully, Adress Details="+Adress);
	}

	@Override
	public void deleteAdress(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Adress Adress = (Adress) session.load(Adress.class, new Integer(id));
		if(null != Adress){
			session.delete(Adress);
		}
		logger.info("Adress deleted successfully, Adress details="+Adress);
	}

}
