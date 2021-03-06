package com.yom.hazelcast.hazelcastdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "instruments")
public class MusicService {

    private static Logger log = LoggerFactory.getLogger(MusicService.class);

    @CacheEvict(allEntries = true)
    public void clearCache(){}

    @Cacheable(condition = "#instrument.equals('Bass')")
    public String play(String instrument){

        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");

        return "playing "+ instrument + "!";
    }
}
