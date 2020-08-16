package com.brunoprudencio.redditclone.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brunoprudencio.redditclone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
