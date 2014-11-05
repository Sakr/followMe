/**
 * 
 */
package fr.esiea.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author sakr
 *
 */
@Controller
public class LoginLogoutController {
        
	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model) {
		
		logger.debug("Received request to show login page");
		if (error == true) {
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
 	public ModelAndView getDeniedPage() {
		logger.debug("Received request to show denied page");
		ModelAndView mav = new ModelAndView("denied");
		return mav;
	}
}