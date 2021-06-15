/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.fk.database.DBconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class ajaxIpChck extends HttpServlet {

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
        
        SimpleLog.write("Inside ajaxIpChck............");
        
        String ip = request.getParameter("ip");
        
        SimpleLog.write("Inputed IP........"+ip);
         
         if(!(ip == null || ip.trim().isEmpty())) {
             
             
             int count = 0;
        
                try 
                {
                // This will load the MySQL driver, each DB has its own driver
                Connection con=DBconnection.getConnection();

                // Statements allow to issue SQL queries to the database
                Statement statement = con.createStatement();
                ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where ip='"+ip+"'");
                resultSet.next();
                  count = resultSet.getInt("rowcount");
                  resultSet.close();
                  response.setContentType("text/html;charset=UTF-8");

                   if(count>0){



                      //try (PrintWriter out = response.getWriter()) 
                          /* TODO output your page here. You may use following sample code. */
                          String myRtn="This IP Already Exists!Please Try Another!!";
                          response.getWriter().write(myRtn);


                }





                } catch (Exception e) {

                }
             
         
         }
        
      
      
      
     
      
     
     
        
        
        
        
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
