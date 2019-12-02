package com.thanhhanh.beta.repository;

import com.thanhhanh.beta.entity.Cinema;
import com.thanhhanh.beta.entity.Schedule;
import com.thanhhanh.beta.model.ResponseFormat;
import com.thanhhanh.beta.model.ResponseFormatFilm;
import com.thanhhanh.beta.model.ResponseScheduleTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query(value = "SELECT `cinemas`.* FROM `cinemas`,`schedule`, `room` WHERE `schedule`.`room_id` = `room`.`room_id` AND `room`.`cinema_id`  = `cinemas`.`cinema_id` AND `schedule`.`schedule_id` = ?1", nativeQuery = true)
    Cinema getCinemasByIdSchedule(Integer schedule_id);

    @Query(nativeQuery = true, value = "SELECT `cinemas`.* FROM `cinemas`, `schedule`, `room` WHERE `schedule`.`room_id` = `room`.`room_id` AND `room`.`cinema_id` = `cinemas`.`cinema_id` AND `schedule`.`movie_id` = ?1 AND `schedule`.`schedule_date` = ?2")
    List<Cinema> getScheduleCinema(Integer schedule_id, String schedule_date);

    @Query(name = "getScheduleFormat", nativeQuery = true)
    String getFormat(Integer schedule_id, String schedule_date, Integer cinema_id);

    @Query(name = "getScheduleTimeByFilm", nativeQuery = true)
    List<ResponseScheduleTime>  getScheduleTimeByFilm(Integer schedule_id, String schedule_date, Integer cinema_id);
}