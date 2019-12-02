package com.thanhhanh.beta.model;

public class ResponseCinema {
    private int cinemaId;
    private String cinemaName;
    private String cinemaAddress;

    public ResponseCinema() {
    }

    public ResponseCinema(int cinemaId, String cinemaName, String cinemaAddress) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
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
}
