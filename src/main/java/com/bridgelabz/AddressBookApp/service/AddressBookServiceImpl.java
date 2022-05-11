package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressBookServiceImpl implements IAddressBookService{
    @Override
    public ResponseEntity<ResponseDTO> hello() {

        ResponseDTO response = new ResponseDTO("Hello World!", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) {
        if (id.isEmpty()) {
            ResponseDTO response = new ResponseDTO("No Address with given ID", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseDTO response = new ResponseDTO("Returning the address", new AddressBookDTO("Tom", "Pune"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address) {
        ResponseDTO response = new ResponseDTO("Inserting a new address record", new AddressBookDTO("Tom", "Pune"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address) {
        ResponseDTO response = new ResponseDTO("Updating an address record", new AddressBookDTO("Tom", "Pune"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteAddress(String id) {
        ResponseDTO response = new ResponseDTO("Deleting an address record", new AddressBookDTO("Tom", "Pune"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}