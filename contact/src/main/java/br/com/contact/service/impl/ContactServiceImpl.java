package br.com.contact.service.impl;

import br.com.contact.dto.ContactDto;
import br.com.contact.repository.ContactRepository;
import br.com.contact.model.Contact;
import br.com.contact.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactDto> getAll() {
        List<ContactDto> collect = contactRepository.findAll().stream().map(contact -> ContactDto.create(contact)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public ContactDto create(ContactDto contactDto) {
        if (contactDto == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        Contact contact = Contact.create(contactDto);
        return ContactDto.create(contactRepository.save(contact));
    }

    @Override
    public ContactDto update(ContactDto contactDto) {
        if (contactDto == null || contactDto.getId() == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        Contact contact = Contact.create(contactDto);
        return ContactDto.create(contactRepository.save(contact));
    }

    @Override
    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Optional<ContactDto> findById(Long id) {
        Contact contact = contactRepository.findById(id).orElse(null);
        return Optional.of(ContactDto.create(contact));
    }

    @Override
    public List<ContactDto> getByName(String name) {

        List<ContactDto> collect = contactRepository.finfByNameContains(name).stream().map(contact -> ContactDto.create(contact)).collect(Collectors.toList());
        return collect;

    }
}
