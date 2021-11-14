package com.fyq.urlshortener.controller;

import com.fyq.urlshortener.service.ExpandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
public class ExpandController {

    private ExpandService expandService;

    public ExpandController(ExpandService expandService) {
        this.expandService = expandService;
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity expand(@PathVariable String shortUrl) {

        Optional<String> longUrl = expandService.getLongUrlFromShortUrl(shortUrl);

        if(!longUrl.isPresent()) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(longUrl.get())).build();
    }
}
