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

import javax.validation.Valid;
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
        log.info(" We are returning the default message");
        ResponseDTO responseDTO = new ResponseDTO("Welcome to the address book application", null);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    // This method is to return address book records. It will throw a custom exception in case it doesn't find the id passed.
    @Override
    public ResponseEntity<ResponseDTO> getAddress(Optional<Integer> id) throws AddressNotFound {
        log.info(" We are returning the address book records ");
        ResponseDTO responseDTO;
        if (id.isEmpty()) {
            List<AddressBook> addressBook = (List<AddressBook>) addressBookRepository.findAll();
            responseDTO = new ResponseDTO("Fetching all address records", addressBook);
            ResponseEntity<ResponseDTO> response = new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
            return response;
        }

            Optional<AddressBook> address = addressBookRepository.findById(id.get());
            AddressBook addressBook = address.orElse(null);

            if(address.isPresent()) {
                responseDTO = new ResponseDTO("Found the address", addressBook);
                return new ResponseEntity<ResponseDTO>(new ResponseDTO("Found the address",addressBook),HttpStatus.OK);
            } else {
                throw new AddressNotFound("ERROR : Could not find the address in address book");
            }
    }

    // This method is to insert a new address record
    @Override
    public ResponseEntity<ResponseDTO> createAddress(AddressBookDTO address) {
        log.info(" We are inserting a new address book record ");
        AddressBook addressBook = addressBookRepository.save(new AddressBook(address));
        ResponseDTO responseDTO = new ResponseDTO("New Address has been saved in book successfully ", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // This method is to update an address record. It will throw a custom exception in case it doesn't find the id passed.
    @Override
    public ResponseEntity<ResponseDTO> updateAddress(int id, @Valid AddressBookDTO address) throws AddressNotFound {
        log.info(" We are updating an existing address book record");
        Optional<AddressBook> add = addressBookRepository.findById(id);
        if (add.isEmpty()) {
            throw new AddressNotFound("ERROR: Invalid Address Book record id");
        }
        AddressBook addressBook = addressBookRepository.save(new AddressBook(id, address));
        ResponseDTO responseDTO = new ResponseDTO("Address has been successfully updated", addressBook);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // This method is to delete an address record. It will throw a custom exception in case it doesn't find the id passed.
    @Override
    public ResponseEntity<ResponseDTO> deleteAddress(int id) throws AddressNotFound {
        log.info(" We are deleting an address book record ");
        if(addressBookRepository.findById(id).isPresent()) {
            addressBookRepository.deleteById(id);
            return new ResponseEntity<ResponseDTO>(new ResponseDTO("Address record deleted", "Address deleted with ID " + id), HttpStatus.OK);
        } else
            throw new AddressNotFound("Error: No such address Id in Address Book");
        }

    @Override
    public ResponseEntity<ResponseDTO> findAddressByCity(String city) throws AddressNotFound {
        log.info(" Searching for the address record by city");
        List<AddressBook> addressList = addressBookRepository.findAddressByCity(city);

        if (addressList.size() == 0)
            throw new AddressNotFound("ERROR: Address record with city " + city + " not found!");
        ResponseDTO response = new ResponseDTO("Address with city " + city, addressList);

        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}
