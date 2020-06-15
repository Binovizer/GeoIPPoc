package com.example.geoippoc.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author nadeem
 * @version $Id: BaseResponse.java, v 0.1 2020-06-15 7:55 PM
 */
@Getter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    private final boolean success;
    private final String errorMessage;
}
