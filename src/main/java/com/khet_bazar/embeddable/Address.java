package com.khet_bazar.embeddable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address implements Serializable {
    @JsonProperty("address_line_1")
    private String addressLine1;
    private String street;
    private String state;
    private String country;
    private Long pinCode;
    private Double latitude;
    private Double longitude;
}
