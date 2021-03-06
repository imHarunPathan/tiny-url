package com.tinyUrl.dto;


import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

/**
 * @author Harun Pathan
 * 08-02-2020
 */
public class OriginalUrlDto {

    @NotEmpty(message = "{val.err.original.url.not.empty.or.null}")
    @URL(message = "{val.err.original.url.invalid}")
    private String originalUrl;

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
