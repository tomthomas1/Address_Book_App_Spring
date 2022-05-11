package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.exception.AddressNotFound;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService{

    @Autowired
    AddressBookRepository addressBookRepository;

    // This method is to return a default string
    @Override
    public ResponseEntity<ResponseDTO> hello() {
        // TODO Auto-generated method stub
        log.info(" We are returning the default message");
        ResponseDTO responseDTO = new ResponseDTO("Welcome to the address book application", null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    // This method is to return address book records. It will throw a custom exception in case it doesn't find the id passed.
    @Override
    public ResponseEntity<ResponseDTO> getAddress(Optional<Integer> id) throws AddressNotFound {
        log.info(" We are returning the address book records ");
        ResponseDTO responseDTO;
        if (id.isEmpty())
            responseDTO = new ResponseDTO("Fetching all address records", addressBookRepository.findAll());
        else {
            Optional<AddressBook> address = addressBookRepository.findById(id.get());
            responseDTO = new ResponseDTO("Fetching specific address record", address.orElseThrow(
                    () -> new AddressNotFound("ERROR: Invalid Address")));
        }

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    // This method is to insert a new address record
    @Override
    public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address) {
        log.info(" We are inserting a new address book record ");
        addressBookRepository.save(new AddressBook(address));
        ResponseDTO responseDTO = new ResponseDTO("Creating an address book record ", address);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    // This method is to update an address record. It will throw a custom exception in case it doesn't find the id passed.
    @Override
    public ResponseEntity<ResponseDTO> updateAddress(Optional<Integer> id, AddressBookDTO address) throws AddressNotFound {
        // TODO Auto-generated method stub
        log.info(" We are updating an existing address book record");
        Optional<AddressBook> add = addressBookRepository.findById(id.get());
        if (add.isEmpty())
            throw new AddressNotFound("ERROR: Invalid Address record id");

        addressBookRepository.save(new AddressBook(id.get(), address));
        ResponseDTO responseDTO = new ResponseDTO("Updating data", id.get());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    // This method is to delete an address record. It will throw a custom exception in case it doesn't find the id passed.
    @Override
    public ResponseEntity<ResponseDTO> deleteAddress(Optional<Integer> id) throws AddressNotFound {
        log.info(" We are deleting an address book record ");

        addressBookRepository.findById(id.get()).orElseThrow(() -> new AddressNotFound("ERROR: Invalid address record id"));

        addressBookRepository.deleteById(id.get());
        ResponseDTO responseDTO = new ResponseDTO("Deleting data", id.get());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}