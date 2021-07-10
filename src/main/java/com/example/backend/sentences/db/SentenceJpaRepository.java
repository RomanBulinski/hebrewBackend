package com.example.backend.sentences.db;

import com.example.backend.sentences.domain.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentenceJpaRepository extends JpaRepository<Sentence, Long> {

}
