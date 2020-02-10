package com.tinyUrl.services;

/**
 * @author Harun Pathan
 * 08-02-2020
 */
public interface IdConverterService {

    String encode(long num);

    long decode(String shortenKey);
}
