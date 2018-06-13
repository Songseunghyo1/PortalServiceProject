package kr.ac.jejunu.project.dao;

import kr.ac.jejunu.project.bus.BusSchedule;
import kr.ac.jejunu.project.connection.ConnectionMaker;
import kr.ac.jejunu.project.connection.JnuTongConnectionMaker;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Component
public class BusScheduleDao {
    private ConnectionMaker connectionMaker = new JnuTongConnectionMaker();

    public LinkedList<BusSchedule> getOrigin() throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM bus_schedule");

        LinkedList<BusSchedule> busSchedules = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();
        getFromDatabase(busSchedules, resultSet);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return busSchedules;
    }

    public LinkedList<BusSchedule> getEveryday() throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM bus_schedule WHERE weekday_holiday = 'everyday'");

        LinkedList<BusSchedule> busSchedules = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();
        getFromDatabase(busSchedules, resultSet);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return busSchedules;
    }

    public LinkedList<BusSchedule> getWeekday() throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM bus_schedule WHERE weekday_holiday = 'weekday'");

        LinkedList<BusSchedule> busSchedules = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();
        getFromDatabase(busSchedules, resultSet);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return busSchedules;
    }

    public LinkedList<BusSchedule> getHoliday() throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM bus_schedule WHERE weekday_holiday = 'holiday'");
        LinkedList<BusSchedule> busSchedules = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();
        getFromDatabase(busSchedules, resultSet);

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return busSchedules;
    }

    private void getFromDatabase(LinkedList<BusSchedule> busSchedules, ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            BusSchedule busSchedule = new BusSchedule();
            busSchedule.setScheduleNo(resultSet.getInt("schedule_no"));
            busSchedule.setLineId(resultSet.getString("line_id"));
            busSchedule.setDepartureTime(resultSet.getTime("departure_time"));
            busSchedule.setDay(resultSet.getString("weekday_holiday"));
            busSchedules.add(busSchedule);
        }
    }


}
