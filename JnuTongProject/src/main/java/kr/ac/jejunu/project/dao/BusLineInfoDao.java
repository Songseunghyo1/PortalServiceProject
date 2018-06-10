package kr.ac.jejunu.project.dao;

import kr.ac.jejunu.project.connection.ConnectionMaker;
import kr.ac.jejunu.project.connection.JnuTongConnectionMaker;
import kr.ac.jejunu.project.bus.BusLineInfo;
import org.junit.Before;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Component
public class BusLineInfoDao {
    private ConnectionMaker connectionMaker;

    @Before
    public void setup() {
        connectionMaker = new JnuTongConnectionMaker();
    }

    public LinkedList<BusLineInfo> get() throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM bus_line_info");

        LinkedList<BusLineInfo> busLineInfos = new LinkedList<>();

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            BusLineInfo busLineInfo = new BusLineInfo();
            busLineInfo.setLineId(resultSet.getString("line_id"));
            busLineInfo.setLineNo(resultSet.getString("line_no"));
            busLineInfo.setDetailLineNo(resultSet.getString("detail_line_no"));
            busLineInfo.setDescription(resultSet.getString("description"));
            busLineInfos.add(busLineInfo);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return busLineInfos;
    }
}
