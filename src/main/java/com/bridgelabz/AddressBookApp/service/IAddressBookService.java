package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.exception.AddressNotFound;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IAddressBookService {
    ResponseEntity<ResponseDTO> hello();

    ResponseEntity<ResponseDTO> getAddress(Optional<Integer> id) throws AddressNotFound;

    ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address);

    ResponseEntity<ResponseDTO> updateAddress(int id, AddressBookDTO address) throws AddressNotFound;

    ResponseEntity<ResponseDTO> deleteAddress(int id) throws AddressNotFound;

     ResponseEntity<ResponseDTO> findAddressByCity(String city) throws AddressNotFound;
}
