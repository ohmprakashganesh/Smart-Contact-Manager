package com.scm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SocialLinks {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    private String link;
    private String title;

    @ManyToOne
    private Contact contact;
}
