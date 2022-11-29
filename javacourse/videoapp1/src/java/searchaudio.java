/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/searchaudio"})
public class searchaudio extends HttpServlet {

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
        try {
            int count=0;
           String filename=request.getParameter("aname");
		Statement stmt;
		ResultSet rs;


		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://127.0.0.1:3306/videosjava";
		Connection con =DriverManager.getConnection(url,"root", "");
		stmt = con.createStatement();
                String query;
                String fname="%"+ filename +"%";
                query="SELECT audioname from audiofiles where audioname like '" + fname + "';";
		rs = stmt.executeQuery(query);
		String aname;
                String link="";
                String link1="";
		while(rs.next()){
                aname=rs.getString("audioname");
                link="<a href='downloadaudio?aname=" + aname + "'>Download Audio "+aname+"</a>";
		link1="<embed src='netbeans4.mp4'/>";
                out.write("<br>"+link+"<br>");
                out.write("<br>"+link1+"<br>");
                count++;
                }
                if(count==0)
                {
                    out.write("No Records Found");
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
