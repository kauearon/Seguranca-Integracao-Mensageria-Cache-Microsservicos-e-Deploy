package br.edu.javapartesete.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

// 20: maximumSize e TTL estão definidos em application.properties.
@Configuration
@EnableCaching
public class CacheCaffeineConfig { }
