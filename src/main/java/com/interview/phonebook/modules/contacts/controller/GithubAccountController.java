package com.interview.phonebook.modules.contacts.controller;


import com.interview.phonebook.modules.contacts.model.GithubAccount;
import com.interview.phonebook.modules.contacts.model.GithubRepository;
import com.interview.phonebook.modules.contacts.service.GithubAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("/githubaccount")
public class GithubAccountController {


    private GithubAccountService githubAccountService;

    @Autowired
    public GithubAccountController(GithubAccountService githubAccountService) {
        this.githubAccountService = githubAccountService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public
    @ResponseBody
     GithubAccount save(@RequestBody List<GithubRepository> repositories){

        GithubAccount githubAccount=new GithubAccount();


        return githubAccountService.saveGithubAccountService(githubAccount);

    }


}
