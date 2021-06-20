package com.example.backend.letters.application;

import com.example.backend.letters.application.port.LetterUseCase;
import com.example.backend.letters.db.LetterJpaRepository;
import com.example.backend.letters.domain.Letter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LetterService implements LetterUseCase {

    private final LetterJpaRepository letterRepository;

    @Override
    public List<Letter> findAllLetters() {
         return letterRepository.findAll();
    }

//    @Override
//    public Letter delete(long id) {
//        Letter letter = letterRepository.findById(id).get();
//        if(letter != null){
//            letterRepository.delete(letter);
//        }
//        return letter;
//    }

//    @Override
//    public Owner create(Owner owner) {
//        return ownerRepository.save(owner);
//    }

//    @Override
//    public Owner findById(int id) {
//        long longId = (long) id;
//        return ownerRepository.getOne(longId);
//    }

//    @Override
//    public Owner update(Owner owner, long id) {
//        Owner ownerFromRepository = ownerRepository.findById(id).get();
//        if (ownerFromRepository != null) {
//            owner.setId(id);
//            ownerRepository.save(owner);
//        }else{
//            return null;
//        }
//        return owner;
//    }
}
