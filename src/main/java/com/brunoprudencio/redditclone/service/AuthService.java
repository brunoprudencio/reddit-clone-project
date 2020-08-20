package com.brunoprudencio.redditclone.service;

import java.util.UUID;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.brunoprudencio.redditclone.dto.NotificationMail;
import com.brunoprudencio.redditclone.dto.RegisterRequest;
import com.brunoprudencio.redditclone.model.Affiliate;
import com.brunoprudencio.redditclone.model.VerificationToken;

@Service
@AllArgsConstructor
public class AuthService {

	private final UserService userService;
	private final MailService mailService;
	private final VerificationTokenService verificationTokenService;

	public void signup(RegisterRequest registerRequest) {
		Affiliate affiliate = userService.mapUserFromRequest( registerRequest );
		userService.register( affiliate );
		mailService.sendMail( new NotificationMail( "Please Activate your Account",
				affiliate.getEmail(), "Thank you for signing up to Spring Reddit, " +
				"please click on the link below to activate your account : " +
				"http://localhost:8080/api/auth/activation/" + generateVerificationToken( affiliate ) ) );
	}

	private String generateVerificationToken(Affiliate affiliate) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = VerificationToken.builder()
				.id( UUID.randomUUID() )
				.token( token )
				.affiliate( affiliate )
				.build();
		verificationTokenService.register( verificationToken );
		return token;
	}

	public void activateAccount(String token) {
		verificationTokenService.findByToken( token )
				.map( VerificationToken::getAffiliate )
				.map( Affiliate::getUserId )
				.ifPresent( userService::activateUser );
	}

}
