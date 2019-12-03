package com.thanhhanh.beta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseScheduleTime {
    @JsonProperty("schedule_id")
    private int scheduleId;
    @JsonProperty("schedule_start")
    private String start;

    public ResponseScheduleTime() {
    }

    public ResponseScheduleTime(int scheduleId, String scheduleStart) {
        this.scheduleId = scheduleId;
        this.start = scheduleStart;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleStart() {
        return start;
    }

    public void setScheduleStart(String scheduleStart) {
        this.start = scheduleStart;
    }
}
