package com.fyq.urlshortener.model;

import org.springframework.stereotype.Service;

@Service
public class Counter {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }
}
