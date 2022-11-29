/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.sql.*;
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*1000,      // 10MB
                 maxRequestSize=1024*1024*1000)   // 50MB
public class UploadServlet extends HttpServlet {
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "";
     
    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        PrintWriter out=response.getWriter();
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         String fileName="";
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
        }
        try{
            Connection con = null;
 Statement stmt = null;
 FileInputStream fs=null;
 PreparedStatement ps=null;
		   String driverName = "com.mysql.jdbc.Driver";
		    Class.forName(driverName);
String url ="jdbc:mysql://127.0.0.1:3306/videosjava";
     //Step 1 : Connecting to server and database
     con = DriverManager.getConnection(url,"root", "");    
     	    String fp="";
            fp=savePath+"\\"+fileName;
     File f=new File(fp);
     fs=new FileInputStream(f);
     
     ps= con.prepareStatement("INSERT INTO videos VALUES(?,?)");
     ps.setString(1, fileName);
     ps.setBinaryStream(2,fs,(int)f.length());
     ps.executeUpdate();
    out.write("<font>Video File Saved</font>");
     //   request.setAttribute("message", "Upload has been done successfully!");
       // getServletContext().getRequestDispatcher("/message.jsp").forward(
         //       request, response);
        }
        catch(Exception e)
        {
            out.write(e.toString());
        }
    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
