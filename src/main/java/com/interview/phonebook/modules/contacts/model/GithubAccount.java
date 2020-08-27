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

    @Column(name = "github_name")
    private String name;

    @OneToMany(mappedBy = "githubAccount")
    private List<GithubRepository> repositories;

    @OneToOne(mappedBy = "githubAccount")
    private Contact contact;


    public GithubAccount() {



    }

    public GithubAccount(String name, List<GithubRepository> repositories, Contact contact) {
        this.name = name;
        this.repositories = repositories;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }


    public String getGithub() {
        return name;
    }

    public void setGithub(String name) {
        this.name = name;
    }

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
