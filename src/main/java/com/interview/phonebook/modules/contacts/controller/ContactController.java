package com.interview.phonebook.modules.contacts.controller;

import com.interview.phonebook.modules.contacts.model.Contact;
import com.interview.phonebook.modules.contacts.service.ContactService;
import com.interview.phonebook.modules.contacts.model.GithubRepo;
import com.interview.phonebook.modules.contacts.service.GithubRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("")
@EnableAsync
public class ContactController {

    private ContactService contactService;
    private GithubRepositoryService githubRepositoryService;

    @Autowired
    public ContactController(ContactService contactService, GithubRepositoryService githubRepositoryService) {
        this.contactService = contactService;
        this.githubRepositoryService = githubRepositoryService;
    }




    @RequestMapping(value = "/contacts",method = RequestMethod.PUT)
    public @ResponseBody
    Contact addContact(@RequestBody Contact contact){

        CompletableFuture<List<GithubRepo>> repositories=
                githubRepositoryService.getContactRepositories(contact);

        return contactService.saveContact(contact);

    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public @ResponseBody
        List<Contact> findContactsBySearchController(@RequestBody Contact contact){
        return contactService.findContactsBySearchService(contact);
    }


}
