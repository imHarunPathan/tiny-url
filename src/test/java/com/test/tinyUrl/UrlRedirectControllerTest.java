package com.test.tinyUrl;

import com.tinyUrl.controller.UrlRedirectController;
import com.tinyUrl.dao.ShortenUrlRepository;
import com.tinyUrl.services.ShortenUrlService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;


/**
 * @author Harun Pathan
 * 08-02-2020
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UrlRedirectControllerTest {

    private static final String URL_TEST = "https://www.neueda.com/about-us";

    @Value("${base.url}")
    private String BASE_URL;

    @Value("${shorten.url.prefix}")
    private String SHORTEN_URL_PREFIX;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ShortenUrlService shortenUrlService;

    @Autowired
    private UrlRedirectController redirectController;

    @Autowired
    private ShortenUrlRepository shortenUrlRepository;

    @Test
    public void fail_redirect_nonsexist_shorten_url() {
        assertThat(restTemplate.getForObject(BASE_URL + SHORTEN_URL_PREFIX + "1234",
                String.class), containsString("<h1>Url not found</h1>"));
    }

    @Test
    public void success_redirect_preexist_shorten_url() {
        shortenUrlService.shortenUrl(URL_TEST);
        String shortenStr = shortenUrlRepository.findByOriginalUrl(URL_TEST).get().getShortenKey();
        assertThat(redirectController.redirectToOriginalUrl(shortenStr).getViewName()
                , equalTo("redirect:" + URL_TEST));
    }

}
