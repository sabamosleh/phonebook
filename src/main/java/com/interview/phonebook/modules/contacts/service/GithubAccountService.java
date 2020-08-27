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

    public GithubAccount saveGithubAccountService(List<GithubRepository> repositories,GithubAccount githubAccount){

        log.info("\n\n\n\n\n"+"in saveGithubAccountService method THRED IS: "+Thread.currentThread().getName());

//        GithubRepository repos=githubAccount.getRepositories().get(0);
        for (GithubRepository repo:repositories) {
//            repo.setGithubAccount(githubAccount);
            repositoryService.save(repo);

        }

//        githubAccount.setRepositories(repositories);
        log.info("end of saveGithubAccountService method THRED IS: "+Thread.currentThread().getName());
        return githubRepository.save(githubAccount);

    }


    @Async
    public CompletableFuture<List<GithubRepository>> getContactRepositories(String githubUserName) {

        log.info("in getContactRepositories and CURRENT THREAD is: "+Thread.currentThread().getName());
        restTemplate.getInterceptors().add(basicAuthenticationInterceptor);
        log.info("in getContactRepositories set athuntication and CURRENT THREAD is: "+Thread.currentThread().getName());

        ResponseEntity<List<GithubRepository>> responseEntity = restTemplate.exchange(
                "https://api.github.com/users/"+githubUserName+"/repos?per_page=100",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GithubRepository>>() {
                });

        log.info("HEATING URL: "+"https://api.github.com/users/"+githubUserName+"/repos?per_page=100"+"\n\n\n");
        List<GithubRepository> repositories = responseEntity.getBody();
        log.info("this user repos are: "+repositories.size() +"repos");
        GithubAccount githubAccount=new GithubAccount();
        githubAccount.setRepositories(repositories);

        saveGithubAccountService(repositories,githubAccount);

        log.info("\n\n\n\n\n******REPOS COUNT******\n\n\n\n\n"+repositories.size());
        return CompletableFuture.completedFuture(repositories);

    }


}
