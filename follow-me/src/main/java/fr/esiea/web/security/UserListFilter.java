package fr.esiea.web.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * A custom filter that denies access if the given username is equal to
 * <b>mike</b>. This filter extends the {@link OncePerRequestFilter} to
 * guarantee that this filter is executed just once.
 * <p>
 * When the user enters this filter, he is already authenticated. This
 * filters acts like an intercept-url where you can customize access levels
 * per user
 *
 */
public class UserListFilter extends OncePerRequestFilter {

	private static final Logger logger = LoggerFactory.getLogger(UserListFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		logger.debug("Running blacklist filter");
		
		// Retrieve user details
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Filter only if user details is not empty; otherwise there's nothing to filter
        if (authentication != null) {
        	/**
        	 * Ici nous sommes cens� verifier si l'utilisateur fait parties des utilisateurs ayant le droit d'utiliser l'appli
        	 * Nous ne l'avons pas implementer non plus pour cette version de l'application
        	 */
        }
        
        // User details are not empty
        logger.debug("Continue with remaining filters");
        filterChain.doFilter(request, response);
	}

}
