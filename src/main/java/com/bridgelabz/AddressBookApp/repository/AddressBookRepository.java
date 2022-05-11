package com.bridgelabz.AddressBookApp.repository;

import com.bridgelabz.AddressBookApp.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
}
