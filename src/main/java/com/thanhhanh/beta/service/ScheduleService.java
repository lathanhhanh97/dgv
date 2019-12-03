package com.thanhhanh.beta.service;

import com.thanhhanh.beta.entity.Cinema;
import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.model.ResponseFormatFilm;
import com.thanhhanh.beta.model.ResponseScheduleCinema;
import com.thanhhanh.beta.repository.CinemaRepository;
import com.thanhhanh.beta.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    CinemaRepository cinemaRepository;

    public ResponseData<ResponseScheduleCinema> getScheduleCinema(Integer movie_id, String schedule_date){
        if(cinemaRepository.getScheduleCinema(movie_id, schedule_date).size() == 0){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", cinemaRepository.getScheduleCinema(movie_id, schedule_date));
        }else{
            List<ResponseScheduleCinema> data = new ArrayList<ResponseScheduleCinema>();
            for(int i=0; i< scheduleRepository.getScheduleCinema(movie_id, schedule_date).size(); i++){
                ResponseScheduleCinema rp = new ResponseScheduleCinema();

                rp.setCinemaId(scheduleRepository.getScheduleCinema(movie_id, schedule_date).get(i).getCinemaId());
                rp.setCinemaName(scheduleRepository.getScheduleCinema(movie_id, schedule_date).get(i).getCinemaName());
                rp.setCinemaAddress(scheduleRepository.getScheduleCinema(movie_id, schedule_date).get(i).getCinemaAddress());

                List<ResponseFormatFilm> listff = new ArrayList<ResponseFormatFilm>();
                ResponseFormatFilm ff = new ResponseFormatFilm();

                ff.setFormatFilm(scheduleRepository.getFormat(movie_id, schedule_date, scheduleRepository.getScheduleCinema(movie_id, schedule_date).get(i).getCinemaId()));
                ff.setData(scheduleRepository.getScheduleTimeByFilm(movie_id, schedule_date, scheduleRepository.getScheduleCinema(movie_id, schedule_date).get(i).getCinemaId()));

                listff.add(ff);
                rp.setData(listff);

                data.add(rp);
            }
            return new ResponseData(HttpStatus.OK, "success", cinemaRepository.getScheduleCinema(movie_id, schedule_date));
        }
    }
}
