package com.bridgelabz.addressbookspringboot.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.*;


@Data                             // Lombak library for getters, setters and toString...
public class AddressBookDTO {

  @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid First Name")
  public String firstName;

  @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{1,}$", message = "Invalid Last Name")
  public String lastName;

  @Pattern(regexp = "^[6-9]{1}[0-9]{9}$", message = "Invalid Phone Number")
  public String phoneNumber;

  @Pattern(regexp = "^([a-z0-9-+]*)[.]{0,1}([0-9a-z]*)@([a-z]+)[.]{1}([a-z]+)$", message = "Invalid Email")
  public String email;

 // @Pattern(regexp = "^[A-Z]{1}[a-z]{1,}$", message = "Invalid Address")
  @NotEmpty (message = "Address cannot be empty.")
  public String address;

  @Pattern(regexp = "^[A-Z]{1}[a-z]{1,}$", message = "Invalid City Name")
  public String city;

  @Pattern(regexp = "^[A-Z]{1}[a-z]{1,}$", message = "Invalid State Name")
  public String state;

  @Pattern(regexp = "^[1-8]{1}[0-9]{5}$", message = "Invalid Zip Code")
  public String zip;

  public AddressBookDTO(String firstName, String lastName, String phoneNumber, String email,
                        String address, String city, String state, String zip) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }
}
