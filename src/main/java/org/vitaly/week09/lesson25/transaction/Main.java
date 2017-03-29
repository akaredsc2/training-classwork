package org.vitaly.week09.lesson25.transaction;

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

        connection.setAutoCommit(false);
        Statement statement1 = connection.createStatement();
        Statement statement2 = connection.createStatement();

        try {
            statement1.execute("select * from users;");
            statement1.execute("select * from car;");
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            statement1.close();
            statement2.close();
            connection.setAutoCommit(true);
        }
    }
}
