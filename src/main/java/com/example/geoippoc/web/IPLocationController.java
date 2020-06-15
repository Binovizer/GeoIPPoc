package com.example.geoippoc.web;

import com.example.geoippoc.dto.response.CityResponseWrapper;
import com.example.geoippoc.dto.response.CountryResponseWrapper;
import com.example.geoippoc.service.GeoIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nadeem
 * @version $Id: IPLocationController.java, v 0.1
 */
@RestController
@RequestMapping("/search")
public class IPLocationController {

    @Autowired
    private GeoIPService geoIPService;

    @GetMapping("/country")
    public CountryResponseWrapper findCountry(@RequestParam("ip") String ipString) {
        return geoIPService.findCountry(ipString);
    }

    @GetMapping("/city")
    public CityResponseWrapper findCity(@RequestParam("ip") String ipString) {
        return geoIPService.findCity(ipString);
    }
}
