package fr.esiea.web.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.esiea.web.dao.AdressDao;
import fr.esiea.web.model.Adress;

@Service
public class AdressServiceImpl implements AdressService{

	private AdressDao AdressDao;

	public void setAdressDAO(AdressDao AdressDao) {
		this.AdressDao = AdressDao;
	}

	@Override
	@Transactional
	public List<Adress> listAdress() {
		return this.AdressDao.getAllAdress();
	}

	@Override
	@Transactional
	public Adress getAdressById(int id) {
		return this.AdressDao.getAdressById(id);
	}

	@Override
	@Transactional
	public void createAdress(Adress adress) {
		this.AdressDao.createAdress(adress);
		
	}

	@Override
	@Transactional
	public void updateAdress(Adress adress) {
		this.AdressDao.updateAdress(adress);
		
	}

	@Override
	@Transactional
	public void deleteAdress(int id) {
		this.AdressDao.deleteAdress(id);
	}

}
