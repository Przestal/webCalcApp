package com.przestal.dao;

import com.przestal.bean.RegisterBean;
import com.przestal.db.DBConnection;

import java.sql.*;

public class RegisterDao {


    public static String checkUserEmailInDB(RegisterBean registerBean) {

        String email = registerBean.getEmail();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String emailDB = "";

        try {
            connection = DBConnection.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users ");

            while (resultSet.next()) {
                emailDB = resultSet.getString("email");

                if (email.equals(emailDB)) {
                    return "EXIST";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "NOT_EXIST";
    }

    public String createUser(RegisterBean registerBean) {

        String email = registerBean.getEmail();
        String password = registerBean.getPassword();


        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String emailDB = "";

        try {
            connection = DBConnection.createConnection();

            if (checkUserEmailInDB(registerBean).equals("NOT_EXIST")) {

                preparedStatement = connection.prepareStatement("INSERT INTO calc.public.users (email, password) VALUES (?,?)");
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }else {
                return "FAILED";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "SUCCESS";
    }

}
