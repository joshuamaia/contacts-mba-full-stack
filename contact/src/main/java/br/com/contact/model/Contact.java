package br.com.contact.model;

import br.com.contact.dto.ContactDto;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Contact implements Serializable {

    @Autowired
    @Transient
    private ModelMapper modelMapper;

    private static ModelMapper modelMapperstatic;

    @PostConstruct
    public void init() {
        modelMapperstatic = this.modelMapper;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    public static Contact create(ContactDto contactDto) {
        return modelMapperstatic.map(contactDto, Contact.class);
    }
}
