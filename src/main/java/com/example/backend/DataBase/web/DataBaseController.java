package com.example.backend.DataBase.web;

import com.example.backend.DataBase.application.DataBaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/dataBase")
@AllArgsConstructor
public class DataBaseController {

    private final DataBaseService dataBaseService;

    @GetMapping()
    public void initDataBase() {
        dataBaseService.loadWordsToDB();
    }

}
