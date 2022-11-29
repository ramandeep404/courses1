/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author raman
 */
@WebServlet(urlPatterns = {"/downloadaudio"})
public class downloadaudio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        FileOutputStream fs=null;
        try  {
            /* TODO output your page here. You may use following sample code. */
            String vname="";
            vname=request.getParameter("imagename");
            String query="select * from images where imagename='"+vname+"'";
               String driverName = "com.mysql.jdbc.Driver";
		    Class.forName(driverName);
String url ="jdbc:mysql://127.0.0.1:3306/videosjava";
Statement stmt;
		int rs;
		Connection con =DriverManager.getConnection(url,"root", "");
     //Step 1 : Connecting to server and database
    
      PreparedStatement ps= con.prepareStatement(query);
     ResultSet rset=ps.executeQuery();
     	    
     byte b[];
     Blob blob;
     int i=1;
     while(rset.next())
     {
      
      
      File f=new File("c:\\tempvd\\"+vname);
     fs=new FileOutputStream(f);
      blob=rset.getBlob("audiofile");
      b=blob.getBytes(1, (int)blob.length());
      fs.write(b);
      out.write("<br>Audio File Downloaded to "+f.getPath());
     }
        }
        catch(Exception e)
        {
            out.write(e.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
