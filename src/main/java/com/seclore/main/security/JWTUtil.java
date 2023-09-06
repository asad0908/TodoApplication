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

@Component
public class JWTUtil {
//	@Autowired
//	private UserTodoMappingServiceInterface userTodoMappingService;
//	@Autowired
//	private UserServiceInterface userService;
	
	@Value("${application.security.jwt.secret-key}")
	private String secretKey;
	
	 @PostConstruct
	    protected void init() {
	        // this is to avoid having the raw secret key available in the JVM
	        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	    }

	    public String createToken(String login) {
	        Date now = new Date();
	        Date validity = new Date(now.getTime() + 3600000); // 1 hour

	        Algorithm algorithm = Algorithm.HMAC256(secretKey);
	        return JWT.create()
	                .withIssuer(login)
	                .withIssuedAt(now)
	                .withExpiresAt(validity)
	                .sign(algorithm);
	    }
	    
	    //todo rename this
	    public int validateToken(String token) {
	        Algorithm algorithm = Algorithm.HMAC256(secretKey);
	        JWTVerifier verifier = JWT.require(algorithm).build();
	        DecodedJWT decodedJwt = verifier.verify(token);
	        String userIdString = decodedJwt.getIssuer();
	        int userId = Integer.parseInt(userIdString);
	        return userId;
	    }

//	    public Authentication validateCredentials(User inputUser) {
//	    	User user = userService.getUserById(inputUser.getId());
//	        UserDto user = userTodoMappingService.checkUserTodoMapping(userId, todoId));
//	        return new UsernamePasswordAuthenticationToken(userId, null, Collections.emptyList());
//	    }

}
