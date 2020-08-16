package com.brunoprudencio.redditclone.model;

import static javax.persistence.FetchType.LAZY;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
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
	private UUID subId;
	private String name;
	private String description;

	@OneToMany(fetch = LAZY)
	private final List<Post> posts = new ArrayList<>();
	private Instant createdDate;

	@ManyToOne(fetch = LAZY)
	private User user;
}
