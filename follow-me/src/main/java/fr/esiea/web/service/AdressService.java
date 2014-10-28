package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.model.Adress;

public interface AdressService {
	public Adress getAdressById(int AdressId);
	public List<Adress> listAdress();
	public void createAdress(Adress Adress);
	public void updateAdress(Adress Adress);
	public void deleteAdress(int id);
}
