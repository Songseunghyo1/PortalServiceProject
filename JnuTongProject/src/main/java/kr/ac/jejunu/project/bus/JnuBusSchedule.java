package kr.ac.jejunu.project.bus;

import lombok.Data;

import java.sql.Time;

@Data
public class JnuBusSchedule {
    private int id;
    private Time departureTime;
    private String course;
    private int goOceanScience;
}
