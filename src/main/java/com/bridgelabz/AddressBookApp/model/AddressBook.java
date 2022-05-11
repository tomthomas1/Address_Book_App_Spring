package com.bridgelabz.AddressBookApp.model;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;

public class AddressBook {
    public long id;
    public String name;
    public String address;
    String city;
    String state;
    int zip;
    long phoneNumber;
    String email;

    public AddressBook(long id, AddressBookDTO address) {
        super();
        this.id = id;
        this.name = address.getName();
        this.address = address.getAddress();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
        this.phoneNumber = address.getPhoneNumber();
        this.email = address.getEmail();
    }

    public AddressBook(AddressBookDTO address) {
        super();
        this.name = address.getName();
        this.address = address.getAddress();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
        this.phoneNumber = address.getPhoneNumber();
        this.email = address.getEmail();
    }

}
