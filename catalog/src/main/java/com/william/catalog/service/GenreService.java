package com.william.catalog.service;

import com.william.catalog.dto.GenreDTO;
import com.william.catalog.dto.MovieDTO;

import java.util.List;

public interface GenreService {

    GenreDTO salvar(GenreDTO dto);

    GenreDTO pesquisarPorId(Long id);

    GenreDTO pesquisarPorNome(String nome);

    List<MovieDTO> pesquisarMovies(String nomeGenre);
}
