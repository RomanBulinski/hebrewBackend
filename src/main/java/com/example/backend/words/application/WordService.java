package com.example.backend.words.application;

import com.example.backend.words.application.port.WordUseCase;
import com.example.backend.words.doamin.Word;
import com.example.backend.words.db.WordJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WordService implements WordUseCase {

    private final WordJpaRepository wordRepository;

    @Override
    public List<Word> findAllWords() {
        return (List<Word>) wordRepository.findAll();
    }

    @Override
    public Word add(CreateWordCommand createWordCommand) {
        Word word = new Word(
                createWordCommand.getHebrew(),
                createWordCommand.getPronunciation(),
                createWordCommand.getPolish(),
                createWordCommand.getDescription()
        );
        return wordRepository.save(word);
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
