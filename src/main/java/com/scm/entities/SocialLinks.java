package com.scm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SocialLinks {

    @Id
    private Long id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}
