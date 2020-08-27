package com.interview.phonebook.modules.contacts.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;


@Entity
@Table(name = "contact")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String name;

    private String phoneNumber;

//    @Column(unique = true)
    @Email
    private String email;

    private String organization;


    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="github_account",referencedColumnName = "github_name")
    @Nullable
    @JsonIgnore
    private GithubAccount githubAccount;

    @JsonProperty("github")
    private String githubUsername;

    public Contact() {

    }


    public Contact(String name, String phoneNumber, String email, String organization, GithubAccount githubAccount,String githubUsername) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.organization = organization;
        this.githubUsername=githubUsername;
        this.githubAccount = githubAccount;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Nullable
    public GithubAccount getGithubAccount() {
        return githubAccount;
    }

    public void setGithubAccount(@Nullable GithubAccount githubAccount) {
        this.githubAccount = githubAccount;
    }

    public String getGithubUsername() {
        return githubUsername;
    }

    public void setGithubUsername(String githubUsername) {
        this.githubUsername = githubUsername;
    }
}
