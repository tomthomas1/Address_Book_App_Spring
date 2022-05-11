package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @GetMapping("/home")
    public String hello() {
        return "Hello To Address Book App";
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) {
        if (id.isEmpty()) {
            ResponseDTO response = new ResponseDTO("No Address with the given ID", null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseDTO response = new ResponseDTO("Returning a specific address", new AddressBookDTO("Tom", "Pune"));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddress(@RequestBody AddressBook address) {
        ResponseDTO response = new ResponseDTO("Inserting a new address record", new AddressBookDTO("Tom", "Pune"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@RequestBody AddressBook address) {
        ResponseDTO response = new ResponseDTO("Updating an address record", new AddressBookDTO("Tom", "Pune"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable String id) {
        ResponseDTO response = new ResponseDTO("Deleting an address record", new AddressBookDTO("Tom", "Pune"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
