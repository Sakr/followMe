package fr.esiea.web.dao;

import java.util.List;

import fr.esiea.web.model.Adress;


public interface AdressDao {
	public Adress getAdressById(int id);
	public List<Adress> getAllAdress();
	public void createAdress(Adress adress);
	public void updateAdress(Adress adress);
	public void deleteAdress(int id);
}
