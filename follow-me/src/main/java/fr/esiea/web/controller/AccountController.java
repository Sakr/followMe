package fr.esiea.web.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.web.bean.AccountFormBean;
import fr.esiea.web.model.ActivityDetail;
import fr.esiea.web.model.Adress;
import fr.esiea.web.model.User;
import fr.esiea.web.service.AdressService;
import fr.esiea.web.service.LongitudeLatitudeService;
import fr.esiea.web.service.UserService;
/**
 * @author sakr
 *
 */
@Controller
@SessionAttributes({"accountFormBean","statutAccount"})
public class AccountController extends ConfigController{
	
	@Autowired 
	UserService userService;
	
	@Autowired 
	AdressService adressService;
	
	@RequestMapping(value = "/saveAcount")
	public ModelAndView getAddAcount(ModelMap model,
			@ModelAttribute("accountFormBean")AccountFormBean accountFormBean) {
	
	    ModelAndView mav = new ModelAndView("addAcount");
	    
	    //On recupere les donnees de l'adresse a partir du formulaire
	    Adress adress=new Adress();
	    adress.setNumber(new Integer(accountFormBean.getNumber()));
	    adress.setStreet(accountFormBean.getStreet());
	    adress.setPostcode(new Integer(accountFormBean.getPostcode()));
	    adress.setCity(accountFormBean.getCity());
	    adress.setEstablishment("");
	    
	    //On recupere la longitude et la latitude en fonction de l'adresse de l'utilisateur
	    LongitudeLatitudeService directionService = new LongitudeLatitudeService();
        Map<String,Double> logLatMap= directionService.getLongitudeLatitude(adress);
	    
	    adress.setLatitude(logLatMap.get("latitude"));
	    adress.setLongitude(logLatMap.get("longitude"));
	    
	    
	    adress.setEstablishment("");
	    
	    //On recupere les donnees du formulaire
	    User user=new User();
	    user.setFirstName(accountFormBean.getFirstName());
	    user.setName(accountFormBean.getName());
	    user.setMail(accountFormBean.getMail());
	    user.setLogin(accountFormBean.getLogin());
	    user.setPassword(accountFormBean.getPassword());
	    byte[] photo = "testing photo".getBytes();
		user.setPhoto(photo);
		user.setAdress(adress);
	    user.setPhoneNumber(new Integer(accountFormBean.getPhoneNumber()));
	    user.setDisabled(true);
	    user.setDateCreation(new Date());
	    
	    String randomActivationCode = UUID.randomUUID().toString();
	    user.setActivationCode(randomActivationCode);
	    //On enregistre l'utilisateur sur la bdd
	    userService.createUser(user);
	    
	    //On envoi un mail d'acticvation a l'utilisateur account.activation.text
	    this.sendEmail(messages.getString("account.activation.link"), getActivationUrlByUser(user,messages.getString("account.activation.text")), user.getMail());
	    String statutAccount=messages.getString("account.save.succed");
		
		model.put("accountFormBean", accountFormBean);
		model.put("statutAccount", statutAccount);
		return mav;
	}
	
	@RequestMapping(value = "/activateAccount")
	public ModelAndView activateAccount(ModelMap model,
			@RequestParam(value = "pin", required = true) String pin) {
	
		//Activation du compte
		User user=userService.getUserByActivationCode(pin);
		if(user!=null){
			user.setDisabled(false);
			//On active le comte sur la bdd
			userService.updateUser(user);
		}
		
	    ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	
	@RequestMapping(value = "/resetAcount")
	public ModelAndView resetAcount(ModelMap model) {
		
	    ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	public String getActivationUrlByUser(User user,String text){
		
	    HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		System.out.println(request.getServletPath()); 
		String scheme = request.getScheme()+"://";             // http
		String host = request.getHeader("host");     // localhost:8888
		String generatedUrl = messages.getString("account.activation.link")+": "+text+" "+  scheme+host+"/web/"+"activateAccount?pin="+user.getActivationCode() ;
		return generatedUrl;
	}
}
