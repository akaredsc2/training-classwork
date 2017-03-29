package org.vitaly.week09.lesson25.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by vitaly on 29.03.17.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car_rental_test?useSSL=false", "vitaly", "sh2r2p0v");

        Statement statement = connection.createStatement();
        statement.addBatch("insert into location(state, city, street, building) VALUES ('1', '2', '3', '4')");
        statement.addBatch("insert into location(state, city, street, building) VALUES ('3', '2', '3', '4')");
        statement.addBatch("insert into location(state, city, street, building) VALUES ('4', '2', '3', '4')");
        statement.addBatch("insert into location(state, city, street, building) VALUES ('6', '2', '3', '4')");

        int res[] = statement.executeBatch();

        for (int i : res) {
            System.out.println(i);
        }
    }
}
