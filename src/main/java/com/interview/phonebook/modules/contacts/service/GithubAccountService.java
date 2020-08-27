package com.interview.phonebook.modules.contacts.service;

import com.interview.phonebook.modules.contacts.model.GithubAccount;
import com.interview.phonebook.modules.contacts.model.GithubRepository;
import com.interview.phonebook.modules.contacts.repository.GithubAccountRespository;
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
public class GithubAccountService {



    private RestTemplate restTemplate;
    private BasicAuthenticationInterceptor basicAuthenticationInterceptor;
    private GithubAccountRespository githubRepository;
    private GithubRepositoryService repositoryService;
    private static final Logger log = LoggerFactory.getLogger(GithubAccountService.class);





    @Autowired
    public GithubAccountService(GithubAccountRespository githubRepository,
                                RestTemplate restTemplate,
                                BasicAuthenticationInterceptor basicAuthenticationInterceptor,
    GithubRepositoryService repositoryService) {
        this.githubRepository = githubRepository;
        this.restTemplate=restTemplate;
        this.basicAuthenticationInterceptor=basicAuthenticationInterceptor;
        this.repositoryService=repositoryService;
    }

    public GithubAccount saveGithubAccountService(GithubAccount githubAccount){
        log.info("save github account ...");
        log.info("\n\n\n\n\n******Save git account THREAD IS:******"+Thread.currentThread().getName());
//        List<GithubRepository> repositories=getContactRepositories();//rather than creating a threa per save request list call getContactRepositories frequantly
        //departed from saveGithubAccountService

//        CompletableFuture <List<GithubRepository>> repositories=getContactRepositories();


        log.info("after getting repos....");


//        for (GithubRepository repo:repositories) {
//            repo.setGithubAccount(githubAccount);
//            repositoryService.save(repo);
//
//        }
        log.info("set repos in account object...");
        return githubRepository.save(githubAccount);

    }

//    @Async
//    public List<GithubRepository> getContactRepositories() {
//        restTemplate.getInterceptors().add(basicAuthenticationInterceptor);
////try catch at service call
//        ResponseEntity<List<GithubRepository>> responseEntity = restTemplate.exchange(
//                "https://api.github.com/users/burrsutter/repos?per_page=100",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<GithubRepository>>() {
//                });
//        List<GithubRepository> repositories = responseEntity.getBody();
//
//        log.info("\n\n\n\n\n************\n\n\n\n\n"+repositories.get(0).getName());
//        log.info("\n\n\n\n\n******CURRENT THREAD IS:******"+Thread.currentThread().getId());
//        return repositories;
//
//    }


    @Async
    public CompletableFuture<List<GithubRepository>> getContactRepositories() {
        log.info("\n\n\n\n\n******CURRENT THREAD IS:******"+Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
            log.info("\n\n\n\n\n\n\n\n\n"+"SLEEP"+"\n\n\n\n\n\n");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        restTemplate.getInterceptors().add(basicAuthenticationInterceptor);
//try catch at service call
        ResponseEntity<List<GithubRepository>> responseEntity = restTemplate.exchange(
                "https://api.github.com/users/burrsutter/repos?per_page=100",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GithubRepository>>() {
                });
        List<GithubRepository> repositories = responseEntity.getBody();

//        saveGithubAccountService();
//        call

        log.info("\n\n\n\n\n************\n\n\n\n\n"+repositories.get(0).getName());
        return CompletableFuture.completedFuture(repositories);

    }


}
