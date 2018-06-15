package kr.ac.jejunu.project.bus;

import lombok.Data;

import java.sql.Time;

@Data
public class BusSchedule {
    private int scheduleNo;
    private String lineId;
    private Time departureTime;
    private String day;

    @Override
    public String toString() {
        return "BusSchedule{" +
                "scheduleNo=" + scheduleNo +
                ", lineId='" + lineId + '\'' +
                ", departureTime=" + departureTime +
                ", day='" + day + '\'' +
                '}';
    }
}
