package kr.ac.jejunu.project.dao;

import kr.ac.jejunu.project.ConnectionMaker;
import kr.ac.jejunu.project.JnuTongConnectionMaker;
import kr.ac.jejunu.project.bus.JnuBusSchedule;
import org.junit.Before;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class JnuBusScheduleDao {
    private ConnectionMaker connectionMaker;

    @Before
    public void setup() {
        connectionMaker = new JnuTongConnectionMaker();
    }

    public LinkedList<JnuBusSchedule> get() throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM jnu_bus_schedule");

        LinkedList<JnuBusSchedule> jnuBusSchedules = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            JnuBusSchedule jnuBusSchedule = new JnuBusSchedule();
            jnuBusSchedule.setId(resultSet.getInt("id"));
            jnuBusSchedule.setDepartureTime(resultSet.getTime("departure_time"));
            jnuBusSchedule.setCourse(resultSet.getString("course"));
            jnuBusSchedule.setGoOceanScience(resultSet.getInt("go_ocean_science"));
            jnuBusSchedules.add(jnuBusSchedule);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return jnuBusSchedules;
    }
}
