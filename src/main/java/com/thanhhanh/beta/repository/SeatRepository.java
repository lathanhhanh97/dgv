package com.thanhhanh.beta.repository;

import com.thanhhanh.beta.entity.Seat;
import com.thanhhanh.beta.model.ResponseSeat;
import com.thanhhanh.beta.model.ResponseSeatEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //lấy ghế trống theo id film và id schedule
    @Query(name = "getSeatEmpty", nativeQuery = true)
    List<ResponseSeat> getSeatEmptyBySchedule(Integer schedule_id);
}
