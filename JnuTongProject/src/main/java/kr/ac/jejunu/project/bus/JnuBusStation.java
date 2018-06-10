package kr.ac.jejunu.project.bus;

import lombok.Data;

@Data
public class JnuBusStation {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "JnuBusStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
