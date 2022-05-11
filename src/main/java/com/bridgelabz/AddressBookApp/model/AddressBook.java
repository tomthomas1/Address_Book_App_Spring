package com.bridgelabz.AddressBookApp.model;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String address;
    String city;
    String state;
    int zip;

    @Column(name = "phone_number")
    long phoneNumber;
    String email;

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
