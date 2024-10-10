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

    public static void insertBook(Connection connection, String title, String author, double price) {
        String insertBookQuery = "INSERT INTO Book (title, author, price) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertBookQuery)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setDouble(3, price);
            preparedStatement.executeUpdate();
            System.out.println("Book inserted successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void updateBook(Connection connection, int id, double price) {
        String updateQuery = "UPDATE Book SET price = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, price);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            System.out.println("Book updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void deleteBook(Connection connection, int id) {
        String deleteBookQuery = "DELETE FROM Book WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteBookQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Book updated successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}