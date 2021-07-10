package com.example.backend.sentences.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sentences")
@AllArgsConstructor
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hebrew;
    private String pronunciation;
    private String polish;
    private String description;

    public Sentence() {
    }

    public Sentence(String hebrew, String pronunciation, String polish, String description) {
        this.hebrew = hebrew;
        this.pronunciation = pronunciation;
        this.polish = polish;
        this.description = description;
    }
}

