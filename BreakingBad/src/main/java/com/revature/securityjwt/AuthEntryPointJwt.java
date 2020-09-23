/*
 * The AuthEntryPointJwt class implements AuthenticationEntryPoint 
 * interface and overrides the commence() method. 
 * This method will be triggered any time an unauthenticated User requests 
 * a secured HTTP resource and an AuthenticationException is thrown.
 * 
 * HttpServletResponse.SC_UNAUTHORIZED is the 401 Status code. 
 * It indicates that the request requires HTTP authentication.
 */

package com.revature.securityjwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	//private static final Logger logger = (AuthEntryPointJwt.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		//logger.error("Unauthorized error: {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
	}

}
