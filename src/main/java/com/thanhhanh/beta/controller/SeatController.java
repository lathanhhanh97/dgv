package com.thanhhanh.beta.controller;

import com.thanhhanh.beta.service.SeatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "Api seat")
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatService seatService;

    @ApiOperation(value = "Lấy ghế trống theo suất chiếu")
    @GetMapping("/{schedule_id}/seat-empty")
    public ResponseEntity<?> getSeatEmpty(@PathVariable Integer schedule_id){
        return ResponseEntity.ok(seatService.getSeatEmpty(schedule_id));
    }
}
