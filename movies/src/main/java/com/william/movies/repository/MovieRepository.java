package com.william.movies.repository;

import com.william.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long> {


    List<Movie> findAllByIdGenre(long id);
}
