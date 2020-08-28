package com.interview.phonebook.service;

import com.interview.phonebook.modules.contacts.model.Contact;
import com.interview.phonebook.modules.contacts.repository.ContactRepository;
import com.interview.phonebook.modules.contacts.service.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestContactService {

    @InjectMocks
    private ContactService contactServiceMock;

    @Mock
    private ContactRepository contactRepositoryMock;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void saveContactTest(){

        Contact contact=new Contact("saba","99887766","saba@yahoo.com","Tosan","sabamosleh");
        contactServiceMock.saveContact(contact);
        verify(contactRepositoryMock,times(1)).save(contact);

    }

    @Test
    public void findContactsBySearchServiceTest(){



        List<Contact> contacts=new ArrayList<>();
        contacts.add(new Contact("saba",
                "99887766","saba@yahoo.com","Tosan",
                "sabamosleh"));
        contacts.add(new Contact("mina","11223311",
                "mina@gmail.com","Paypal","minacodes"));

        List<Contact> foundContacts=new ArrayList<>();
        foundContacts.add(new Contact("saba",
                "99887766","saba@yahoo.com","Tosan",
                "sabamosleh"));

        when(contactServiceMock.findContactsBySearchService(contacts.get(1))).thenReturn(foundContacts);

        assertEquals(1,foundContacts.size());

    }



}
