package com.example.backend.sentences.web;

import com.example.backend.sentences.aplication.port.SentencesUseCase;
import com.example.backend.sentences.domain.Sentence;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@CrossOrigin
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sentences")
@AllArgsConstructor
public class SentencesController {

    private final SentencesUseCase sentencesUseCase;

    @GetMapping()
    public List<Sentence> findSentences(HttpServletResponse response) {
        List<Sentence> sentences = sentencesUseCase.findAllSentences();
        response.setStatus(201);
        return sentences;
    }

//    @GetMapping(path = {"/{id}"})
//    public Owner findOne(@PathVariable("id") int id) {
//        return ownerService.findById(id);
//    }

//    @DeleteMapping(path = {"/{id}"})
//    public Owner delete(@PathVariable("id") int id) {
//        return ownerService.delete(id);
//    }

//    @PostMapping()
//    public Owner create(@RequestBody Owner owner) {
//        return ownerService.create(owner);
//    }

//    @PutMapping
//    public Owner update(@RequestBody Owner owner){
//        return ownerService.update(owner);
//    }

//    @PutMapping(path = {"/{id}"})
//    public Owner update(@RequestBody Owner owner, @PathVariable long id) {
//        return ownerService.update(owner, id);
//    }


}
