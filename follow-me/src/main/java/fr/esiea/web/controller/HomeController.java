package fr.esiea.web.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.web.service.AdressService;
import fr.esiea.web.service.UserService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
	private AdressService adressService;
	
	@Autowired(required=true)
	@Qualifier(value="adressService")
	public void setAdressService(AdressService as){
		this.adressService = as;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale) {
		logger.info("Start follow Me");
		
		System.out.println(this.userService.listUser().get(0).toString());
		System.out.println(this.userService.listUser().get(0).getAdress().toString());
		return "index";
	}
	
	
	
}
