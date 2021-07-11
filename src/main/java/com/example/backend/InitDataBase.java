package com.example.backend;

import com.example.backend.DataBase.application.DataBaseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitDataBase implements CommandLineRunner {

    private final DataBaseService dataBaseService;

    @Override
    public void run(String... args) throws Exception {

        dataBaseService.clearAllDB();

        dataBaseService.loadWordsFromCSVToDB();
        dataBaseService.loadSentencesFromCSVToDB();
        dataBaseService.loadLettersFromCSVInDB();
    }
}
