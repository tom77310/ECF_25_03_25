package com.example.TP_PayYouPayMe_17_03_25.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.TP_PayYouPayMe_17_03_25.model.Utilisateur;
import com.example.TP_PayYouPayMe_17_03_25.repository.UtilisateurRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UtilisateurRepository dbUserRepository;

	@Override
	public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
		Utilisateur user = dbUserRepository.findByPseudo(pseudo).get();
		return new User(user.getPseudo(), user.getMotDePasse(), getGrantedAuthorities(user.getRole()));
	}

	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}
}