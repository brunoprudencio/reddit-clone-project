package com.brunoprudencio.redditclone.model;

import static javax.persistence.FetchType.LAZY;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {

	@Id
	private UUID postID;
	private String postName;
	private String url;

	@Lob
	private String description;
	private Integer voteCount = 0;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;
	private Instant createdAt;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Subreddit subreddit;

}
