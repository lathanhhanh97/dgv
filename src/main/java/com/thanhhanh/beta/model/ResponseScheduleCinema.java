package com.thanhhanh.beta.model;

import java.util.List;

public class ResponseScheduleCinema {
    private int cinemaId;
    private String cinemaName;
    private String cinemaAddress;
    private List<ResponseFormatFilm> data;

    public ResponseScheduleCinema() {
    }

    public ResponseScheduleCinema(int cinemaId, String cinemaName, String cinemaAddress, List<ResponseFormatFilm> data) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
        this.data = data;
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

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public List<ResponseFormatFilm> getData() {
        return data;
    }

    public void setData(List<ResponseFormatFilm> data) {
        this.data = data;
    }
}
