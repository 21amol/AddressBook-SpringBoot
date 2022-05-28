package com.bridgelabz.addressbookspringboot.controller;

import com.bridgelabz.addressbookspringboot.dto.AddressBookDTO;
import com.bridgelabz.addressbookspringboot.dto.ResponseDTO;
import com.bridgelabz.addressbookspringboot.model.AddressBookData;
import com.bridgelabz.addressbookspringboot.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

  @Autowired
  AddressBookService addressBookService;


  @GetMapping(value = {"/get"})
  public ResponseEntity<ResponseDTO> getAddressBookData() {
    List<AddressBookData> addressBookDataList = addressBookService.getAddressBookData();
    ResponseDTO responseDTO = new ResponseDTO("Success Call!!!", addressBookDataList);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @GetMapping(value = {"/get/{personId}"})
  public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable int personId) {
    AddressBookData addressBookData = addressBookService.getAddressBookById(personId);
    ResponseDTO responseDTO = new ResponseDTO("Success Call for Person Id!!!", addressBookData);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @PostMapping(value = {"/add"})
  public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
    AddressBookData addressBookData = addressBookService.addAddressBookData(addressBookDTO);
    ResponseDTO responseDTO = new ResponseDTO("Data ADDED Successfully!!!", addressBookData);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @PutMapping(value = {"/edit/{personId}"})
  public ResponseEntity<ResponseDTO> editAddressBookData(@PathVariable int personId,
                                                       @Valid @RequestBody AddressBookDTO addressBookDTO) {
    AddressBookData addressBookData = addressBookService.editAddressBookData(personId, addressBookDTO);
    ResponseDTO responseDTO = new ResponseDTO("Data UPDATED Successfully!!!", addressBookData);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @DeleteMapping(value = {"/remove/{personId}"})
  public ResponseEntity<ResponseDTO> removeAddressBookData(@PathVariable int personId) {
    addressBookService.deleteAddressBookData(personId);
    ResponseDTO responseDTO = new ResponseDTO("Data DELETED Successfully!!!",
            "ID number: " + personId + " --> DELETED!!!");
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @GetMapping(value = {"/city"})
  public ResponseEntity<ResponseDTO> getContactsByCity() {
    List<AddressBookData> addressBookDataList = addressBookService.getContactsByCity();
    ResponseDTO responseDTO = new ResponseDTO("Success call for City!!!", addressBookDataList);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

  @GetMapping(value = {"/state"})
  public ResponseEntity<ResponseDTO> getContactsByState() {
    List<AddressBookData> addressBookDataList = addressBookService.getContactsByState();
    ResponseDTO responseDTO = new ResponseDTO("Success call for State!!!", addressBookDataList);
    return new ResponseEntity<>(responseDTO, HttpStatus.OK);
  }

}