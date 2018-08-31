package com.przestal.controller;

import com.przestal.bean.CreateTableDBBean;
import com.przestal.dao.CreateTableDBDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateTableDBServlet extends HttpServlet{


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");

        CreateTableDBBean ctb = new CreateTableDBBean();
        ctb.setName(name);

        CreateTableDBDao ctd = new CreateTableDBDao();
        String createTable = ctd.createTable(ctb);

        if (createTable.equals("CREATE")){

            req.getRequestDispatcher("/createTableSuccess.jsp").forward(req,resp);

        }else {
            req.getRequestDispatcher("/home.jsp").forward(req,resp);
        }

    }
}
