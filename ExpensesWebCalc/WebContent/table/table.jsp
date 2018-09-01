<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.przestal.helper.*" %>
<%@ page import="com.przestal.dao.*" %>


<html>
<body>
            <% AddColumnDao columnDao = new AddColumnDao();
            columnDao.getColumns(response);	%>
</body>
</html>