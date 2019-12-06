package com.thanhhanh.beta.model;

import javax.persistence.Column;
import javax.persistence.Entity;

public class ResponseSeatEmpty {
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "seat_type")
    private String seatType;
    @Column(name = "seat_status")
    private String seatStatus;

    public ResponseSeatEmpty() {
    }

    public ResponseSeatEmpty(int seatId, String seatType, String seatStatus) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
