package com.przestal.dao;

import com.przestal.bean.AddValueBean;
import com.przestal.bean.GetSumValueBean;
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

    public void addValueToTableDB(AddValueBean addValueBean) {

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            preparedStatement = connection.prepareStatement("INSERT INTO costsvalue(food) VALUES (?)");
            preparedStatement.setString(1, addValueBean.getValue());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getSumOfColumnValues() {

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT SUM (CAST (food AS FLOAT (2))) FROM costsvalue;");
            while (resultSet.next()) {
                result = resultSet.getDouble(1);
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM sumvalue");
                if (resultSet.next()) {
                    preparedStatement = connection.prepareStatement("UPDATE sumvalue SET food =  " + result + ";");
                    preparedStatement.executeUpdate();
                } else {
                    statement.execute("INSERT INTO sumvalue VALUES (0)");

                    preparedStatement = connection.prepareStatement("UPDATE sumvalue SET food =  " + result + ";");
                    preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return String.format("%.2f",result);
    }
    
    public void printSumValue(HttpServletResponse resp) {
    	
    	
    	String sum= getSumOfColumnValues();
    	
    	try {
			ServletOutputStream out = resp.getOutputStream();
			out.print(sum);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}
