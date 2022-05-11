package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.exception.AddressNotFound;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressBookController {

    @Autowired
    IAddressBookService iAddressBookService;

    // This method will return the default welcome message.
    @GetMapping("/home")
    public ResponseEntity<ResponseDTO> hello() {
        log.info(" We are calling the service layer to return the default message ");
        return iAddressBookService.hello();
    }

    // This method will call the service layer to return the address records. It will throw a custom exception in case the
    // the address record with the given id is not found.
    @GetMapping(value = { "/list/{id}", "/list/", "/list" })
    public ResponseEntity<ResponseDTO> getAddress(@PathVariable Optional<Integer> id) throws AddressNotFound {
        log.info(" We are calling the service layer to return address book records ");
        return iAddressBookService.getAddress(id);
    }

    // This method will call the service layer to insert a new record into the db. It will return an error message if the
    // address record to be inserted has any invalid fields.
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddress(@Valid @RequestBody AddressBookDTO address) {
        log.info(" We are calling the service layer to insert a new record ");
        return iAddressBookService.createAddress(address);
    }

    // This method will call the service layer to update certain records in the db. It will return an error message if the
    // address record to be updated has any invalid fields.
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(@PathVariable Optional<Integer> id,@Valid @RequestBody AddressBookDTO address) throws AddressNotFound {
        log.info(" We are calling the service layer to update the record ");
        return iAddressBookService.updateAddress(id, address);
    }

    // This method will call the service layer to delete records. It will throw a custom exception in case the
    // the address record with the given id is not found.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddress(@PathVariable Optional<Integer> id) throws AddressNotFound{
        log.info(" We are calling the service layer to delete an address book record ");
        return iAddressBookService.deleteAddress(id);
    }
}
