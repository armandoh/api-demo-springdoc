package com.epam.demo.controller;


import com.epam.demo.config.SwaggerConfig;
import com.epam.demo.dto.PhoneRequest;
import com.epam.demo.dto.PhoneResponse;
import com.epam.demo.service.PhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = SwaggerConfig.PHONE_TAG)
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }


    @GetMapping(value = "/v1/phones")
    @Operation(description = "This method is used to get all phones from the system.")
    public ResponseEntity<List<PhoneResponse>> getAllPhones() {
        List<PhoneResponse> phones = phoneService.getAllPhones();
        return ResponseEntity.ok(phones);
    }


    @GetMapping("/v1/phones/{id}")
    @Operation(description = "This method is used to get a phone per its id.", responses = {})

    @ApiResponse(responseCode = "404", description = "Not Found")
    public ResponseEntity<PhoneResponse> getPhoneById(@PathVariable("id") Long id) {
        PhoneResponse phone = phoneService.getPhoneById(id);
        return ResponseEntity.ok(phone);
    }

    @PostMapping(value = "/v1/phones")
    @Operation(description = "This method is used to create a phone.")
    public ResponseEntity<PhoneResponse> createPhone(@RequestBody @Valid PhoneRequest phoneDTO) {
        PhoneResponse createdPhone = phoneService.createPhone(phoneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPhone);
    }

    @PutMapping("/v1/phones/{id}")
    @Operation(description = "This method is used to update a phone per its id and body.")
    public ResponseEntity<PhoneResponse> updatePhone(
            @PathVariable("id") Long id,
            @RequestBody @Valid PhoneRequest phoneDTO) {
        PhoneResponse updatedPhone = phoneService.updatePhone(id, phoneDTO);
        return ResponseEntity.ok(updatedPhone);
    }


    @DeleteMapping("/v1/phones/{id}")
    @Operation(description = "This method is used to delete a phone per its id.")
    public ResponseEntity<Void> deletePhone(@PathVariable("id") Long id) {
        phoneService.deletePhone(id);
        return ResponseEntity.noContent().build();
    }
}
