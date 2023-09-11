package com.seclore.main.security;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * The JWTUtil class provides utility methods for creating and validating JSON Web Tokens (JWTs).
 * It uses a secret key to sign and verify tokens.
 */
@Component
public class JWTUtil {

	/**
     * The secret key used for JWT generation and validation.
     */
	@Value("${application.security.jwt.secret-key}")
	private String secretKey;

	/**
     * Initialize the JWTUtil by encoding the secret key to avoid having the raw secret key
     * available in the JVM.
     */
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}

	/**
     * Create a JWT token with the specified login(user id) and a 1-hour expiration time.
     *
     * @param login The login or issuer of the token.
     * @return A JWT token as a String.
     */
	public String createToken(String login) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + 3600000); // 1 hour

		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		return JWT.create().withIssuer(login).withIssuedAt(now).withExpiresAt(validity).sign(algorithm);
	}

	/**
     * Validate a JWT token and extract the user ID (issuer) from it.
     *
     * @param token The JWT token to validate.
     * @return The user ID extracted from the token as an integer.
     */
	public int validateTokenAndGetUserId(String token) {
		Algorithm algorithm = Algorithm.HMAC256(secretKey);
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decodedJwt = verifier.verify(token);
		String userIdString = decodedJwt.getIssuer();
		int userId = Integer.parseInt(userIdString);
		return userId;
	}

}
