package com.interview.phonebook.modules.contacts.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "github_account")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubAccount {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
//    @JsonProperty("full_name")
//    private String github;

    @OneToMany(mappedBy = "githubAccount")
    private List<GithubRepository> repositories;

    @OneToOne(mappedBy = "github")
    private Contact contact;


    public GithubAccount() {



    }

    public GithubAccount(String github, List<GithubRepository> repositories, Contact contact) {
//        this.github = github;
        this.repositories = repositories;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }


//    public String getGithub() {
//        return github;
//    }
//
//    public void setGithub(String github) {
//        this.github = github;
//    }

    public List<GithubRepository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<GithubRepository> repositories) {
        this.repositories = repositories;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


//    @Override
//    public String toString() {
//        return "{"+"github"+":"+repositories.toString()+"}";
//    }
}
