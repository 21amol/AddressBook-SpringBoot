package com.bridgelabz.addressbookspringboot.model;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import lombok.Data;

@Data                           // Lombak library for getters and setters...
public class AddressBookData {
  private int personId;
  private String firstName;
  private String lastName;
  private String phoneNumber;
  private String email;
  private String address;
  private String city;
  private String state;
  private int zip;


  public AddressBookData() {
  }


  public AddressBookData(int personId, AddressBookDTO addressBookDTO) {
    this.personId = personId;
    this.firstName = addressBookDTO.firstName;
    this.lastName = addressBookDTO.lastName;
    this.phoneNumber = addressBookDTO.phoneNumber;
    this.email = addressBookDTO.email;
    this.address = addressBookDTO.address;
    this.city = addressBookDTO.city;
    this.state = addressBookDTO.state;
    this.zip = addressBookDTO.zip;
  }
}
