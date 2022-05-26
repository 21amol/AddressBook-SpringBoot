package com.bridgelabz.addressbookspringboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookSpringBootApplication {

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(AddressBookSpringBootApplication.class, args);
    log.info("Address Book Application Started in {} Environment",
            context.getEnvironment().getProperty("environment"));
    System.out.println("Welcome to Address Book Program");
  }
}
