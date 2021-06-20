package com.example.backend.words.application.port;

import com.example.backend.words.doamin.Word;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

public interface WordUseCase {

    List<Word> findAllWords();
//    Letter delete(long id);
    Word add(CreateWordCommand  createWordCommand);
//    Owner findById(int id);
//    Owner update(Owner owner, long id);

    @Value
    @Builder
    @AllArgsConstructor
    class CreateWordCommand {
        String hebrew;
        String pronunciation;
        String polish;
        String description;
    }
}
