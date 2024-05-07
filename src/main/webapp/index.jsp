<%@ page import="com.nicode.ibsservlet2.logic.Model" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<h1><%= "Home page for work with users" %>
</h1>
Enter user ID (0 - for all users list)
<br/>
Available: <%
    Model model = Model.getInstance();
    out.print(String.valueOf(model.getFromList().size()));
%>
<form method="get" action="get">
    <label>ID:
        <input type="text" name="id"><br/>
    </label>
    <button type = "submit">Search</button>
</form>

<a href="addUser.html">Create a new user</a><br/><br/><br/>
<a href="hello-servlet">А тут Hello Servlet</a>
</body>
</html>