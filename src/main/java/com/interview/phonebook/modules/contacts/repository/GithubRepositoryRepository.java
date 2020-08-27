package com.interview.phonebook.modules.contacts.repository;

import com.interview.phonebook.modules.contacts.model.GithubRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  GithubRepositoryRepository extends JpaRepository<GithubRepository,Long> {
}
