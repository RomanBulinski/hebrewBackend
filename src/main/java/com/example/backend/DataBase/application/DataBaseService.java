package com.example.backend.DataBase.application;

import com.example.backend.InitDataBase;
import com.example.backend.words.db.WordJpaRepository;
import com.example.backend.words.doamin.Word;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@AllArgsConstructor
public class DataBaseService {

    private final WordJpaRepository wordJpaRepository;

    public void loadWordsToDB() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("words.csv").getInputStream()))) {
            CsvToBean<InitDataBase.CsvWords> build = new CsvToBeanBuilder<InitDataBase.CsvWords>(reader)
                    .withType(InitDataBase.CsvWords.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            build.stream().forEach(this::initWords);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to parse CSV file", e);
        }
    }

    private void initWords(InitDataBase.CsvWords csvWords) {
        Word word = new Word(
                csvWords.getHebrew(),
                csvWords.getPronunciation(),
                csvWords.getPolish(),
                csvWords.getDescription()
        );
        wordJpaRepository.save(word);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CsvWords {
        @CsvBindByName
        private String hebrew;
        @CsvBindByName
        private String pronunciation;
        @CsvBindByName
        private String polish;
        @CsvBindByName
        private String description;
    }

}
