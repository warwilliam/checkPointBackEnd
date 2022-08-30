package com.william.movies.service;

import com.william.movies.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO salvar(MovieDTO dto);

    List<MovieDTO> pesquisarPorGenre(Long id);

}
