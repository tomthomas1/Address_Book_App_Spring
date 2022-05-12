package com.bridgelabz.AddressBookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressBookDTO {

    @NotEmpty(message ="ERROR : Name cannot be empty!")
    @Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Invalid name pattern")
    public String name;

    @Pattern(regexp = "^([A-Z][a-zA-Z]{2,}(, | )?)+$", message = "ERROR: Please enter a valid address!")
    @NotEmpty(message = "ERROR: Address cannot be empty")
    public String address;

    @NotEmpty(message = "ERROR: City cannot be empty!")
    public String city;

    @NotEmpty(message = "ERROR: State cannot be empty!")
    public String state;

    @NotEmpty(message = "ERROR: Zip cannot be null!")
    @Pattern(regexp = "^[0-9]{6}$", message = "ERROR: Please enter a valid zip code!")
    public String zip;


    @NotEmpty(message = "ERROR: Phone number cannot be null!")
    @Pattern(regexp = "^(\\d{1,2}[-]{1}){1}\\d{10}$", message = "ERROR: Please enter a valid phone number")
    public String phoneNumber;

    @Pattern(regexp = "^[a-zA-Z-9]+([._+-]*[0-9A-Za-z]+)*@[a-zA-Z0-9]+.[a-zA-Z]{2,4}([.][a-z]{2,4})?$", message = "ERROR: Please enter a valid email id!")
    @NotEmpty(message = "ERROR: Email cannot be empty!")
    public String email;
}
