package com.interview.phonebook;

import com.interview.phonebook.modules.contacts.model.GithubAccount;
import com.interview.phonebook.modules.contacts.model.GithubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class PhonebookApplication {

	private static final Logger log = LoggerFactory.getLogger(PhonebookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//
//		return restTemplateBuilder.build();
//
//	}
//
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate){
//
//	    restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor("sabamosleh","66978716s"));
//		return args -> {
//            GithubRepository[]
//					 githubAccount=
//					    restTemplate.getForEntity("https://api.github.com/users/burrsutter/repos?per_page=100",
//                                GithubRepository[].class).getBody();
//
//            GithubRepository[]
//                    githubAccount_page2=
//                    restTemplate.getForEntity("https://api.github.com/users/burrsutter/repos?per_page=100&page=2",
//                           GithubRepository[].class).getBody();
//
////            log.info("******\n\n\n"+githubAccount.getRepositories().size()+githubAccount_page2.length);
//            for(int i=0;i<githubAccount.length;i++)
//			log.info("******\n\n\n"+githubAccount[i].getName());
//
//            for(int i=0;i<githubAccount_page2.length;i++)
//                log.info("******\n\n\n"+githubAccount_page2[i].getName());
//		};

//	}

}
