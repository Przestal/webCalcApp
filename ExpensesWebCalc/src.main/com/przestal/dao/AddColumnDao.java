package com.przestal.dao;

import com.przestal.bean.AddColumnBean;
import com.przestal.db.DBConnection;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.*;
import javax.xml.ws.RespectBinding;

public class AddColumnDao extends HttpServlet{

	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	Statement stmt = null;
	String result = null;
	
	
	public void addColumnToDB(AddColumnBean columnBean, String email, HttpSession session) {
		
	try {
		conn = DBConnection.createConnection();
        stmt = conn.createStatement();
        ptmt = conn.prepareStatement("INSERT INTO "+email+"_columns (columnsname) VALUES (?)");
        ptmt.setString(1, columnBean.getColumnName());
        ptmt.executeUpdate();
       
        addColumnInCostsAndSum(session,columnBean);
        
	 }catch(SQLException e) {
		e.printStackTrace();
	 }
	}

	public String getColumns(HttpServletResponse resp, String email) {
		
		try {
			PrintWriter out = resp.getWriter();
			conn = DBConnection.createConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM "+email+"_columns");
			
        while(rs.next()) {
        	result = rs.getString(2);
        	
        	 out.println("<th>"+result+"</th>");
        	
        }
        
        
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void addColumnInCostsAndSum(HttpSession session, AddColumnBean columnBean) {
		
		
		try {
			
		conn = DBConnection.createConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate("ALTER TABLE "+session.getAttribute("email")+"_costs ADD COLUMN "+
		columnBean.getColumnName()+" float8;");
		stmt.executeUpdate("ALTER TABLE "+session.getAttribute("email")+"_sum ADD COLUMN "+
		columnBean.getColumnName()+" float8;");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
