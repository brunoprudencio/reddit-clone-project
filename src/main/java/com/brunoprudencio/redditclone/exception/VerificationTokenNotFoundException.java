package com.brunoprudencio.redditclone.exception;

public class VerificationTokenNotFoundException extends RuntimeException {
	public VerificationTokenNotFoundException(String message) {
		super( message );
	}
}
