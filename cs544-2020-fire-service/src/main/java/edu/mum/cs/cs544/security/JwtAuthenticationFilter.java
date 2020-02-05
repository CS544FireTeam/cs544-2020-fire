package edu.mum.cs.cs544.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import edu.mum.cs.cs544.model.LoginView;
import edu.mum.cs.cs544.model.User;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		LoginView loginView = null;
		
		
		try {
			loginView = new ObjectMapper().readValue(request.getInputStream(), LoginView.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				loginView.getUsername(), loginView.getPassword(), new ArrayList<>());
		       System.out.println(loginView.getUsername());
		       System.out.println(loginView.getPassword());
		
		Authentication auth = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		System.out.println(auth.isAuthenticated());
		

	
		
		return auth;
	}

	
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		UserPrinciple userPrinciple = (UserPrinciple)authResult.getPrincipal();
		
		//create Token here
		String token = JWT.create()
				.withSubject(userPrinciple.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+JwtProperties.EXPIRE_DATE))
				.sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
		
		response.addHeader(JwtProperties.HEADER, JwtProperties.TOKEN_PREFIX + token);

		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject obj = new JSONObject();
		obj.put("token",token);
		obj.put("user",new JSONObject(userPrinciple.getUser()));

		out.print(obj);
		out.flush();
		                   
		
	   
		
		
	}

	
	
	

}
