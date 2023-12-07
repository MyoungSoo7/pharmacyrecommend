package com.lms.pharmacyrecommend.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DocumentDto {
    @JsonProperty("address_name")
    private String addressName;
    @JsonProperty("address_type")
    private String addressType;
    @JsonProperty("x")
    private double latitude;
    @JsonProperty("y")
    private double longitude;
    @JsonProperty("distance")
    private double distance;

}
