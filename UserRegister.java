/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.Connect_db;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vikash kumar
 */
public class UserRegister extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            int flag=1;
            String name=request.getParameter("name");
            String datepicker=request.getParameter("datepicker");
            String email=request.getParameter("email");
            String mobile=request.getParameter("mobile");
            try{
            Connection con=new Connect_db().getConnection();
                PreparedStatement ps=con.prepareStatement("select * from userdata where email=?;");
             ps.setString(1,email);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                if(rs.getString("email").equals(email)){
                out.println("User Already");
                flag=0;
                }
                }
                if(flag==1){
                    PreparedStatement ps1=con.prepareStatement("insert into userdata(name,datepicker,email,mobile) values(?,?,?,?);");
                   ps1.setString(1,name);
                    ps1.setString(2,datepicker);
                   ps1.setString(3,email);
                   ps1.setString(4,mobile);
                   ps1.executeUpdate();
                   out.println("success");
            }}
            catch(SQLException e){
            out.println(e.toString());
            }
            
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
