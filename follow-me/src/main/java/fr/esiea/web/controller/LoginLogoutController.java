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
 * Handles and retrieves the login or denied page depending on the URI template
 */
@Controller
public class LoginLogoutController {
        
	private static final Logger logger = LoggerFactory.getLogger(LoginLogoutController.class);

	/**
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(value="error", required=false) boolean error, 
			ModelMap model) {
		
		logger.debug("Received request to show login page");
		// Add an error message to the model if login is unsuccessful
		// The 'error' parameter is set to true based on the when the authentication has failed. 
		// We declared this under the defaultFailureUrl attribute inside the spring-security.xml
		if (error == true) {
			// Assign an error message
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	/**
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
 	public ModelAndView getDeniedPage() {
		logger.debug("Received request to show denied page");
		ModelAndView mav = new ModelAndView("denied");
		return mav;
	}
}