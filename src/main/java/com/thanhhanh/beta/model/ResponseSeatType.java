package com.thanhhanh.beta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseSeatType {
    @JsonProperty("seat_id")
    private Integer seatId;
    @JsonProperty("seat_type")
    private String seatType;
    @JsonProperty("number")
    private Integer seatNumber;
    @JsonProperty("seat_status")
    private Integer seatStatus;

    public ResponseSeatType() {
    }

    public ResponseSeatType(Integer seatId, String seatType, Integer seatNumber, Integer seatStatus) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(Integer seatStatus) {
        this.seatStatus = seatStatus;
    }
}
