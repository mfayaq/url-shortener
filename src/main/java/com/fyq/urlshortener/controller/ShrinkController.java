package com.fyq.urlshortener.controller;

import com.fyq.urlshortener.model.LongUrl;
import com.fyq.urlshortener.model.Response;
import com.fyq.urlshortener.model.ShrunkUrl;
import com.fyq.urlshortener.service.ShrinkService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class ShrinkController {

    @Value("${server.port}")
    private int serverPort;
    private final static String domain = "http://localhost";

    private final ShrinkService shrinkService;
    public ShrinkController(ShrinkService shrinkService) {
        this.shrinkService = shrinkService;
    }

    @PostMapping("/shrink")
    public ResponseEntity<Response> shrink(@RequestBody LongUrl longUrl) {

        Optional<ShrunkUrl> shrunkUrl = shrinkService.shrinkUrl(longUrl.getLongUrl());

        if(shrunkUrl.isEmpty()) {
            return ResponseEntity.internalServerError().build();
        }

        ShrunkUrl url = shrunkUrl.get();

        Response res = new Response(url.getLongUrl(),
                String.format("%s:%d/%s",domain,serverPort,url.getShortUrl()),
                url.getCreatedAt());

        return ResponseEntity.ok(res);
    }
}
