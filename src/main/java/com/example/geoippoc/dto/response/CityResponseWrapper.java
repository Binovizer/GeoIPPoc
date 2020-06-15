package com.example.geoippoc.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author nadeem
 * @version $Id: CityResponseWrapper.java, v 0.1 2020-06-15 7:32 PM
 */
@Getter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CityResponseWrapper extends BaseResponse {
    private final String city;
    private final String state;
    private final String country;

    public static CityResponseWrapper successResponse(String city, String state, String country) {
        return CityResponseWrapper.builder()
                .success(true)
                .city(city)
                .state(state)
                .country(country)
                .build();
    }

    public static CityResponseWrapper failureResponse(String errorMessage) {
        return CityResponseWrapper.builder()
                .success(false)
                .errorMessage(errorMessage)
                .build();
    }
}
