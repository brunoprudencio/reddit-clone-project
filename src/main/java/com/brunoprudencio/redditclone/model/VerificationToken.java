package com.brunoprudencio.redditclone.model;

import static javax.persistence.FetchType.LAZY;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken {

	@Id
	private UUID id;
	private String token;
	@OneToOne(fetch = LAZY)
	private User user;
	private Instant expiryDate;
}
