package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IAddressBookService {
    ResponseEntity<ResponseDTO> hello();

    ResponseEntity<ResponseDTO> getAddress(Optional<String> id);

    ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address);

    ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address);

    ResponseEntity<ResponseDTO> deleteAddress(String id);
}
