package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.exceptions.AddressBookException;
import com.bridgelabz.addressbookspringboot.model.AddressBookData;
import com.bridgelabz.addressbookspringboot.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {

  @Autowired
  AddressBookRepo addressBookRepo;

  public List<AddressBookData> getAddressBookData() {
    return addressBookRepo.findAll();
  }

  public AddressBookData getAddressBookById(int personId) {
    return addressBookRepo.findById(personId)
            .orElseThrow(() -> new AddressBookException("Address Book Contact Id not Found!!!"));
  }

  public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
    AddressBookData addressBookData = new AddressBookData(addressBookDTO);
    addressBookRepo.save(addressBookData);
    return addressBookData;
  }

  public AddressBookData editAddressBookData(int personId, AddressBookDTO addressBookDTO) {
    AddressBookData addressBookData = this.getAddressBookById(personId);
    addressBookData.updateData(addressBookDTO);
    return addressBookRepo.save(addressBookData);
  }

  public void deleteAddressBookData(int personId) {
    AddressBookData addressBookData = this.getAddressBookById(personId);
    addressBookRepo.delete(addressBookData);
  }

  public List<AddressBookData> getContactsByCity(String city) {
    return addressBookRepo.findContactsByCity(city);
  }

  public List<AddressBookData> getContactsByState(String state) {
    return addressBookRepo.findContactsByState(state);
  }

}
