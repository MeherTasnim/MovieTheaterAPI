package com.mehertasnim.Movie.Theater.API.repository;

import com.mehertasnim.Movie.Theater.API.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

    List<Show> findByGenre(String genre);
}
