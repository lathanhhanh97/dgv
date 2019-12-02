package com.thanhhanh.beta.service;

import com.thanhhanh.beta.entity.Cinema;
import com.thanhhanh.beta.model.ResponseData;
import com.thanhhanh.beta.model.ResponseFormatFilm;
import com.thanhhanh.beta.model.ResponseScheduleCinema;
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

    public ResponseData<Cinema> getCinemaByScheduleId(Integer schedule_id){
        return new ResponseData(HttpStatus.OK, "success", scheduleRepository.getCinemasByIdSchedule(schedule_id));
    }

    public ResponseData<ResponseScheduleCinema> getScheduleCinema(Integer schedule_id, String schedule_date){
        if(scheduleRepository.getScheduleCinema(schedule_id, schedule_date) == null){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            List<ResponseScheduleCinema> data = new ArrayList<>();
            for(int i=0; i< scheduleRepository.getScheduleCinema(schedule_id, schedule_date).size(); i++){
                ResponseScheduleCinema rp = new ResponseScheduleCinema();
                rp.setCinemaId(scheduleRepository.getScheduleCinema(schedule_id, schedule_date).get(i).getCinemaId());
                rp.setCinemaName(scheduleRepository.getScheduleCinema(schedule_id, schedule_date).get(i).getCinemaName());
                rp.setCinemaAddress(scheduleRepository.getScheduleCinema(schedule_id, schedule_date).get(i).getCinemaAddress());
                List<ResponseFormatFilm> listff = new ArrayList<>();
                ResponseFormatFilm ff = new ResponseFormatFilm();
                ff.setFormatFilm(scheduleRepository.getFormat(schedule_id, schedule_date, scheduleRepository.getScheduleCinema(schedule_id, schedule_date).get(i).getCinemaId()));
                ff.setData(scheduleRepository.getScheduleTimeByFilm(schedule_id, schedule_date, scheduleRepository.getScheduleCinema(schedule_id, schedule_date).get(i).getCinemaId()));
                listff.add(ff);
                rp.setData(listff);
                data.add(rp);
            }
            return new ResponseData(HttpStatus.OK, "success", data);
        }
    }
}
