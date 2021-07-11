package com.example.backend.letters.db;

import com.example.backend.letters.domain.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface LetterJpaRepository extends JpaRepository<Letter, Long> {

//    void delete(Letter letter);
}
