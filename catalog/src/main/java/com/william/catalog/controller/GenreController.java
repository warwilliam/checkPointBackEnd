package com.william.catalog.controller;

import com.william.catalog.dto.GenreDTO;
import com.william.catalog.dto.MovieDTO;
import com.william.catalog.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class GenreController {

    @Autowired
    private GenreService service;

    @PostMapping
    private ResponseEntity<GenreDTO> salvar(@RequestBody GenreDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/nome/{nome}")
    private ResponseEntity<GenreDTO> pesquisarPorNome(@PathVariable String nome){
        return ResponseEntity.ok(service.pesquisarPorNome(nome));

    }
    @GetMapping("/{id}")
    private ResponseEntity<GenreDTO> pesquisarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.pesquisarPorId(id));
    }

    @GetMapping("/movies/{nomeGenre}")
    private ResponseEntity<List<MovieDTO>>pesquisarMoviesPorGenre(@PathVariable String nomeGenre){
        return ResponseEntity.ok(service.pesquisarMovies(nomeGenre));
    }

}
