package com.thanhhanh.beta.controller;

import com.thanhhanh.beta.service.MovieSevice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Api movie")
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieSevice movieSevice;

    @ApiOperation(value = "Lấy danh sách các bộ phim")
    @GetMapping("")
    public ResponseEntity<?> getAllMovies(){
        return ResponseEntity.ok(movieSevice.getAllMovie());
    }

    @ApiOperation(value = "Lấy danh sách phim đang chiếu")
    @GetMapping("/now")
    public ResponseEntity<?> getMoviesNow(){
        return ResponseEntity.ok(movieSevice.getMoviesNow());
    }

    @ApiOperation(value = "Lấy danh sách phim sắp chiếu")
    @GetMapping("/future")
    public ResponseEntity<?> getMoviesFuture(){
        return ResponseEntity.ok(movieSevice.getMoviesFuture());
    }
}
