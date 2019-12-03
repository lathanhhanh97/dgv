package com.thanhhanh.beta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ResponseFormatFilm {
    @JsonProperty("format_film")
    private String formatFilm;
    @JsonProperty("format_data")
    private ArrayList<ResponseScheduleTime> formatData;

    public ResponseFormatFilm() {
    }

    public ResponseFormatFilm(String formatFilm, ArrayList<ResponseScheduleTime> formatData) {
        this.formatFilm = formatFilm;
        this.formatData = formatData;
    }

    public String getFormatFilm() {
        return formatFilm;
    }

    public void setFormatFilm(String formatFilm) {
        this.formatFilm = formatFilm;
    }

    public ArrayList<ResponseScheduleTime> getFormatData() {
        return formatData;
    }

    public void setFormatData(ArrayList<ResponseScheduleTime> formatData) {
        this.formatData = formatData;
    }
}
