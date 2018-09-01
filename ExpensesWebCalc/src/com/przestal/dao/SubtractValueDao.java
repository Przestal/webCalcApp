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


    public void subtractValueToDB(SubtractValueBean subtractValueBean, String email) {


        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();

            preparedStatement = connection.prepareStatement("INSERT INTO "+email+"_costs(costs) VALUES (?)");
            preparedStatement.setDouble(1, subtractValueBean.getValue());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
