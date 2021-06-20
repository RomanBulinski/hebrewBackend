package com.example.backend.letters.db;

import com.example.backend.letters.domain.Letter;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<Letter, Long> {


//    void delete(Letter letter);

}
