package com.brunoprudencio.redditclone.controller;

import static org.springframework.http.HttpStatus.OK;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunoprudencio.redditclone.dto.RegisterRequest;
import com.brunoprudencio.redditclone.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

	private final AuthService authService;

	@GetMapping("activation/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token) {
		authService.activateAccount( token );
		return new ResponseEntity<>( "Account activation successful!", OK );
	}

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
		authService.signup( registerRequest );
		return new ResponseEntity<>( "User registration was successful", OK );
	}
}
