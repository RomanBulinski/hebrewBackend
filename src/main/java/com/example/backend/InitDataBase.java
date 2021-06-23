package com.example.backend;

import com.example.backend.letters.db.LetterJpaRepository;
import com.example.backend.letters.domain.Letter;
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
    private final LetterJpaRepository letterJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        initWordsInDB();
        initLettersInDB();
    }

    private void initWordsInDB() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("words.csv").getInputStream()))) {
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

    private void initLettersInDB() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("letters_with_heders.csv").getInputStream()))) {
            CsvToBean<CsvLetters> build = new CsvToBeanBuilder<CsvLetters>(reader)
                    .withType(CsvLetters.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            build.stream().forEach(this::initLetters);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to parse CSV file", e);
        }
    }

    private void initLetters(CsvLetters csvLetters) {
        Letter letter = new Letter(
                csvLetters.getLetterp(),
                csvLetters.getLetterh(),
                csvLetters.getLetterh2(),
                csvLetters.getNazwa(),
                csvLetters.getWartoscnumeryczna(),
                csvLetters.getOpis(),
                csvLetters.getPronunciation()
        );
        letterJpaRepository.save(letter);
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

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CsvLetters {
        @CsvBindByName
        private String letterp;
        @CsvBindByName
        private String letterh;
        @CsvBindByName
        private String letterh2;
        @CsvBindByName
        private String nazwa;
        @CsvBindByName
        private Long wartoscnumeryczna;
        @CsvBindByName
        private String opis;
        @CsvBindByName
        private String pronunciation;
    }
}
