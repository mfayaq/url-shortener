package com.fyq.urlshortener.service;

import com.fyq.urlshortener.model.Counter;
import com.fyq.urlshortener.model.ShrunkUrl;
import com.fyq.urlshortener.repository.ShrinkRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class ShrinkService {

    private ShrinkRepository shrinkRepository;
    private Counter count;

    public ShrinkService(ShrinkRepository shrinkRepository, Counter count) {
        this.shrinkRepository = shrinkRepository;
        this.count = count;
    }

    public Optional<ShrunkUrl> shrinkUrl(String longUrl) {
        count.incrementCount();

        String shortUrl = encodeToBase62(count.getCount());
        ShrunkUrl shrunkUrl = new ShrunkUrl(count.getCount(),longUrl,shortUrl, Instant.now());

        try {
            shrinkRepository.save(shrunkUrl);
        }
        catch (Exception e) {
            return Optional.empty();
        }

        return Optional.of(shrunkUrl);
    }

    private String encodeToBase62(long input) {
        StringBuilder sb = new StringBuilder();
        String base62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (input != 0) {
            sb.append(base62.charAt((int)(input % 62)));
            input /= 62;
        }
        while (sb.length() < 6) {
            sb.append(0);
        }
        return sb.reverse().toString();
    }
}
