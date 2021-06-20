package com.example.backend.words.web;

import com.example.backend.words.application.port.WordUseCase;
import com.example.backend.words.application.port.WordUseCase.CreateWordCommand;
import com.example.backend.words.doamin.Word;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


//@CrossOrigin
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/words")
@AllArgsConstructor
public class WordController {

    private final WordUseCase wordUseCase;

    /**
     * komentarz
     *
     * @param response
     * @return
     */
    @GetMapping()
    public List<Word> findWords(HttpServletResponse response) {
        List<Word> words = wordUseCase.findAllWords();
        response.setStatus(201);
        return words;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Word> addWord(@Valid @RequestBody RestWordCommand restWordCommand) {
        Word word = wordUseCase.add( restWordCommand.toCreateWordCommand() );
        return ResponseEntity.created(createdOwnerUri(word)).build();
    }

    private URI createdOwnerUri(Word word) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/" + word.getId().toString()).build().toUri();
        return uri;
    }

    @Data
    private static class RestWordCommand {
        String hebrew;
        String pronunciation;
        String polish;
        String description;

        CreateWordCommand toCreateWordCommand() {
            return new CreateWordCommand(hebrew, pronunciation, polish, description);
        }
    }


//    @PutMapping
//    public Word update(@RequestBody Word word){
//        return wordUseCase.update(word);
//    }

//    @GetMapping(path = {"/{id}"})
//    public Owner findOne(@PathVariable("id") int id) {
//        return ownerService.findById(id);
//    }

//    @DeleteMapping(path = {"/{id}"})
//    public Owner delete(@PathVariable("id") int id) {
//        return ownerService.delete(id);
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
