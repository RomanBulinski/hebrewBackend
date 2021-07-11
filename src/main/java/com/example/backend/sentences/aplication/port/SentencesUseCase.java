package com.example.backend.sentences.aplication.port;

import com.example.backend.letters.domain.Letter;
import com.example.backend.sentences.domain.Sentence;

import java.util.List;

public interface SentencesUseCase {

    List<Sentence> findAllSentences();
//    Letter delete(long id);
//    Owner create(Owner owner);
//    Owner findById(int id);
//    Owner update(Owner owner, long id);

}
