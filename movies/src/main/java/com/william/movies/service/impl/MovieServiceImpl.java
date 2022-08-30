package com.william.movies.service.impl;

import com.william.movies.dto.MovieDTO;
import com.william.movies.entity.Movie;
import com.william.movies.repository.MovieRepository;
import com.william.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public MovieDTO salvar(MovieDTO dto) {
        Movie entity = new Movie();
        entity.setNomeMovie(dto.getNomeMovie());
        entity.setUrlStream(dto.getUrlStream());
        entity.setIdGenre(dto.getIdGenre());
        return entityToDTO(repository.save(entity));
    }



    @Override
    public List<MovieDTO> pesquisarPorGenre(Long idGenre) {
        return repository.findAllByIdGenre(idGenre).stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    private MovieDTO entityToDTO(Movie entity) {
        return MovieDTO.builder().nomeMovie(entity.getNomeMovie()).urlStream(entity.getUrlStream()).id(entity.getId()).idGenre(entity.getIdGenre()).build();
    }

}
