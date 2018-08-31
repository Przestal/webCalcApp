package com.przestal.dao;

import com.przestal.bean.CreateTableDBBean;
import com.przestal.db.DBConnection;

import java.sql.*;

public class CreateTableDBDao {

    public String createTable(CreateTableDBBean ctb) {

        String name = ctb.getName();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnection.createConnection();
            pstmt = conn.prepareStatement("CREATE TABLE " + name + " (idtable INT PRIMARY KEY NOT NULL, value INTEGER, sum INTEGER );");
            rs = pstmt.executeQuery();
            rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "CREATE";
    }
}
