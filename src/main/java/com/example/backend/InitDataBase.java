package com.example.backend;

import com.example.backend.words.db.WordJpaRepository;
import com.example.backend.words.doamin.Word;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@AllArgsConstructor
public class InitDataBase implements CommandLineRunner {

    private final WordJpaRepository wordJpaRepository;

    @Override
    public void run(String... args) throws Exception {
//        initWords();
    }

    private void initWords() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("words_Basic.csv").getInputStream()))) {
            CsvToBean<CsvWords> build = new CsvToBeanBuilder<CsvWords>(reader)
                    .withType(CsvWords.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            build.stream().forEach(this::initWords);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to parse CSV file", e);
        }
    }

    private void initWords(CsvWords csvWords) {
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
