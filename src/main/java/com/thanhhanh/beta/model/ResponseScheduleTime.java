package com.thanhhanh.beta.model;

public class ResponseScheduleTime {
    private int scheduleId;
    private String scheduleStart;

    public ResponseScheduleTime() {
    }

    public ResponseScheduleTime(int scheduleId, String scheduleStart) {
        this.scheduleId = scheduleId;
        this.scheduleStart = scheduleStart;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleStart() {
        return scheduleStart;
    }

    public void setScheduleStart(String scheduleStart) {
        this.scheduleStart = scheduleStart;
    }
}
