package com.mehertasnim.Movie.Theater.API.repository;

import com.mehertasnim.Movie.Theater.API.model.Show;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{
}
