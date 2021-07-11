package com.example.backend.DataBase.application;

import com.example.backend.letters.db.LetterJpaRepository;
import com.example.backend.letters.domain.Letter;
import com.example.backend.sentences.db.SentenceJpaRepository;
import com.example.backend.sentences.domain.Sentence;
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

    private final LetterJpaRepository letterJpaRepository;
    private final WordJpaRepository wordJpaRepository;
    private final SentenceJpaRepository sentenceJpaRepository;

    public void clearAllDB(){
        letterJpaRepository.deleteAll();
        wordJpaRepository.deleteAll();
        sentenceJpaRepository.deleteAll();
    }

    public void loadLettersFromCSVInDB() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("letters.csv").getInputStream()))) {
            CsvToBean<CsvLetter> build = new CsvToBeanBuilder<CsvLetter>(reader)
                    .withType(CsvLetter.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            build.stream().forEach(this::initLetter);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to parse CSV file", e);
        }
    }

    public void loadSentencesFromCSVToDB() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("sentences.csv").getInputStream()))) {
            CsvToBean<CsvElement> build = new CsvToBeanBuilder<CsvElement>(reader)
                    .withType(CsvElement.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            build.stream().forEach(this::initSentences);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to parse CSV file", e);
        }
    }

    public void loadWordsFromCSVToDB() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource("words.csv").getInputStream()))) {
            CsvToBean<CsvElement> build = new CsvToBeanBuilder<CsvElement>(reader)
                    .withType(CsvElement.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            build.stream().forEach(this::initWord);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to parse CSV file", e);
        }
    }

    private void initLetter(CsvLetter csvLetter) {
        Letter letter = new Letter(
                csvLetter.getLetterp(),
                csvLetter.getLetterh(),
                csvLetter.getNazwa(),
                csvLetter.getWartoscnumeryczna(),
                csvLetter.getOpis(),
                csvLetter.getPronunciation()
        );
        letterJpaRepository.save(letter);
    }

    private void initWord(CsvElement csvWord) {
        Word word = new Word(
                csvWord.getHebrew(),
                csvWord.getPronunciation(),
                csvWord.getPolish(),
                csvWord.getDescription()
        );
        wordJpaRepository.save(word);
    }

    private void initSentences(CsvElement csvSentence) {
        Sentence sentence = new Sentence(
                csvSentence.getHebrew(),
                csvSentence.getPronunciation(),
                csvSentence.getPolish(),
                csvSentence.getDescription()
        );
        sentenceJpaRepository.save(sentence);
    }

    //This class is common for words and sentences
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CsvElement {
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
    public static class CsvLetter {
        @CsvBindByName
        private String letterp;
        @CsvBindByName
        private String letterh;
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
