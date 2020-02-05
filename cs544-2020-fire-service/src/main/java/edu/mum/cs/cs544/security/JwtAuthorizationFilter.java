package edu.mum.cs.cs544.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


import edu.mum.cs.cs544.dao.UserRepository;
import edu.mum.cs.cs544.model.User;



public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
	UserRepository userRepo;

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager,UserRepository userRepo) {
		super(authenticationManager);
		this.userRepo = userRepo;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String header = request.getHeader(JwtProperties.HEADER);
		

		// if header does not contain bearer, delegate

		if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}

		// if valid

		Authentication authentication = getUsernamePasswordAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		chain.doFilter(request, response);
	}	


	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
		String token = request.getHeader(JwtProperties.HEADER);

		if (token != null) {
			// parse the token and validate it
			String userName = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes())).build()
					.verify(token.replace(JwtProperties.TOKEN_PREFIX, "")).getSubject();
			
			if(userName!=null) {
				User user = userRepo.findByUsername(userName);
				UserPrinciple principle = new UserPrinciple(user);
				
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName,null, principle.getAuthorities());
				return auth;
			}

		}

		return null;

	}

}
