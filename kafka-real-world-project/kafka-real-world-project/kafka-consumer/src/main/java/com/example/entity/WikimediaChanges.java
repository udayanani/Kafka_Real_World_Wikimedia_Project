package com.example.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="WikimediaChanges")
@Data
public class WikimediaChanges {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Lob
    private String eventMessage;
}
