package edu.mum.cs.cs544.security;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import edu.mum.cs.cs544.dao.UserRepository;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(name = "app.security", havingValue = "true")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UserPrincipleDetailService userPrincipleDetailsService;
	private UserRepository userRepo;

	public SecurityConfig(UserPrincipleDetailService userPrincipleDetailsService, UserRepository userRepo) {
		this.userPrincipleDetailsService = userPrincipleDetailsService;
		this.userRepo = userRepo;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		//remove thsi later 
		.cors().configurationSource(new CorsConfigurationSource() {

			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				 CorsConfiguration config = new CorsConfiguration();
		            config.setAllowedHeaders(Collections.singletonList("*"));
		            config.setAllowedMethods(Collections.singletonList("*"));
		            config.addAllowedOrigin("*");
		            config.setAllowCredentials(true);
		            return config;
			}
		})
		//remove this later
		
		.and()
		.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilter(new JwtAuthenticationFilter(authenticationManager()))
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userRepo)).authorizeRequests()
				.antMatchers("/login").permitAll().antMatchers("/register/**").permitAll().antMatchers("/api/**")
				.authenticated().and().httpBasic();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipleDetailsService);
		return daoAuthenticationProvider;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
