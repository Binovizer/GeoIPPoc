package com.example.geoippoc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.maxmind.geoip2.model.CountryResponse;
import lombok.Builder;
import lombok.Getter;

/**
 * @author nadeem
 * @version $Id: CountryResponseWrapper.java, v 0.1 2020-06-15 7:31 PM
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryResponseWrapper extends BaseResponse {

    private final CountryResponse countryResponse;

    @Builder
    public CountryResponseWrapper(boolean success, String errorMessage, CountryResponse countryResponse) {
        super(success, errorMessage);
        this.countryResponse = countryResponse;
    }

    public static CountryResponseWrapper successResponse(CountryResponse countryResponse) {
        return CountryResponseWrapper.builder().countryResponse(countryResponse).build();
    }

    public static CountryResponseWrapper failureResponse(String errorMessage) {
        return CountryResponseWrapper.builder()
                .success(false)
                .errorMessage(errorMessage)
                .build();
    }
}
