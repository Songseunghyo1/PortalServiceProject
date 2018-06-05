package kr.ac.jejunu.project.bus;

import lombok.Data;

import java.sql.Time;

@Data
public class BusSchedule {
    private int scheduleNo;
    private String lineId;
    private Time departureTime;

}
