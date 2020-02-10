package com.tinyUrl.services;

import java.util.Optional;

import com.tinyUrl.entities.ShortenUrl;

/**
 * @author Harun Pathan
 * 08-02-2020
 */
public interface ShortenUrlService {

    String shortenUrl(String originalUrl);

    Optional<ShortenUrl> getShortenUrl(String shortenKey);
}
