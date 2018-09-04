package com.przestal.helper;

import javax.servlet.http.*;

import com.przestal.dao.*;
import com.przestal.bean.SumValueBean;

public class SetSumSession extends HttpServlet {

	
	public void showSumValueDB(HttpServletRequest req, String email) {
		
		AddValueDao valueDao = new AddValueDao();
		
		String sum = valueDao.getSumOfColumnValues(email);

        HttpSession session = req.getSession();
        session.setAttribute("sum",sum);
		
	}
	
	
}
