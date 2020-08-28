package com.interview.phonebook.modules.contacts.service;


import com.interview.phonebook.modules.contacts.model.Contact;
import com.interview.phonebook.modules.contacts.model.GithubRepo;
import com.interview.phonebook.modules.contacts.repository.GithubRepositoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@EnableAsync
public class GithubRepositoryService {

    private GithubRepositoryRepository githubRepository;
    private RestTemplate restTemplate;
    private BasicAuthenticationInterceptor basicAuthenticationInterceptor;
    private static final Logger log = LoggerFactory.getLogger(GithubRepositoryService.class);


    @Autowired
    public GithubRepositoryService(GithubRepositoryRepository githubRepository,
                                   RestTemplate restTemplate,
                                   BasicAuthenticationInterceptor basicAuthenticationInterceptor) {
        this.githubRepository = githubRepository;
        this.restTemplate = restTemplate;
        this.basicAuthenticationInterceptor = basicAuthenticationInterceptor;
    }




    public GithubRepo saveGithubRepServie(GithubRepo githubRepo){

       return this.githubRepository.save(githubRepo);

    }

    private List<GithubRepo> getReposPerPage(Contact contact){


        restTemplate.getInterceptors().add(basicAuthenticationInterceptor);
        log.info("in getContactRepositories set athuntication and CURRENT THREAD is: "+Thread.currentThread().getName());
        ResponseEntity<List<GithubRepo>> responseEntity = restTemplate.exchange(
                "https://api.github.com/users/"+contact.getGithubUsername()+"/repos?per_page=100",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GithubRepo>>() {
                });

        log.info("HEATING URL: "+"https://api.github.com/users/"+contact.getGithubUsername()+"/repos?per_page=100"+"\n\n\n");
        log.info("\n\n\n\n"+responseEntity.getHeaders());
        log.info("\n\n\n\n"+responseEntity.getBody());
        List<GithubRepo> repositories = responseEntity.getBody();
        log.info("this user repos are: "+repositories.size() +"repos");

        return repositories;

    }


    @Async
    public CompletableFuture<List<GithubRepo>> getContactRepositories(Contact contact) {

        log.info("in getContactRepositories and CURRENT THREAD is: "+Thread.currentThread().getName());

        List<GithubRepo> repositories=getReposPerPage(contact);

        if (repositories.size()==100){

            repositories.addAll(getReposPerPage(contact));

        }


        for (GithubRepo repo:repositories) {
            repo.setContact(contact);
            saveGithubRepServie(repo);
        }


        log.info("\n\n\n\n\n******REPOS COUNT******\n\n\n\n\n"+repositories.size());
        return CompletableFuture.completedFuture(repositories);

    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
