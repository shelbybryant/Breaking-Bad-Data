/*
 * This class has 3 functions:
 * 1. generate a JWT from email, date, expiration, secret
 * 2. get email from JWT
 * 3. validate a JWT
 */

package com.revature.securityjwt;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.revature.servicesjwt.ImpUDService;
import com.revature.servicesjwt.ImpsUDetails;

//import com.revature.security.UserDetailsDAO;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
	//private static final Logger logger = (JwtUtils.class);

	@Value("")
	private String jwtSecret;

	@Value("")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {

		ImpsUDetails userPrincipal = (ImpsUDetails) authentication.getPrincipal();
		
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			//logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			//logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			//logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			//logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			//logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
