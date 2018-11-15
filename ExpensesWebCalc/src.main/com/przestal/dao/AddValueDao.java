package com.przestal.dao;

import com.przestal.bean.AddValueBean;
import com.przestal.bean.LoginBean;
import com.przestal.bean.SumValueBean;
import com.przestal.db.DBConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.DecimalFormat;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;


public class AddValueDao extends HttpServlet{
	
    Connection connection = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Double result = null;
    
    public void addValueToTableDB(AddValueBean addValueBean, String email) {

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO "+email+"_costs(name) VALUES (?);");
            preparedStatement.setDouble(1, addValueBean.getValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getSumOfColumnValues(String email) {

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT SUM (CAST (costs AS FLOAT (2))) FROM "+email+"_costs;");
            if (resultSet.next()) {
                result = resultSet.getDouble(1);
            }/*else {
            	statement.execute("INSERT INTO "+email+"_sum (food) VALUES (0)");
                
            }*/
            statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM "+email+"_sum;");
                if (resultSet.next()) {
                    statement.executeUpdate("UPDATE "+email+"_sum SET food =  " + result + ";");
                } else {
                    statement.execute("INSERT INTO "+email+"_sum (food) VALUES (0)");
                    statement.executeUpdate("UPDATE "+email+"_sum SET food =  " + result + ";");
                    statement.close();
                }
                
      
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        
        return String.format("%.2f",result);
    }
}
