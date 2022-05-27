package com.bridgelabz.addressbookspringboot.repository;

import com.bridgelabz.addressbookspringboot.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBookData, Integer> {
}
