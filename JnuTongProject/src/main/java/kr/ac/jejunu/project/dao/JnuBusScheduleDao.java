package kr.ac.jejunu.project.dao;

import kr.ac.jejunu.project.connection.ConnectionMaker;
import kr.ac.jejunu.project.connection.JnuTongConnectionMaker;
import kr.ac.jejunu.project.bus.JnuBusSchedule;
import org.junit.Before;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Component
public class JnuBusScheduleDao {
    private ConnectionMaker connectionMaker = new JnuTongConnectionMaker();

    public LinkedList<JnuBusSchedule> getOrigin() throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM jnu_bus_schedule");

        LinkedList<JnuBusSchedule> jnuBusSchedules = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();
        getFromDatabase(jnuBusSchedules, resultSet);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return jnuBusSchedules;
    }

    public LinkedList<JnuBusSchedule> getACourse() throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM jnu_bus_schedule WHERE course = 'A'");

        LinkedList<JnuBusSchedule> jnuBusSchedules = new LinkedList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        getFromDatabase(jnuBusSchedules, resultSet);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return jnuBusSchedules;
    }

    public LinkedList<JnuBusSchedule> getBCourse() throws SQLException, ClassNotFoundException {

    }

    private void getFromDatabase(LinkedList<JnuBusSchedule> jnuBusSchedules, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            JnuBusSchedule jnuBusSchedule = new JnuBusSchedule();
            jnuBusSchedule.setId(resultSet.getInt("id"));
            jnuBusSchedule.setDepartureTime(resultSet.getTime("departure_time"));
            jnuBusSchedule.setCourse(resultSet.getString("course"));
            jnuBusSchedule.setGoOceanScience(resultSet.getInt("go_ocean_science"));
            jnuBusSchedules.add(jnuBusSchedule);
        }
    }
}
