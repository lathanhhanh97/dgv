package com.thanhhanh.beta.service;

import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.model.ResponseScheduleCinema;
import com.thanhhanh.beta.repository.CinemaRepository;
import com.thanhhanh.beta.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    public ResponseData<ResponseScheduleCinema> getScheduleCinema(Integer movie_id, String schedule_date){
        if(scheduleRepository.getSchedule(movie_id, schedule_date).size() == 0){
            return new ResponseData(HttpStatus.NOT_FOUND,"not found schedule", null);
        }else{
            return new ResponseData(HttpStatus.OK,"success", scheduleRepository.getSchedule(movie_id, schedule_date));
        }
    }
}
