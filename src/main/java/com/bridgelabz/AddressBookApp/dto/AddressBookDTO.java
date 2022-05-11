package com.bridgelabz.AddressBookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {

    @NotNull(message = "ERROR: Name cannot be null")
    @Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Invalid name pattern")
    public String name;

    @NotNull(message = "ERROR: Address cannot be null")
    public String address;
}
