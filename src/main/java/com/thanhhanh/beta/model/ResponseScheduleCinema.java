package com.thanhhanh.beta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class ResponseScheduleCinema {
    @JsonProperty("cinema_id")
    private int cinemaId;
    @JsonProperty("cinema_name")
    private String cinemaName;
    @JsonProperty("cinema_data")
    private ArrayList<ResponseScheduleTime> cinemaData;

    public ResponseScheduleCinema() {
    }

    public ResponseScheduleCinema(int cinemaId, String cinemaName, Object cinemaData) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        if (cinemaData != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.cinemaData = mapper.readValue((String) cinemaData, new TypeReference<ArrayList<ResponseScheduleTime>>(){});
            } catch (IOException e) {
                this.cinemaData = null;
            }
        }
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public ArrayList<ResponseScheduleTime> getCinemaData() {
        return cinemaData;
    }

    public void setCinemaData(ArrayList<ResponseScheduleTime> cinemaData) {
        this.cinemaData = cinemaData;
    }
}
