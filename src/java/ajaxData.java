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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
public class ajaxData extends HttpServlet {

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
        
        
        String dept_name = request.getParameter("dept_name");
        
        //System.out.println("Inputed Name " +user_name );
        
        int count;
        
        ArrayList al_s=new ArrayList();
        
        
        try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT dept FROM deptlist, main_deptlist WHERE deptlist.dept_id=main_deptlist.dept_id AND main_deptlist.dept_name='"+dept_name+"' ");
      
      while(resultSet.next()) {
	
          al_s.add(resultSet.getString(1));
      
      }
      
      //resultSet.next();
        //count = resultSet.getInt("count(user_name)");
      resultSet.close();
      
      int size=al_s.size();
        
       
            
            //System.out.println("Invalid Name " +user_name );"<ul style=\"list-style: none;\">"
            //response.setContentType("text/plain");  
            //response.setCharacterEncoding("UTF-8"); 
            //response.getWriter().write("Invalid Name " +user_name );
            
            response.setContentType("text/html;charset=UTF-8");
            //try (PrintWriter out = response.getWriter()) 
                /* TODO output your page here. You may use following sample code. */
                String myRtn="<select id=\"dept\" name=\"dept\" class=\"userId\" >\n"+
                        "<option value=\"\">---Select Sub Dept---</option>";
	
	for(int i=0; i<size; i++){
		String myval=(String)al_s.get(i);
				
		myRtn+="<option value=\""+myval+"\">"+myval+"</option>";		
				
	}
	myRtn+="</select>";
        response.getWriter().write(myRtn);



           

               
      
      } catch (Exception e) {
          
           e.printStackTrace();
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
