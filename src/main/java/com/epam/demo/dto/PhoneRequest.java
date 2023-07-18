package com.epam.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PhoneRequest {
    private Long id;

    @NotBlank
    @Size(min=10, max = 16)
    @JsonProperty(value = "phone_number")
    private String phoneNumber;
    @NotBlank
    @Size(min=2, max = 20)
    private String region;
    @NotBlank
    @Size(min=2)
    private String country;

    @NotNull
    private Boolean active = true;


}
