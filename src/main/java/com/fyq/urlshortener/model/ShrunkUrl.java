package com.fyq.urlshortener.model;

import java.time.Instant;

public class ShrunkUrl {

    private long id;
    private String longUrl;
    private String shortUrl;
    private Instant createdAt;

    public ShrunkUrl(long id, String longUrl, String shortUrl, Instant createdAt) {
        this.id = id;
        this.longUrl = longUrl;
        this.shortUrl = shortUrl;
        this.createdAt = createdAt;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
