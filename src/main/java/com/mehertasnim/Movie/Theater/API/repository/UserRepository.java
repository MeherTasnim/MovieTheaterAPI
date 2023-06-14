package com.mehertasnim.Movie.Theater.API.repository;

import com.mehertasnim.Movie.Theater.API.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
