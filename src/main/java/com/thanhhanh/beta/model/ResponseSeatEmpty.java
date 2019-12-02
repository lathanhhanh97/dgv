package com.thanhhanh.beta.model;

import javax.persistence.Column;
import javax.persistence.Entity;

public class ResponseSeatEmpty {
    @Column(name = "seat_id")
    private int seatId;
    @Column(name = "seat_type")
    private String seatType;

    public ResponseSeatEmpty() {
    }

    public ResponseSeatEmpty(int seatId, String seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
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
}
