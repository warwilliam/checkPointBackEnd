package com.william.movies.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class MovieDTO implements Serializable {

    private Long id;
    private String nomeMovie;
    private String urlStream;
    private Long idGenre;

}
