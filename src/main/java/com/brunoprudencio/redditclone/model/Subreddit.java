package com.brunoprudencio.redditclone.model;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Subreddit {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private UUID id;
	private String name;
	private String description;

	@OneToMany(fetch = LAZY)
	private List<Post> posts;
	private Instant createdDate;

	@ManyToOne(fetch = LAZY)
	private User user;
}
