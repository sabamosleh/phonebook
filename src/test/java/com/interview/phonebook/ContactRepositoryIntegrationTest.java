//package com.interview.phonebook.model;
//
//import Contact;
//import GithubRepo;
//import GithubRepositoryRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class ContactRepositoryIntegrationTest {
//
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private GithubRepositoryRepository githubRepositoryRepository;
//
//
//    @Before
//    public void setUp(){
//
//        GithubRepo githubRepo=githubRepoObject();
//
//        entityManager.persist(githubRepo);
//
//
//    }
//
//    @Test
//    public void save_github_repo_return_object(){
//
//        GithubRepo githubRepos=githubRepositoryRepository.save(githubRepoObject());
//
//        assert (githubRepos.getName()=="TEST");
//
//    }
//
//    public GithubRepo githubRepoObject(){
//
//        return new GithubRepo("TEST", getContactObject());
//
//    }
//
//    public Contact getContactObject(){
//
//        Contact contact=new Contact();
//        contact.setId(Long.valueOf("1"));
//        contact.setName("mona");
//        contact.setPhoneNumber("55778899");
//        contact.setOrganization("org1");
//        contact.setEmail("mina@yahoo.com");
//
//        return contact;
//    }
//
//
//
//
//
//
//
//}
