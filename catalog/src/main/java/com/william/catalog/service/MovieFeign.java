package com.william.catalog.service;

import com.william.catalog.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="MOVIES-SERVICE")
public interface MovieFeign {

    @GetMapping("/movie/genre/{idGenre}")
    ResponseEntity<List<MovieDTO>> pesquisarPorIdGenre(@PathVariable Long idGenre);
}
