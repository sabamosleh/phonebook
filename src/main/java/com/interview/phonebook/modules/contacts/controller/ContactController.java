package com.interview.phonebook.modules.contacts.controller;

import com.interview.phonebook.modules.contacts.model.Contact;
import com.interview.phonebook.modules.contacts.model.GithubRepository;
import com.interview.phonebook.modules.contacts.service.ContactService;
import com.interview.phonebook.modules.contacts.service.GithubAccountService;
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
    private GithubAccountService githubAccountService;

    @Autowired
    public ContactController(ContactService contactService, GithubAccountService githubAccountService){

        this.contactService=contactService;
        this.githubAccountService=githubAccountService;

    }


    @RequestMapping(value = "/contacts",method = RequestMethod.PUT)
    public @ResponseBody
         Contact addContact(@RequestBody Contact contact){

        CompletableFuture<List<GithubRepository>> cars1=githubAccountService.getContactRepositories();

//        try {
//                cars1.(200000);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }

//        CompletableFuture<List<GithubRepository>> cars2=githubAccountService.getContactRepositories();
//
//        CompletableFuture<List<GithubRepository>> cars3=githubAccountService.getContactRepositories();
//
//        CompletableFuture.allOf(cars1, cars2, cars3).join();


        System.out.println("\n\n\n\n\n\n\n"+"adding...............");



        return contactService.saveContact(contact);

    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public @ResponseBody
        List<Contact> findContactsBySearchController(@RequestBody Contact contact){
        return contactService.findContactsBySearchService(contact);
    }


}
