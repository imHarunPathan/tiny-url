package com.tinyUrl.services;

import com.tinyUrl.dao.ShortenUrlRepository;
import com.tinyUrl.entities.ShortenUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Harun Pathan
 * 08-02-2020
 */
@Transactional
@Service
public class ShortenUrlServiceImpl implements ShortenUrlService {

    @Value("${base.url}")
    private String BASE_URL;

    @Value("${shorten.url.prefix}")
    private String SHORTEN_URL_PREFIX;

    @Autowired
    private ShortenUrlRepository shortenUrlRepository;

    @Autowired
    private IdConverterService idConverterService;

    @Override
    public String shortenUrl(String originalUrl) {
        return BASE_URL.concat(SHORTEN_URL_PREFIX).concat(shortenUrlRepository.findByOriginalUrl(originalUrl)
                .orElseGet(() -> saveAndShorten(originalUrl))
                .getShortenKey());
    }

    private ShortenUrl saveAndShorten(String originalUrl) {
        ShortenUrl url = shortenUrlRepository.save(new ShortenUrl(originalUrl));
        String shortenKey = idConverterService.encode(url.getId());

        url.setShortenKey(shortenKey);

        return url;
    }

    @Override
    public Optional<ShortenUrl> getShortenUrl(String shortenKey) {
        return shortenUrlRepository.findById(idConverterService.decode(shortenKey));
    }
}
