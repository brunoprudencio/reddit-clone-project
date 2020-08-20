package com.brunoprudencio.redditclone.service;

import java.util.Optional;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.brunoprudencio.redditclone.model.VerificationToken;
import com.brunoprudencio.redditclone.repository.VerificationTokenRepository;

@Service
@AllArgsConstructor
public class VerificationTokenService {

	private final VerificationTokenRepository verificationTokenRepository;

	public void register(VerificationToken token) {
		verificationTokenRepository.save( token );
	}

	public Optional<VerificationToken> findByToken(String token) {
		return verificationTokenRepository.findByToken( token );
	}
}
