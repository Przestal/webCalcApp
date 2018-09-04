package com.przestal.dao;

import com.przestal.bean.LoginBean;
import com.przestal.db.DBConnection;

import java.sql.*;

public class LoginDao {


    public String authenticateUser(LoginBean loginBean) {

        String email = loginBean.getEmail();
        String password = loginBean.getPassword();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String emailDB = "" ;
        String passwordDB = "";

        try{
        connection = DBConnection.createConnection();
        statement =  connection.createStatement();
        resultSet = statement.executeQuery("SELECT * FROM users ");

        while (resultSet.next()){
            emailDB = resultSet.getString("email");
            passwordDB = resultSet.getString("password");

            if (email.equals(emailDB) && password.equals(passwordDB)){
                return "SUCCESS";
            }
        }
        }catch (SQLException e){
        e.printStackTrace();
        }

        return "invalid email credentials";
    }
}
