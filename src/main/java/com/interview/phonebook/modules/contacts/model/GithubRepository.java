package com.interview.phonebook.modules.contacts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "github_repos")
public class GithubRepository {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("full_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "github_account_fk")
    private GithubAccount githubAccount;

    public GithubRepository() {
    }

    public GithubRepository(String name, GithubAccount githubAccount) {
        this.name = name;
        this.githubAccount = githubAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GithubAccount getGithubAccount() {
        return githubAccount;
    }

    public void setGithubAccount(GithubAccount githubAccount) {
        this.githubAccount = githubAccount;
    }

    @Override
    public String toString() {
        return "GithubRepository{" +
                "name='" + name + '\'' +
                '}';
    }
}


