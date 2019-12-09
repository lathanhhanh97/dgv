package com.thanhhanh.beta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class ResponseSeat {
    @JsonProperty("row")
    private String seatRow;
    @JsonProperty("seats")
    private ArrayList<ResponseSeatType> data;

    public ResponseSeat() {
    }

    public ResponseSeat(String seatRow, Object data) {
        this.seatRow = seatRow;
        if (data != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                this.data = mapper.readValue((String) data, new TypeReference<ArrayList<ResponseSeatType>>(){});
            } catch (IOException e) {
                this.data = null;
            }
        }
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public ArrayList<ResponseSeatType> getData() {
        return data;
    }

    public void setData(ArrayList<ResponseSeatType> data) {
        this.data = data;
    }
}
