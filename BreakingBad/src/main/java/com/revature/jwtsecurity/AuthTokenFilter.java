/*
 * Defines a filter that executes once per request. 
 * Creates AuthTokenFilter class that extends OncePerRequestFilter and
 * overrides doFilterInternal() method.
 * 
 * What happens inside doFilterInternal():
 * – gets JWT from the Authorization header (by removing Bearer prefix)
 * – if the request has JWT, validates it, parses email from it
 * – from email, get UserDetails to create an Authentication object
 * – sets the current UserDetails in SecurityContext using setAuthentication(authentication) method.

 * After this, everytime we want to get UserDetails, 
 * just use SecurityContext like this:
 * UserDetails userDetails =
	(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

 *     userDetails.getEmail()
 *     userDetails.getPassword()
 */

package com.revature.jwtsecurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.revature.jwtservices.IUserDetailsDAO;
import com.revature.jwtservices.UserDetailsServiceDAO;

public class AuthTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserDetailsServiceDAO userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				String email = jwtUtils.getUserNameFromJwtToken(jwt);

				IUserDetailsDAO userDetails = userDetailsService.loadUserByEmail(email);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null);
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			System.out.println("Cannot set user authentication: {}");
		}

		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}

