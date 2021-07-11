package com.example.backend.letters.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "letters")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(fetch = FetchType.EAGER)
    private Long id;
    private String letterp;
    private String letterh;
    private String nazwa;
    private Long wartoscnumeryczna;
    private String opis;
    private String pronunciation;

    public Letter(String letterp, String letterh, String nazwa, Long wartoscnumeryczna, String opis, String pronunciation) {
        this.letterp = letterp;
        this.letterh = letterh;
        this.nazwa = nazwa;
        this.wartoscnumeryczna = wartoscnumeryczna;
        this.opis = opis;
        this.pronunciation = pronunciation;
    }


}
