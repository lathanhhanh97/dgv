package com.thanhhanh.beta.request;

import javax.validation.constraints.NotNull;

public class BookRequest {
    @NotNull(message = "Thiếu id suất chiếu")
    private int scheduleId;
    @NotNull(message = "Thiếu id seat")
    private int seatId;
    @NotNull(message = "Thiếu giá ghế")
    private double price;
    @NotNull(message = "Thiếu trạng thái ghế")
    private int seatStatus;

    public BookRequest() {
    }

    public BookRequest(int scheduleId, int seatId, double price, int seatStatus) {
        this.scheduleId = scheduleId;
        this.seatId = seatId;
        this.price = price;
        this.seatStatus = seatStatus;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(int seatStatus) {
        this.seatStatus = seatStatus;
    }
}
