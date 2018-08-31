package com.przestal.controller;

import com.przestal.bean.AddValueBean;
import com.przestal.bean.SumValueBean;
import com.przestal.dao.AddValueDao;

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

        AddValueBean addVB = new AddValueBean();
        addVB.setValue(value);

        AddValueDao valueDao = new AddValueDao();
        valueDao.addValueToTableDB(addVB);

        SumValueBean sumValueBean = new SumValueBean();
        String sum = valueDao.getSumOfColumnValues();

        HttpSession session = req.getSession();
        session.setAttribute("sum",sum);

        req.getRequestDispatcher("/result3.jsp").forward(req,resp);

    }
}
