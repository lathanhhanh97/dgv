package com.thanhhanh.beta.model;

import java.util.List;

public class ResponseFormatFilm {
    private String formatFilm;
    private List<ResponseScheduleTime> data;

    public ResponseFormatFilm() {
    }

    public ResponseFormatFilm(String formatFilm, List<ResponseScheduleTime> data) {
        this.formatFilm = formatFilm;
        this.data = data;
    }

    public String getFormatFilm() {
        return formatFilm;
    }

    public void setFormatFilm(String formatFilm) {
        this.formatFilm = formatFilm;
    }

    public List<ResponseScheduleTime> getData() {
        return data;
    }

    public void setData(List<ResponseScheduleTime> data) {
        this.data = data;
    }
}
