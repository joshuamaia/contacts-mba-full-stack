package br.com.contact.service;

import br.com.contact.dto.ContactDto;
import br.com.contact.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    public List<ContactDto> getAll();

    public ContactDto create(ContactDto contactDto);

    public ContactDto update(ContactDto contactDto);

    public void delete(Long id);

    public Optional<ContactDto> findById(Long id);

    public List<ContactDto> getByName(String name);
}
