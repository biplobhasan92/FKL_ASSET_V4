package com.fk.login;
import com.fk.database.DBconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class LoginDao {
    
    
    
	public static boolean validate(String aname,String password){           // to see use of validate go AdmitAction Class > login() method in package com.fk.action
		boolean status=false;
		try{
                    Connection con=DBconnection.getConnection();
                    PreparedStatement ps= con.prepareStatement("select * from "
                            + "admin where aname=? and pass=?");
                    ps.setString(1,aname);
                    ps.setString(2,password);
                    ResultSet rs=ps.executeQuery();
                    status=rs.next();
                    ps.close();
                    con.close();
		}catch(Exception e){
                    e.printStackTrace();
                }
		return status;
	}
        
        
    public static String getEmpId(String aname,String password) {            // to see use of getRight go AdmitAction Class > login() method in package com.fk.action
        
        String empID=null;            
        try {
            Connection con = DBconnection.getConnection();
            if(con == null){
                return empID;
            }
            String sql = "Select emp_id from admin where aname='"+aname+"' and pass='"+password+"' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
            empID = rs.getString(1);
            st.close();
            con.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empID;
    }
        
        
        public static String getRight(String aname,String password) {            // to see use of getRight go AdmitAction Class > login() method in package com.fk.action
        
        String right=null;
            
        try {
               Connection con = DBconnection.getConnection();
              if(con == null)
               {
                   return right;
               }
               String sql = "Select rights from admin where aname='"+aname+"' and pass='"+password+"'";
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(sql);
               while (rs.next())
               right = rs.getString(1);                                          //for single value retrievation-------------

               st.close();
               con.close();
           } catch (SQLException ex) {
               ex.printStackTrace();
           }
      return right;
    }
        
    
    
    
    
    public static HashMap getSessionValue(String aname, String password){
        
        HashMap<String, String> hmap = new HashMap<String, String>();
        
        try {         
            Connection con = DBconnection.getConnection();
            if(con == null){
                return hmap;
            }
            String 
                sql=" SELECT \n" +
                    "   a.rights, a.aname, a.emp_id, e.emp_designation, e.emp_name, e.dept \n" +
                    " FROM \n" +
                    "   admin a\n" +
                    " JOIN \n" +
                    "   empdata e\n" +
                    " ON \n" +
                    "   (a.emp_id = e.id)\n" +
                    " WHERE \n" +
                    "   a.aname='"+aname+"' AND a.pass='"+password+"' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                hmap.put("aname",  rs.getString("aname"));
                hmap.put("emp_id", rs.getString("emp_id"));
                hmap.put("designation", rs.getString("emp_designation"));
                hmap.put("emp_full_name", rs.getString("emp_name"));
                hmap.put("dept", rs.getString("dept"));
                hmap.put("rights", rs.getString("rights"));
            }
            st.close();
            con.close();
        }catch (Exception ex){
            System.err.println(" Exception : "+ex.getMessage());
        }
        return hmap;
    }
    
    
        
    /*
     public static void main(String[] args) {
         System.out.println("Conncetion : "+DBconnection.getConnection());
         System.out.println("Validate   : "+LoginDao.validate("admin", "123"));
    }
   */

}

    

  

