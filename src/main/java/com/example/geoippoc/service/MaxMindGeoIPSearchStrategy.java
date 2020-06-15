package com.example.geoippoc.service;

import com.example.geoippoc.dto.response.CityResponseWrapper;
import com.example.geoippoc.dto.response.CountryResponseWrapper;

/**
 * @author nadeem
 * @version $Id: MaxMindGeoIPSearchStrategy.java, v 0.1
 */
public interface MaxMindGeoIPSearchStrategy {

    /**
     * Finds the country of the given ip address
     *
     * @param ipString ip address to be searched
     * @return returns the wrapped country response
     */
    CountryResponseWrapper findCountry(String ipString);

    /**
     * Finds the city of the given ip address
     *
     * @param ipString ip address to be searched
     * @return returns the wrapped city response
     */
    CityResponseWrapper findCity(String ipString);
}
