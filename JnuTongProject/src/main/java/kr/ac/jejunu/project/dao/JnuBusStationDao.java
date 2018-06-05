package kr.ac.jejunu.project.dao;

import kr.ac.jejunu.project.ConnectionMaker;
import kr.ac.jejunu.project.JnuTongConnectionMaker;
import kr.ac.jejunu.project.bus.JnuBusStation;
import org.junit.Before;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

public class JnuBusStationDao {
    private ConnectionMaker connectionMaker;

    @Before
    public void setup() {
        connectionMaker = new JnuTongConnectionMaker();
    }

    public LinkedList<JnuBusStation> get() throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM jnu_bus_station");
    }
}
