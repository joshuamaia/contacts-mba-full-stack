package br.com.contact.controller;

import br.com.contact.dto.ContactDto;
import br.com.contact.model.Contact;
import br.com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ContactDto>> getAll() {
        return ResponseEntity.ok(contactService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactDto> create(@RequestBody ContactDto contact) {
        return ResponseEntity.of(Optional.of(contactService.create(contact)));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactDto> update(@RequestBody ContactDto contact) {
        return ResponseEntity.of(Optional.of(contactService.update(contact)));
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam Long id) {
        contactService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactDto> findById(@PathVariable Long id) {
        return ResponseEntity.of(contactService.findById(id));
    }

    @GetMapping("find-by-name")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ContactDto>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(contactService.getByName(name));
    }
}
