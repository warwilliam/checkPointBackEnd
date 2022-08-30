package com.william.catalog.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class GenreDTO  implements Serializable {

    private Long id;
    private String nome;

}
