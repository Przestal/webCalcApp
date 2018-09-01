package com.przestal.controller;

import com.przestal.bean.AddValueBean;
import com.przestal.dao.AddValueDao;
import com.przestal.helper.SetSumSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddValueToRowServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String value = req.getParameter("value");
        Double valueD = Double.valueOf(value);
        HttpSession session = req.getSession();
       
        String email = (String) session.getAttribute("email");
        
        
        AddValueBean addVB = new AddValueBean();
        addVB.setValue(valueD);

        AddValueDao valueDao = new AddValueDao();
        valueDao.addValueToTableDB(addVB, email );
        
        SetSumSession sumSession = new SetSumSession();
        sumSession.showSumValueDB(req, email);
        
        req.getRequestDispatcher("/result3.jsp").forward(req,resp);

    }
}
