package fr.esiea.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.esiea.web.bean.AccountFormBean;

/**
 * @author sakr
 *
 */
@Controller
@SessionAttributes({"accountFormBean"})
public class HomeController extends ConfigController{
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model) {
		logger.info("Start follow Me");
		
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	
	@RequestMapping(value = "/addAcount", method = RequestMethod.GET)
	public ModelAndView getAddAcount(ModelMap model) {
	
	    ModelAndView mav = new ModelAndView("addAcount");
		AccountFormBean accountFormBean=new AccountFormBean();
		model.put("accountFormBean", accountFormBean);
		
		return mav;
	}
}