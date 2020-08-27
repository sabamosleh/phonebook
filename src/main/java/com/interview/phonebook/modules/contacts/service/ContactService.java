package com.interview.phonebook.modules.contacts.service;


import com.interview.phonebook.modules.contacts.model.Contact;
import com.interview.phonebook.modules.contacts.model.GithubAccount;
import com.interview.phonebook.modules.contacts.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private GithubAccountService githubAccountService;
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);



    @Autowired
    public ContactService(ContactRepository contactRepository,GithubAccountService githubAccountService){


        this.contactRepository=contactRepository;
        this.githubAccountService=githubAccountService;

    }


    @Transactional
    public Contact saveContact(Contact contact){
        log.info("\n\n\n\n save contact...");
        githubAccountService.getContactRepositories(contact.getName());
        return  contactRepository.save(contact);

    }

    public List<Contact> findContactsBySearchService(Contact contact){

        return contactRepository.findBySearch(contact);

    }








}
