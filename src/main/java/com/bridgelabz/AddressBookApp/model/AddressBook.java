package com.bridgelabz.AddressBookApp.model;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;

public class AddressBook {
    public long id;
    public String name;
    public String address;

    public AddressBook(long id, AddressBookDTO address) {
        super();
        this.id = id;
        this.name = address.name;
        this.address = address.address;
    }

}
