package com.fyq.urlshortener.repository;

import com.fyq.urlshortener.model.ShrunkUrl;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ShrinkRepository {

    private Map<String, ShrunkUrl> storedUrls;

    public ShrinkRepository(Map<String, ShrunkUrl> storedUrls) {
        this.storedUrls = storedUrls;
    }

    public Optional<ShrunkUrl> getBySmallUrl(String smallUrl) {
        return Optional.ofNullable(storedUrls.get(smallUrl));
    }

    public void save(ShrunkUrl shrunkUrl) {
        storedUrls.put(shrunkUrl.getShortUrl(), shrunkUrl);
    }
}
