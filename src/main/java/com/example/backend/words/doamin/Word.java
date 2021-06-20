package com.example.backend.words.doamin;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "words")
@AllArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String hebrew;
    private String pronunciation;
    private String polish;
    private String description;

    public Word() {
    }

    public Word(String hebrew, String pronunciation, String polish, String description) {
        this.hebrew = hebrew;
        this.pronunciation = pronunciation;
        this.polish = polish;
        this.description = description;
    }
}

