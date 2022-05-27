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

//  List<AddressBookData> addressBookDataList = new ArrayList<>();

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
//    addressBookData.setFirstName(addressBookDTO.firstName);
//    addressBookData.setLastName(addressBookDTO.lastName);
//    addressBookData.setPhoneNumber(addressBookDTO.phoneNumber);
//    addressBookData.setEmail(addressBookDTO.email);
//    addressBookData.setAddress(addressBookDTO.address);
//    addressBookData.setCity(addressBookDTO.city);
//    addressBookData.setState(addressBookDTO.state);
//    addressBookData.setZip(addressBookDTO.zip);
//    addressBookRepo.set(personId - 1, addressBookData);

  }

  public void deleteAddressBookData(int personId) {
    AddressBookData addressBookData = this.getAddressBookById(personId);
    addressBookRepo.delete(addressBookData);
  }

}
