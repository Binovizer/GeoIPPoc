package com.example.geoippoc.config;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.WebServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * @author nadeem
 * @version $Id: MaxMindGeoIPConfig.java, v 0.1
 */
@Configuration
@ConditionalOnProperty(prefix = MaxMindGeoIPProperties.PROPERTY_PREFIX, value = {"enabled"}, matchIfMissing = true)
@EnableConfigurationProperties(MaxMindGeoIPProperties.class)
public class MaxMindGeoIPConfig {

    @Autowired
    private MaxMindGeoIPProperties properties;

    @Bean
    public DatabaseReader getDatabaseReader() throws IOException {
        File dbFile = new File(properties.getGeolite2CityDbFilePath());
        return new DatabaseReader.Builder(dbFile).build();
    }

    @Bean
    public WebServiceClient getWebServiceClient() {
        return new WebServiceClient.Builder(properties.getAccountId(), properties.getLicenseKey()).build();
    }

}
