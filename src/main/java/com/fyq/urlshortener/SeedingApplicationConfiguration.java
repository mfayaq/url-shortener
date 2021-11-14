package com.fyq.urlshortener;

import com.fyq.urlshortener.model.ShrunkUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SeedingApplicationConfiguration {

    /**
     * Create Storage for storing ShrunkUrl Entity.
     * Can be replaced by data source
     */
    @Bean
    public Map<String, ShrunkUrl> createHashMapStorage() {
        return new HashMap<>();
    }
}
