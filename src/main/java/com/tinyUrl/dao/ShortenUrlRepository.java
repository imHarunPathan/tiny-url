package com.tinyUrl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinyUrl.entities.ShortenUrl;

import java.util.Optional;

/**
 * @author Harun Pathan
 * 08-02-2020
 */

@Repository
public interface ShortenUrlRepository extends JpaRepository<ShortenUrl, Long> {

    Optional<ShortenUrl> findByOriginalUrl(String originalUrl);

}
