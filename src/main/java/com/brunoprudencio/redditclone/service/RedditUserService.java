package com.brunoprudencio.redditclone.service;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunoprudencio.redditclone.dto.RegisterRequest;
import com.brunoprudencio.redditclone.model.RedditUser;
import com.brunoprudencio.redditclone.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public RedditUser findByUsername(String username) {
		return userRepository.findByUsername( username )
				.orElseThrow( () -> new UsernameNotFoundException( "No user found for " + username ) );
	}

	RedditUser mapUserFromRequest(RegisterRequest registerRequest) {
		return RedditUser.builder()
				.userId( UUID.randomUUID() )
				.username( registerRequest.getUsername() )
				.email( registerRequest.getEmail() )
				.password( passwordEncoder.encode( registerRequest.getPassword() ) )
				.createdAt( Instant.now() )
				.enabled( false )
				.build();
	}

	void register(RedditUser redditUser) {
		userRepository.save( redditUser );
	}

	void activateUser(UUID id) {
		userRepository.activateUser( id );
	}
}
