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
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "affiliate")
public class Affiliate {

	@Id
	private UUID userId;
	private String username;
	private String password;
	private String email;
	private boolean enabled;
	private Instant createdAt;
	private Instant lastModifiedAt;

}
