package br.com.devsfuturo.starwars.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public ConcurrentMapCacheManager cachePlaneta() {
        System.out.println("Configuração de Caching Inicializada.");
        return new ConcurrentMapCacheManager("planetas");
    }

}
