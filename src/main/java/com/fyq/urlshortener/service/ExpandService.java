package com.fyq.urlshortener.service;

import com.fyq.urlshortener.model.ShrunkUrl;
import com.fyq.urlshortener.repository.ShrinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpandService {

    private ShrinkRepository shrinkRepository;

    public ExpandService(ShrinkRepository shrinkRepository) {
        this.shrinkRepository = shrinkRepository;
    }

    public Optional<String> getLongUrlFromShortUrl(String shortUrl) {
        Optional<ShrunkUrl> result;

        try {
            result = shrinkRepository.getBySmallUrl(shortUrl);
        } catch (Exception e) {
            return Optional.empty();
        }

        return result.isPresent() ? Optional.of(result.get().getLongUrl()) : Optional.empty();
    }
}
