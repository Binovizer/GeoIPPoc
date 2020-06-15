package com.example.geoippoc.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.maxmind.geoip2.model.CountryResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author nadeem
 * @version $Id: CountryResponseWrapper.java, v 0.1 2020-06-15 7:31 PM
 */
@Getter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryResponseWrapper extends BaseResponse {

    private final CountryResponse countryResponse;

    public static CountryResponseWrapper successResponse(CountryResponse countryResponse) {
        return CountryResponseWrapper.builder()
                .success(true)
                .countryResponse(countryResponse)
                .build();
    }

    public static CountryResponseWrapper failureResponse(String errorMessage) {
        return CountryResponseWrapper.builder()
                .success(false)
                .errorMessage(errorMessage)
                .build();
    }
}
