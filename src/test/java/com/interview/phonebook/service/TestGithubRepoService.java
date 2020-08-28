package com.interview.phonebook.service;


import com.interview.phonebook.modules.contacts.model.Contact;
import com.interview.phonebook.modules.contacts.model.GithubRepo;
import com.interview.phonebook.modules.contacts.repository.GithubRepositoryRepository;
import com.interview.phonebook.modules.contacts.service.GithubRepositoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import java.net.MalformedURLException;
import java.net.URL;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = GithubRepositoryRepository.class)
public class TestGithubRepoService {

    @Mock
    private GithubRepositoryRepository githubRepositoryRepository;



    @InjectMocks
    private GithubRepositoryService githubRepositoryService;




    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void saveGithubRepService(){
        Contact contact=new Contact();
        contact.setId(Long.valueOf("1"));
        contact.setName("mona");
        contact.setPhoneNumber("55778899");
        contact.setOrganization("org1");
        contact.setEmail("mina@yahoo.com");
        GithubRepo githubRepo=new GithubRepo("Acitiviti",contact);

        githubRepositoryService.saveGithubRepServie(githubRepo);
        verify(githubRepositoryRepository,times(1)).save(githubRepo);


    }




    @Test
    public void getReposPerPageTest(){


        String url = null;
        try {
            url = new URL("https://api.github.com/users/sabamosleh/repos?per_page=100").toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url, String.class);
        assert (response.getBody()!=null);




    }
    public Contact getContactObject(){

        Contact contact=new Contact();
        contact.setId(Long.valueOf("1"));
        contact.setName("mona");
        contact.setPhoneNumber("55778899");
        contact.setOrganization("org1");
        contact.setEmail("mina@yahoo.com");

        return contact;
    }





}
