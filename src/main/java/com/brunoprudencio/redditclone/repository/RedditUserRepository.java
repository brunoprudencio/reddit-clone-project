package com.brunoprudencio.redditclone.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brunoprudencio.redditclone.model.RedditUser;

@Repository
public interface UserRepository extends JpaRepository<RedditUser, UUID> {

	Optional<RedditUser> findByUsername(String username);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update affiliate set enabled = TRUE where user_id =:user_id ", nativeQuery = true)
	void activateUser(@Param("user_id") UUID id);
}
