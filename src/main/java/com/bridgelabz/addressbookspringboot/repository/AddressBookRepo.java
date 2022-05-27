package com.bridgelabz.addressbookspringboot.repository;

import com.bridgelabz.addressbookspringboot.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBookData, Integer> {
}
