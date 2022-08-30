package com.william.catalog.service.impl;

import com.william.catalog.dto.GenreDTO;
import com.william.catalog.dto.MovieDTO;
import com.william.catalog.entity.Genre;
import com.william.catalog.repository.GenreRepository;
import com.william.catalog.service.GenreService;
import com.william.catalog.service.MovieFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {


    @Autowired
    private GenreRepository repository;

    @Autowired
    private MovieFeign movieFeign;

    @Override
    public GenreDTO salvar(GenreDTO dto) {
        Genre entity = new Genre();
        entity.setNome(dto.getNome());
        return entityToDTO(repository.save(entity)) ;
    }

    @Override
    public GenreDTO pesquisarPorId(Long id) {
        Genre genre = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return entityToDTO(genre);
    }

    @Override
    public GenreDTO pesquisarPorNome(String nome) {
        Genre genre = repository.findByNome(nome).orElseThrow(EntityNotFoundException::new);
        return entityToDTO(genre);
    }

    @Override
    public List<MovieDTO> pesquisarMovies(String nomeGenre) {
        GenreDTO genreDTO = pesquisarPorNome(nomeGenre);
        return movieFeign.pesquisarPorIdGenre(genreDTO.getId()).getBody();
    }

    private GenreDTO entityToDTO(Genre genre){
        return GenreDTO.builder().id(genre.getId()).nome(genre.getNome()).build();
    }
}
