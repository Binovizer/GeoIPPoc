package com.example.geoippoc.service.impl;

import com.example.geoippoc.dto.response.CityResponseWrapper;
import com.example.geoippoc.dto.response.CountryResponseWrapper;
import com.example.geoippoc.service.MaxMindGeoIPSearchStrategy;
import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author nadeem
 * @version $Id: MaxMindGeoIPSearchWebStrategy.java, v 0.1
 */
@Slf4j
@Service("maxMindGeoIPSearchWebStrategy")
public class MaxMindGeoIPSearchWebStrategy implements MaxMindGeoIPSearchStrategy {

    @Autowired
    private WebServiceClient client;

    @Override
    public CountryResponseWrapper findCountry(String ipString) {
        log.info("Request received on {} for finding country for ip address {}", this.getClass().getSimpleName(), ipString);
        try {
            InetAddress ipAddress = InetAddress.getByName(ipString);

            CountryResponse countryResponse = client.country(ipAddress);

            return CountryResponseWrapper.successResponse(countryResponse);
        } catch (IOException | GeoIp2Exception e) {
            return CountryResponseWrapper.failureResponse(e.getMessage());
        }
    }

    @Override
    public CityResponseWrapper findCity(String ipString) {
        log.info("Request received on {} for finding city for ip address {}", this.getClass().getSimpleName(), ipString);
        try {
            InetAddress ipAddress = InetAddress.getByName(ipString);

            CityResponse cityResponse = client.city(ipAddress);
            String city = cityResponse.getCity().getName();
            String state = cityResponse.getMostSpecificSubdivision().getName();
            String country = cityResponse.getCountry().getName();

            return CityResponseWrapper.successResponse(city, state, country);
        } catch (IOException | GeoIp2Exception e) {
            return CityResponseWrapper.failureResponse(e.getMessage());
        }
    }
}
