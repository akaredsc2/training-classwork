package org.vitaly.week09.lesson25.savepoint;

import java.sql.*;

/**
 * Created by vitaly on 29.03.17.
 */
public class Main {    public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/car_rental_test?useSSL=false", "vitaly", "sh2r2p0v");

    connection.setAutoCommit(false);
    Statement statement1 = connection.createStatement();
    Statement statement2 = connection.createStatement();
    Savepoint savepoint = null;
    try {
        statement1.execute("select * from users");

        savepoint = connection.setSavepoint();

        statement1.execute("select * from car");

        connection.commit();
    } catch (Exception e) {
        connection.rollback(savepoint);
    } finally {
        statement1.close();
        statement2.close();
        connection.setAutoCommit(true);
    }
}
}
