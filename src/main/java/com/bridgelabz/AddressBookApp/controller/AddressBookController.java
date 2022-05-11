package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;

    @GetMapping("/home")
    public ResponseEntity<ResponseDTO> hello() {
        return iAddressBookService.hello();
    }

    @GetMapping("/list")
    public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) {
        return iAddressBookService.getAddress(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddress(@RequestBody AddressBookDTO address) {
        return iAddressBookService.createAddress(address);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@PathVariable String id, @RequestBody AddressBookDTO address) {
        return iAddressBookService.updateAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable String id) {
        return iAddressBookService.deleteAddress(id);
    }
}
