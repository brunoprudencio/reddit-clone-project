package com.brunoprudencio.redditclone.service;

import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.brunoprudencio.redditclone.model.Affiliate;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserService userService;

	@Override public UserDetails loadUserByUsername(String username) {
		return from( userService.findByUsername( username ) );
	}

	private User from(Affiliate user) {
		return new User( user.getUsername(), user.getPassword(), user.getAuthorities() );
	}
}
