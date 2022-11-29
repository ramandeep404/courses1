<%-- 
    Document   : audiofile
    Created on : 28 Apr, 2021, 10:43:34 AM
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
        <h1>Audio File Upload</h1>
    <form method="post" action="AUploadServlet" enctype="multipart/form-data">
        Select Audio file to upload: <input type="file" name="file" size="60" /><br />
        <br /> <input type="submit" value="Upload" />
    </form>
    </body>
</html>
