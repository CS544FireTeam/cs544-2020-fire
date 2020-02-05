package edu.mum.cs.cs544.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import edu.mum.cs.cs544.dao.UserRepository;
import edu.mum.cs.cs544.model.User;



@Service
public class UserPrincipleDetailService implements UserDetailsService{
	
	private UserRepository userRepo;
	
	public UserPrincipleDetailService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = this.userRepo.findByusername(username);
		 UserPrinciple userPrinciple = new UserPrinciple(user);
		return userPrinciple;
	}

}
