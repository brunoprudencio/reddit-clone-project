package com.brunoprudencio.redditclone.exception;

public class UserNameNotFoundException extends RuntimeException {
	public UserNameNotFoundException(String message) {
		super( message );
	}
}
