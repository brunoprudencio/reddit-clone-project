package com.brunoprudencio.redditclone.service;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brunoprudencio.redditclone.dto.RegisterRequest;
import com.brunoprudencio.redditclone.model.User;
import com.brunoprudencio.redditclone.model.VerificationToken;
import com.brunoprudencio.redditclone.repository.UserRepository;
import com.brunoprudencio.redditclone.repository.VerificationTokenRepository;

@Service
@AllArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final VerificationTokenRepository verificationTokenRepository;

	@Transactional
	public void signup(RegisterRequest registerRequest) {
		User user = User.builder()
				.username( registerRequest.getUsername() )
				.email( registerRequest.getEmail() )
				.password( passwordEncoder.encode( registerRequest.getPassword() ) )
				.createdAat( Instant.now() )
				.enabled( false )
				.build();

		userRepository.save( user );
		String token = generateVerificationToken( user );
	}

	private String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = VerificationToken.builder()
				.token( token )
				.user( user )
				.build();
		verificationTokenRepository.save( verificationToken );

		return token;
	}
}
