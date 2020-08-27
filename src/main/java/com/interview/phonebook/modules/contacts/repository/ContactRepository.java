package com.interview.phonebook.modules.contacts.repository;

import com.interview.phonebook.modules.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {


    @Query("select c from Contact c where c.name like concat('%',:#{#contact.name},'%')" +
            "or c.email like concat('%',:#{#contact.email},'%')" +
            "or c.organization like concat('%',:#{#contact.organization},'%') " +
            "or c.phoneNumber like concat('%',:#{#contact.phoneNumber},'%')")
    List<Contact> findBySearch(@Param("contact")Contact contact);



}
