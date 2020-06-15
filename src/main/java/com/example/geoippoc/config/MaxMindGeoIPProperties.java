package com.example.geoippoc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

/**
 * @author nadeem
 * @version $Id: MaxMindGeoIPConfigProperties.java, v 0.1 2020-06-15 7:19 PM
 */
@Data
@ConfigurationProperties(prefix = MaxMindGeoIPProperties.PROPERTY_PREFIX)
public class MaxMindGeoIPProperties {

    public static final String PROPERTY_PREFIX = "maxmind.geoip";

    private Boolean enabled = true;

    private String geolite2CityDbFilePath;

    private Integer accountId;

    private String licenseKey;

}
