package com.example.relation.global.config;

import org.springframework.stereotype.Component;

@Component
public class SecurityPathConfig {
    public static final String[] PUBLIC_GET_URLS = {
        "/posts/**",
        "/tags/**"

    };
}
