package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
        ResponseDTO response = new ResponseDTO("Welcome to Address Book App", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> getAddress() {
            ResponseDTO response = new ResponseDTO("Returning the address book list", adBookList);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address) {
        AddressBook newAddressBook = new AddressBook(++counter, address);
        adBookList.add(newAddressBook);
        ResponseDTO response = new ResponseDTO("Inserting a new address record", newAddressBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateAddress(String id, AddressBookDTO address) {
        AddressBook adBook = findAddress(id);
        adBook.name = address.name;
        adBook.address = address.address;

        ResponseDTO response = new ResponseDTO("Updating an address record", adBook);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDTO> deleteAddress(String id) {
        adBookList.remove(findAddress(id));

        ResponseDTO response = new ResponseDTO("Deleting an address record", null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}