package com.thanhhanh.beta.repository;

import com.thanhhanh.beta.entity.Schedule;
import com.thanhhanh.beta.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(nativeQuery = true, name = "getResponseCinema")
    List<ResponseCinema> getScheduleCinema(Integer movie_id, String schedule_date);

    @Query(name = "getScheduleFormat", nativeQuery = true)
    String getFormat(Integer movie_id, String schedule_date, Integer cinema_id);

    @Query(name = "getScheduleTimeByFilm", nativeQuery = true)
    List<ResponseScheduleTime>  getScheduleTimeByFilm(Integer movie_id, String schedule_date, Integer cinema_id);

    @Query(name = "showSchedule", nativeQuery = true)
    List<ResponseScheduleCinema>  getSchedule(Integer movie_id, String schedule_date);
}