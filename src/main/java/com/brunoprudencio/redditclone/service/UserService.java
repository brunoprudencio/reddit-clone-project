package com.brunoprudencio.redditclone.service;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.brunoprudencio.redditclone.dto.RegisterRequest;
import com.brunoprudencio.redditclone.model.Affiliate;
import com.brunoprudencio.redditclone.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public Affiliate findByUsername(String username) {
		return userRepository.findByUsername( username )
				.orElseThrow( () -> new UsernameNotFoundException( "No user found for " + username ) );
	}

	Affiliate mapUserFromRequest(RegisterRequest registerRequest) {
		return Affiliate.builder()
				.userId( UUID.randomUUID() )
				.username( registerRequest.getUsername() )
				.email( registerRequest.getEmail() )
				.password( passwordEncoder.encode( registerRequest.getPassword() ) )
				.createdAt( Instant.now() )
				.enabled( false )
				.build();
	}

	void register(Affiliate affiliate) {
		userRepository.save( affiliate );
	}

	void activateUser(UUID id) {
		userRepository.activateUser( id );
	}
}
