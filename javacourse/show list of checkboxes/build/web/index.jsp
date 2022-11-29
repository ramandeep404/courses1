<%-- 
    Document   : index
    Created on : 8 Jun, 2021, 5:09:05 PM
    Author     : raman
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="shownames" method="post">
            Names : <br><br>
        <%
            PrintWriter out1=response.getWriter();
               try {
		Statement stmt;
		ResultSet rs;


		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://127.0.0.1:3306/abcdef";
		Connection con =DriverManager.getConnection(url,"root", "");
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * from students");
		
		String name=new String();
                
		while(rs.next()){
                name=rs.getString("name");
                %>
                
                
                <input type='checkbox' name='cnamechk' value='<%=name%>'><%=name%><br>
               <%
		}
		}
		catch(Exception e)
		{
		out1.write(e.toString());
		}
            %>
            <br>
            <br>
            <input type='submit' value='Show Selected Records'>
        </form>
    </body>
</html>
