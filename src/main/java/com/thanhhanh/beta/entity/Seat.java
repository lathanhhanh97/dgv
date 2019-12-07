package com.thanhhanh.beta.entity;

import com.thanhhanh.beta.model.ResponseSeatEmpty;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "ResponseSeatEmpty",
                classes = @ConstructorResult(
                        targetClass = ResponseSeatEmpty.class,
                        columns = {
                                @ColumnResult(name = "seat_id"),
                                @ColumnResult(name = "seat_type"),
                                @ColumnResult(name = "seat_row"),
                                @ColumnResult(name = "seat_number"),
                                @ColumnResult(name = "seat_status", type = String.class)
                        }
                )
        )
})
//@NamedNativeQuery(name = "getSeatEmpty", resultSetMapping = "ResponseSeatEmpty", query = "SELECT seats.seat_id, seats.seat_type,booking.seat_status FROM seats, room, schedule, booking WHERE schedule.schedule_id = ?1 AND seats.room_id = room.room_id AND room.room_id = schedule.room_id AND schedule.schedule_id = booking.schedule_id AND seats.seat_id NOT IN (SELECT seat_id FROM booking) ORDER BY seats.seat_id, seats.seat_type")
@NamedNativeQuery(name = "getSeatEmpty", resultSetMapping = "ResponseSeatEmpty", query = "SELECT `seats`.`seat_id`, `seats`.`seat_type`,`seats`.`seat_row`, `seats`.`seat_number`, `booking`.`seat_status` FROM `schedule`, `seats` LEFT JOIN `booking` ON `seats`.`seat_id` = `booking`.`seat_id` WHERE `schedule`.`room_id` = `seats`.`room_id` AND `schedule`.`schedule_id` = ?1 ORDER BY `seats`.`seat_id`\n")


@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seat_id")
    private int seatId;

    @Column(name = "seat_type")
    private int seatType;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "seat_row")
    private String seatRow;

    @Column(name = "seat_number")
    private int seatNumber;

    public Seat() {
    }

    public Seat(int seatType, int roomId, String seatRow, int seatNumber) {
        this.seatType = seatType;
        this.roomId = roomId;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getSeatType() {
        return seatType;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
