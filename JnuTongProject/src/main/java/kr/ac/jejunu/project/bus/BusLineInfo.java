package kr.ac.jejunu.project.bus;

import lombok.Data;

@Data
public class BusLineInfo {
    private String lineId;
    private String lineNo;
    private String detailLineNo;
    private String description;
}
