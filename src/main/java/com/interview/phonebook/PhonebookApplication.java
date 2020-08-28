package com.interview.phonebook;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhonebookApplication {

	private static final Logger log = LoggerFactory.getLogger(PhonebookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}


}
