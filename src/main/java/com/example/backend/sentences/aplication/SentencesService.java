package com.example.backend.sentences.aplication;

import com.example.backend.sentences.aplication.port.SentencesUseCase;
import com.example.backend.sentences.domain.Sentence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SentencesService implements SentencesUseCase {

    private final com.example.backend.sentences.db.SentenceJpaRepository SentenceJpaRepository;

    @Override
    public List<Sentence> findAllSentences() {
        return SentenceJpaRepository.findAll();
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
