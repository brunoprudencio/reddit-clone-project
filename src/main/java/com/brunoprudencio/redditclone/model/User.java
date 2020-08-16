package com.brunoprudencio.redditclone.model;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "affiliate")
public class User {

	@Id
	private UUID userId;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	private Instant createdAt;
	private Instant lastModifiedAt;
}
