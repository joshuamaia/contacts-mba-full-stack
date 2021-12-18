package br.com.contact.repository;

import br.com.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("Select c From Contact c Where c.name like %:name%")
    public List<Contact> finfByNameContains(@Param("name") String name);
}
