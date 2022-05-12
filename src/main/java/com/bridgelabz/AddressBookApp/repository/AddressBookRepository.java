package com.bridgelabz.AddressBookApp.repository;

import com.bridgelabz.AddressBookApp.model.AddressBook;
import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

    // This is a custom query to search the table for an address record by city name
    @Query(value = "SELECT * FROM address_book WHERE CITY = :city", nativeQuery = true)
    public List<AddressBook> findAddressByCity(@Param(value = "city") String city);
}
