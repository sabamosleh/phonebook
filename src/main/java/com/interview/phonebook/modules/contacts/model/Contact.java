package com.interview.phonebook.modules.contacts.model;


import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;

//    @Column(unique = true)
    @Email
    private String email;
    private String organization;

    @OneToOne
    @JoinColumn(name="github_id",referencedColumnName = "id")
    private GithubAccount github;


    public Contact() {

    }


    public Contact(String name, String phoneNumber, String email, String organization, GithubAccount github) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.organization = organization;
        this.github = github;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public GithubAccount getGithub() {
        return github;
    }

    public void setGithub(GithubAccount github) {
        this.github = github;
    }
}
