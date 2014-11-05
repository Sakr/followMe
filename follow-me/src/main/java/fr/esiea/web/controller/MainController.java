package fr.esiea.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.web.model.User;
/**
 * @author sakr
 *
 */
@Controller
@SessionAttributes({"error","connectedUser"})
public class MainController extends ConfigController{
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView getCommonPage(@RequestParam(value="error", required=false) boolean error,
    		ModelMap model) {
    	logger.debug("Launch user page");
    	User connectedUser=null;
    	if(this.getCurrentUserSession()==null){
    		error=true;
    	}else{
    		connectedUser=this.getCurrentUserSession();
    	}
    	
        ModelAndView mav;
        if(error){
        	model.put("error",messages.getString( "login.failed.userOrPassword"));
        	mav = new ModelAndView("login");
        }else{
        	if(connectedUser.getDisabled()){
        		model.put("error",messages.getString( "login.failed.disabled"));
            	mav = new ModelAndView("login");
        	}else{
        		mav = new ModelAndView("user");
            	model.put("connectedUser", connectedUser);
        	}
        	
        }
        
		
    	return mav;
	}
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView getAdminPage() {
    	
    	logger.debug("Launch admin page");
		ModelAndView mav = new ModelAndView("admin");
    	return mav;
	}
}
