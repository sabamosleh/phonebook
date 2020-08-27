package com.interview.phonebook.modules.contacts.service;


import com.interview.phonebook.modules.contacts.model.GithubRepository;
import com.interview.phonebook.modules.contacts.repository.GithubRepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GithubRepositoryService {

    private GithubRepositoryRepository githubRepository;

    @Autowired
    public GithubRepositoryService(GithubRepositoryRepository githubRepository) {
        this.githubRepository = githubRepository;
    }


    public GithubRepository save(GithubRepository githubRepository){

       return this.githubRepository.save(githubRepository);

    }

}
