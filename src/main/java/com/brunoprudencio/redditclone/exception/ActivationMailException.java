package com.brunoprudencio.redditclone.exception;

public class ActivationMailException extends RuntimeException {
	public ActivationMailException(String message, Throwable throwable) {
		super( message, throwable );
	}
}
