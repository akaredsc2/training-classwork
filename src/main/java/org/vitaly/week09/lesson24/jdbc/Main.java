package org.vitaly.week09.lesson24.jdbc;

import java.sql.*;

/**
 * Created by vitaly on 27.03.17.
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car_rental_test?useSSL=false", "vitaly", "sh2r2p0v");
//        PreparedStatement statement = connection.prepareStatement(
//                "insert into location(state, city, street, building) values ('1', '2', '3', '4')");
//        statement.executeUpdate();

        PreparedStatement statement1 = connection.prepareStatement("select * from location where city = ?");
        statement1.setString(1, "2");
        statement1.executeQuery();
        ResultSet resultSet = statement1.getResultSet();

        while (resultSet.next()) {
            System.out.println(resultSet.getLong("location_id") + " " + resultSet.getString("city"));
        }
//        statement.close();
        statement1.close();
        connection.close();
    }
}
