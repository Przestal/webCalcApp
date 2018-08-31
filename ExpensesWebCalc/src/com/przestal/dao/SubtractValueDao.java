package com.przestal.dao;

import com.przestal.bean.SubtractValueBean;
import com.przestal.db.DBConnection;

import java.sql.*;

public class SubtractValueDao {


    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Double result = null;


    public void subtractValueToDB(SubtractValueBean subtractValueBean) {


        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();

            preparedStatement = connection.prepareStatement("INSERT INTO costsvalue(food) VALUES (?)");
            preparedStatement.setString(1, subtractValueBean.getValue());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
