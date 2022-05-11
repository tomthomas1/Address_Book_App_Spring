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

    @NotNull(message = "ERROR: City cannot be null!")
    String city;

    @NotNull(message = "ERROR: State cannot be null!")
    String state;

    @Pattern(regexp = "^[0-9]{6}$", message = "ERROR: Please enter a valid zip code!")
    @NotNull(message = "ERROR: Zip cannot be null!")
    int zip;

    @Pattern(regexp = "^[0-9]{10}$", message = "ERROR: Please enter a valid phone number!")
    @NotNull(message = "ERROR: Phone number cannot be null!")
    long phoneNumber;

    @Pattern(regexp = "^[\\w+-]+(\\.[\\w-]+)*@[^_\\W]+(\\.[^_\\W]+)?(?=(\\.[^_\\W]{3,}$|\\.[a-zA-Z]{2}$)).*$", message = "ERROR: Please enter a valid email id!")
    @NotNull(message = "ERROR: Email cannot be null!")
    String email;
}
