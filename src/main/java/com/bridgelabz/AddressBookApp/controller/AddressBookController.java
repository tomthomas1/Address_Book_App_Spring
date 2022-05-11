package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.exception.AddressNotFound;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(value = { "/list/{id}", "/list/", "/list" })
    public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<String> id) throws AddressNotFound {
        return iAddressBookService.getAddress(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddress(@Valid @RequestBody AddressBookDTO address) {
        return iAddressBookService.createAddress(address);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@PathVariable String id,@Valid @RequestBody AddressBookDTO address) throws AddressNotFound {
        return iAddressBookService.updateAddress(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable String id) throws AddressNotFound{
        return iAddressBookService.deleteAddress(id);
    }
}
