package com.thanhhanh.beta.repository;

import com.thanhhanh.beta.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    // get phim đang chiếu
    // SELECT * FROM `movies` WHERE `movie_release` = CURRENT_DATE OR `movie_release` < CURRENT_DATE
    @Query(value = "SELECT * FROM `movies` WHERE `movie_release` = CURRENT_DATE OR `movie_release` < CURRENT_DATE", nativeQuery = true)
    List<Movie> getMoviesNow();
    // get phim sắp chiếu
    // SELECT * FROM `movies` WHERE `movie_release` > CURRENT_DATE
    @Query(value = "SELECT * FROM `movies` WHERE `movie_release` > CURRENT_DATE", nativeQuery = true)
    List<Movie> getMoviesFuture();
}
