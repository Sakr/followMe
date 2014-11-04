package fr.esiea.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

public class CustomAuthenticationManager implements AuthenticationManager {

	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationManager.class);
	

	//private Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
	
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {

		logger.debug("Performing custom authentication");
		
		/**
		 * Normalement ici nous nous connectons à la base de donées pour verfier les données de l'utilisateur
		 * Nous le faisons au niveau du controlleur comme nous n'avons pas encore implementer toutes les fonctionnalités
		 * liées au profils (Admin Anonymous et User). Tous utilisateur sera connecté autant que user pour cette version la de notre 
		 * application
		 */
		
		if (auth.getName().equals(auth.getCredentials()) == true) {
			logger.debug("Entered username and password are the same!");
			throw new BadCredentialsException("Entered username and password are the same!");
			
		} else {
			/**
			 * Access level of the user. 
			 * 1 = Admin user
			 * 2 = Regular user
			 */
			logger.debug("User details are good and ready to go");
			return new UsernamePasswordAuthenticationToken(
					auth.getName(), 
					auth.getCredentials(), 
					getAuthorities(1));
		}
	}
	
	/**
	 * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
	 * Basically, this interprets the access value whether it's for a regular user or admin.
	 * 
	 * @param access an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	 public Collection<GrantedAuthority> getAuthorities(Integer access) {
			// Create a list of grants for this user
			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
			
			// All users are granted with ROLE_USER access
			logger.debug("Grant ROLE_USER to this user");
			authList.add(new GrantedAuthorityImpl("ROLE_USER"));
			
			// Check if this user has admin access 
			// We interpret Integer(1) as an admin user
			if ( access.compareTo(1) == 0) {
				// User has admin access
				logger.debug("Grant ROLE_ADMIN to this user");
				authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			}

			// Return list of granted authorities
			return authList;
	  }

}
