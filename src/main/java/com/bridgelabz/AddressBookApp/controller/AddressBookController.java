package com.bridgelabz.AddressBookApp.controller;

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
    public ResponseEntity<String> getAddress(@PathVariable Optional<Integer> id) {
        return new ResponseEntity<String>("Displaying the address book list", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createAddress(@RequestBody AddressBook address) {
        return new ResponseEntity<String>("Inserting a new address record", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAddress(@RequestBody AddressBook address) {
        return new ResponseEntity<String>("Updating an address record", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable String id) {
        return new ResponseEntity<String>("Deleting an address record", HttpStatus.OK);
    }

}
