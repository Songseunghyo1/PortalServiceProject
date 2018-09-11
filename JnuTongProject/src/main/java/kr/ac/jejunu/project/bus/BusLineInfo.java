package kr.ac.jejunu.project.bus;

import lombok.Data;

public class BusLineInfo {
    private String lineId;
    private String lineNo;
    private String detailLineNo;
    private String description;

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public String getLineNo() {
        return lineNo;
    }

    public void setLineNo(String lineNo) {
        this.lineNo = lineNo;
    }

    public String getDetailLineNo() {
        return detailLineNo;
    }

    public void setDetailLineNo(String detailLineNo) {
        this.detailLineNo = detailLineNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
