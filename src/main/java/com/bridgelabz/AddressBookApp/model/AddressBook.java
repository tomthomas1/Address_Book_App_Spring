package com.bridgelabz.AddressBookApp.model;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;

    public AddressBook(int id, AddressBookDTO address) {
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
