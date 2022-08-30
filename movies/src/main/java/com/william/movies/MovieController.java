package com.william.movies;


import com.william.movies.dto.MovieDTO;
import com.william.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @PostMapping
    private ResponseEntity<MovieDTO> salvar(@RequestBody MovieDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/genre/{idGenre}")
    private ResponseEntity<List<MovieDTO>> pesquisaPorGenre(@PathVariable Long idGenre) {
        return ResponseEntity.ok(service.pesquisarPorGenre(idGenre));
    }

}
