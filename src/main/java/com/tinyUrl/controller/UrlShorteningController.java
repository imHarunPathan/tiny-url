package com.tinyUrl.controller;

import com.tinyUrl.dto.OriginalUrlDto;
import com.tinyUrl.dto.ShortenUrlDto;
import com.tinyUrl.services.ShortenUrlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harun Pathan
 * 08-02-2020
 */

@RestController
@RequestMapping("/api/v1/url")
public class UrlShorteningController {

    @Autowired
    private ShortenUrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<ShortenUrlDto> shortenUrl(@Validated @RequestBody OriginalUrlDto originalUrlDto) {
        return ResponseEntity.ok(new ShortenUrlDto(urlService.shortenUrl(originalUrlDto.getOriginalUrl())));
    }

}
