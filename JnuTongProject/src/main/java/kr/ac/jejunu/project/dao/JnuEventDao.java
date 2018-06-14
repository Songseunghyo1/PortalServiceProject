package kr.ac.jejunu.project.dao;

import kr.ac.jejunu.project.connection.ConnectionMaker;
import kr.ac.jejunu.project.connection.JnuTongConnectionMaker;
import kr.ac.jejunu.project.event.JnuEvent;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

@Component
public class JnuEventDao {
    private ConnectionMaker connectionMaker = new JnuTongConnectionMaker();

    public LinkedList<JnuEvent> get() throws SQLException, ClassNotFoundException {
        Connection connection = connectionMaker.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM jnuevent");

        LinkedList<JnuEvent> jnuEvents = new LinkedList<>();
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            JnuEvent jnuEvent = new JnuEvent();
            jnuEvent.setNum(resultSet.getInt("id"));
            jnuEvent.setDate(resultSet.getString("day"));
            jnuEvent.setName(resultSet.getString("event"));
            jnuEvents.add(jnuEvent);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return jnuEvents;
    }
}
