package fr.esiea.web.controller;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import fr.esiea.web.model.User;
import fr.esiea.web.service.UserService;
/**
 * Ce controlleur regroupe l'ensemble des methodes necessaire au fonctionnement de tous les uatre controlleur
 * @author sakr
 *
 */
public class ConfigController {
	
	
	/**
	 * Fichier messages.properties
	 */
	protected static ResourceBundle messages = ResourceBundle.getBundle( "messages", Locale.FRANCE);
	protected static ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
	public ConfigController(){
        resourceBundleMessageSource.setBasename("messages");
	}
	
	/**
	 * Methode pour recuperer l'utilisateur connecté
	 */
	@Autowired
	private UserService userService;
	public User getCurrentUserSession(){
		List<User> authorizedListUser=userService.listUser();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); 
        User connectedUser=null;
        for(User user:authorizedListUser){
        	if(user.getLogin().equals(name)&&user.getPassword().equals((String)auth.getCredentials())){
        		connectedUser=user;
        	}
        }
		return connectedUser;
	}
	
	/**
	 * Methode pour envoyer un mail
	 */
	@Autowired
    private JavaMailSender mailSender;
	public void sendEmail(final String subject,final String content,final String mailTo){
		
			mailSender.send(new MimeMessagePreparator() {
			@Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(mailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(content);
            }
		});
	}
	
	
	
	
	
}
