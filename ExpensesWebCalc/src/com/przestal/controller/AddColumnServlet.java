package com.przestal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.przestal.bean.AddColumnBean;
import com.przestal.dao.AddColumnDao;

public class AddColumnServlet extends HttpServlet{
	
	
	protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		
		String columnName = req.getParameter("columnName");
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		
		AddColumnBean columnBean = new AddColumnBean();
		columnBean.setColumnName(columnName);
		
		AddColumnDao columnDao = new AddColumnDao();
		columnDao.addColumnToDB(columnBean, email);
		
		
		
		resp.sendRedirect("result.jsp");
	}
	
	
}
