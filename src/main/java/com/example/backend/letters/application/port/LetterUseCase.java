package com.example.backend.letters.application.port;

import com.example.backend.letters.domain.Letter;

import java.util.List;

public interface LetterUseCase {

    List<Letter> findAllLetters();
//    Letter delete(long id);
//    Owner create(Owner owner);
//    Owner findById(int id);
//    Owner update(Owner owner, long id);

}
