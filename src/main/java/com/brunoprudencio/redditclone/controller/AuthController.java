package com.brunoprudencio.redditclone.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunoprudencio.redditclone.dto.RegisterRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@PostMapping
	public void signup(@RequestBody RegisterRequest registerREquest) {

	}
}
