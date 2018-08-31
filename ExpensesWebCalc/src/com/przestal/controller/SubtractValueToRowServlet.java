package com.przestal.controller;

import com.przestal.bean.SubtractValueBean;
import com.przestal.bean.SumValueBean;
import com.przestal.dao.AddValueDao;
import com.przestal.dao.SubtractValueDao;
import com.przestal.helper.SetSumSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SubtractValueToRowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String value = request.getParameter("value");

        SubtractValueBean subtractValueBean = new SubtractValueBean();
        subtractValueBean.setValue(value);

        SubtractValueDao subtractValueDao = new SubtractValueDao();
        AddValueDao valueDao = new AddValueDao();
        subtractValueDao.subtractValueToDB(subtractValueBean);
        
        SetSumSession sumSession = new SetSumSession();
        sumSession.showSumValueDB(request);
        request.getRequestDispatcher("/result3.jsp").forward(request,response);

    }

}
