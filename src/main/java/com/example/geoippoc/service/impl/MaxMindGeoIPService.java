package com.example.geoippoc.service.impl;

import com.example.geoippoc.dto.CityResponseWrapper;
import com.example.geoippoc.dto.CountryResponseWrapper;
import com.example.geoippoc.service.GeoIPService;
import com.example.geoippoc.service.MaxMindGeoIPSearchStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author nadeem
 * @version $Id: MaxMindGeoIPService.java, v 0.1 2020-06-15 7:36 PM
 */
@Slf4j
@Service
public class MaxMindGeoIPService implements GeoIPService {

    @Autowired
    @Qualifier("maxMindGeoIPSearchDBStrategy")
    private MaxMindGeoIPSearchStrategy searchStrategy;

    @Override
    public CountryResponseWrapper findCountry(String ipString) {
        log.info("Request received on {} for finding country for ip address {}", this.getClass().getSimpleName(), ipString);
        return searchStrategy.findCountry(ipString);
    }

    @Override
    public CityResponseWrapper findCity(String ipString) {
        log.info("Request received on {} for finding city for ip address {}", this.getClass().getSimpleName(), ipString);
        return searchStrategy.findCity(ipString);
    }
}
