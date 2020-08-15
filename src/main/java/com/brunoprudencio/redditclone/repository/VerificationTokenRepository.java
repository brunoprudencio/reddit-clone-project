package com.brunoprudencio.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brunoprudencio.redditclone.model.User;
import com.brunoprudencio.redditclone.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

}
