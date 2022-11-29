<%-- 
    Document   : index
    Created on : 28 Apr, 2021, 9:33:17 AM
    Author     : raman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form action = "uploadimage" method = "post" enctype = "multipart/form-data">
         <input type = "file" name = "file1" size = "50" />
         <br />
         <input type = "submit" value = "Upload Image File" />
      </form>
    </body>
</html>
