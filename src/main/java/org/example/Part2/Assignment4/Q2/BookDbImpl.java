package org.example.Part2.Assignment4.Q2;

import org.example.util.Constant;

import java.rmi.RemoteException;
import java.sql.*;

public class BookDbImpl implements BookDb {

    protected BookDbImpl() throws RemoteException {
        super();
    }

    @Override
    public String getBookById(int id) throws RemoteException {
        try {

            //Class.forName(Constant.MYSQL_DRIVER);
            Connection connection = DriverManager.getConnection(Constant.BOOK_DB_URL, Constant.DB_USERNAME, Constant.DB_PASSWORD);

            System.out.println("Connected DB...");
            String query = "SELECT * FROM Book WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery(query);

            return (rs.getInt("id") + rs.getString("title") + rs.getString("author") + rs.getShort("id"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "EMPTY";
    }

}