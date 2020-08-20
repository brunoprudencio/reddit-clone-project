package com.brunoprudencio.redditclone.model;

import static javax.persistence.FetchType.LAZY;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {

	@Id
	private UUID postId;
	private String postName;
	private String url;

	@Lob
	private String description;
	private final Integer voteCount = 0;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "userId")
	private Affiliate affiliate;
	private Instant createdAt;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "subId")
	private Subreddit subreddit;

}
