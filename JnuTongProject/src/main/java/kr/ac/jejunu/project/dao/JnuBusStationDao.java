package kr.ac.jejunu.project.dao;

import kr.ac.jejunu.project.connection.ConnectionMaker;
import kr.ac.jejunu.project.connection.JnuTongConnectionMaker;
import kr.ac.jejunu.project.bus.JnuBusStation;
import org.junit.Before;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.LinkedList;

@Component
public class JnuBusStationDao {
    private ConnectionMaker connectionMaker = new JnuTongConnectionMaker();

    public LinkedList<JnuBusStation> get() throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM jnu_bus_station");
        LinkedList<JnuBusStation> jnuBusStations = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            JnuBusStation jnuBusStation = new JnuBusStation();
            jnuBusStation.setId(resultSet.getInt("id"));
            jnuBusStation.setName(resultSet.getString("name"));
            jnuBusStations.add(jnuBusStation);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return jnuBusStations;
    }
}
