package edu.mum.cs.cs544.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import edu.mum.cs.cs544.dao.UserRepository;
import edu.mum.cs.cs544.model.User;

@Component
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository
                .findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User name " + s + "Not Found in DB"));
        return convert(user);

    }

	private UserDetails convert(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
	}
    
    /*
    static class UserPrincipal implements UserDetails {

    	private static final long serialVersionUID = -4010528767765270382L;
    	
    	private String email;
        private String password;

        public UserPrincipal(String email,String password,Collection<? extends GrantedAuthority> authorities){
            this.email=email;
            this.password=password;
            this.authorities=authorities;
        }

        private Collection<? extends GrantedAuthority> authorities;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
        
        public static UserPrincipal create(User user) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            System.out.println("------" + user.getRole().name());
            authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
            return new UserPrincipal(user.getUsername(),user.getPassword(),authorities);
        }
    }
    */
}