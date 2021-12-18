package br.com.contact.dto;

import br.com.contact.model.Contact;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import org.springframework.data.annotation.Transient;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ContactDto {

    @Autowired
    @JsonIgnore
    private ModelMapper modelMapper;

    private static ModelMapper modelMapperstatic;

    @PostConstruct
    public void init() {
        modelMapperstatic = this.modelMapper;
    }

    private Long id;
    private String name;
    private String email;
    private String phone;

    public static ContactDto create(Contact contact) {
        return modelMapperstatic.map(contact, ContactDto.class);
    }
}
