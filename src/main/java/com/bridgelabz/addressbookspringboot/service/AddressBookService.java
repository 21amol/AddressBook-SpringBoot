package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {


  public List<AddressBookData> getAddressBookData() {
    List<AddressBookData> addressBookDataList = new ArrayList<>();
    addressBookDataList.add(new AddressBookData(1, new AddressBookDTO("Amol",
            "Ghotale", "8657169656", "amol9.ag@gmail.com", "Manjari BK",
            "Pune", "Maharashtra", 412307)));
    return addressBookDataList;
  }

  public AddressBookData getAddressBookById(int personId) {
    AddressBookData addressBookData = new AddressBookData(personId, new AddressBookDTO("Amol",
            "Ghotale", "8657169656", "amol9.ag@gmail.com", "Manjari BK",
            "Pune", "Maharashtra", 412307));
    return addressBookData;
  }

  public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
    AddressBookData addressBookData = new AddressBookData(1, addressBookDTO);
    return addressBookData;
  }

  public AddressBookData editAddressBookData(int personId, AddressBookDTO addressBookDTO) {
    AddressBookData addressBookData = new AddressBookData(personId, addressBookDTO);
    return addressBookData;
  }

  public void deleteAddressBookData(int personId){

  }

}
