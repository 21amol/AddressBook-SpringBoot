package com.bridgelabz.addressbookspringboot.repository;

import com.bridgelabz.addressbookspringboot.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepo extends JpaRepository<AddressBookData, Integer> {

  @Query (value = "select *from address_book where city = :city", nativeQuery = true)
  List<AddressBookData> findContactsByCity(String city);
  @Query (value = "select *from address_book where state = :state", nativeQuery = true)
  List<AddressBookData> findContactsByState(String state);
}
