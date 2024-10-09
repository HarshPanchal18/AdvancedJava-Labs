package org.example.Part2.Assignment2;

import java.sql.*;

public class BookManagement {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/book_db";
        String user = "root";
        String password = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, user, password);
            createBookTable(connection);

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void createBookTable(Connection connection) {
        try {
            Statement statement = connection.createStatement();

            String createBookQuery = "CREATE TABLE IF NOT EXISTS Book (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "title VARCHAR(255), " +
                    "author VARCHAR(255), " +
                    "price DECIMAL(10, 2))";

            statement.execute(createBookQuery);
            System.out.println("Book Table created");

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}