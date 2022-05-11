package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService{
    List<AddressBook> adBookList = new ArrayList<>();
    long counter = 0;

    private AddressBook findAddress(String idOld) {
        long id = Long.parseLong(idOld);

        for (AddressBook addressBook : adBookList) {
            if (addressBook.id == id)
                return addressBook;
        }
        return null;
    }

    @Override
    public ResponseEntity<ResponseDTO> hello() {
        log.info(" Returning default response");
        ResponseDTO response = new ResponseDTO("Welcome to Address Book App", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> getAddress(Optional<String> id) {
        if (id.isEmpty()) {
            log.info(" Returning all address from the book list ");
            ResponseDTO response = new ResponseDTO("Returning the address book list", adBookList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            log.info(" Returning address of given address id");
            ResponseDTO response = new ResponseDTO("Returning address of given Id",
                    findAddress(id.get()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address) {
        log.info(" Creating a new address book record ");
        AddressBook newAddressBook = new AddressBook(++counter, address);
        adBookList.add(newAddressBook);
        ResponseDTO response = new ResponseDTO("Inserting a new address record", newAddressBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address) {
        log.info(" Updating an existing address book record ");
        AddressBook adBook = findAddress(id);
        adBook.name = address.name;
        adBook.address = address.address;

        ResponseDTO response = new ResponseDTO("Updating an address record", adBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteAddress(String id) {
        log.info(" Deleting an existing address book record ");
        adBookList.remove(findAddress(id));

        ResponseDTO response = new ResponseDTO("Deleting an address record", id + " Address deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}