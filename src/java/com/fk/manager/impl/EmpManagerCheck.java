/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */

package com.fk.manager.impl;

import com.fk.database.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
//import java.time.Year;
import java.util.Date;

/**
 *
 * @author Ahsan-IT
 */
public class EmpManagerCheck {
    
    
    Calendar calendar = Calendar.getInstance();
    java.sql.Date now = new java.sql.Date(calendar.getTime().getTime());
            
            
            
    public int checkId(String id){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from masgndata where id='"+id+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
    
    
     public int checkIp(String ip){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where ip='"+ip+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
     
     
     
public int countPid(){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(pid) as rowcount from mdata ; ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
     
     
      public int checkUpdateIp(String ip, String id){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from masgndata where ip='"+ip+"' and id!='"+id+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
      
      
      
      public int checkUpdateIp2(String ip, String fklid){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where ip='"+ip+"' and fklid!='"+fklid+"' and pid!=0 and mtype in ('Desktop','Laptop'); ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
      
      
      
      
      public int checkUpdateMip(String ip, String fklid){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where ip='"+ip+"' and fklid!='"+fklid+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
     
     
     
     public int checkPid(String pid){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where pid='"+pid+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
     
     
     
    
     
     
     
     
     
     
     
     
     
       public int checkId2(String id){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from empdata where id='"+id+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
       
       
       
       public int checkEmp(String id, String name, String designation, String dept){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from empdata where id='"+id+"' and emp_name='"+name+"' and emp_designation='"+designation+"' and dept='"+dept+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
       
       
       public String genFklid(String id, String ip)
       {
           
           
           String p=null;
           
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
          Connection con = DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
          int year = now.getYear();
          String strentryyear = String.valueOf(year);

          Statement statement = con.createStatement();
          ResultSet resultSet = statement.executeQuery("select pid from mdata where ip='" + ip + "' ");
          resultSet.next();
          String t = resultSet.getString("pid");

          String q = "00000".substring(t.length()) + t;     //------------------------------------ Date Change Three ---------------------------------------------------------- 
            //String t= "FKL-"+Year.now().getValue()+"-"+Integer.toString(uniqueID);

          //p= "FKL-"+Year.now().getValue()+"-"+q;
          p = "FKL-" + now.getYear() + "-" + q;
          System.out.println("***********Date Change Three ******** "+ p);
          resultSet.close();
                
                
      String strperson="update allPcData set fklid=? where id='"+id+"' and ip='"+ip+"'";
            PreparedStatement ps=con.prepareStatement(strperson);
            
             ps.setString(1,p);
            
             ps.executeUpdate();
             ps.close();
             
             String strperson2="update pcData set fklid=? where ip='"+ip+"'";
            PreparedStatement ps1=con.prepareStatement(strperson2);
            
             ps1.setString(1,p);
            
             ps1.executeUpdate();
             ps1.close();
             
             String strperson3="update logdata set fklid=? where ip='"+ip+"'";
            PreparedStatement ps2=con.prepareStatement(strperson3);
            
             ps2.setString(1,p);
            
             ps2.executeUpdate();
       
        
      
      } catch (Exception e) {
        }
           
        
           
           
           
           
           return p;
       
       }
       
       
       public int checkfkl(String ip, String fklid){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where ip='"+ip+"' and fklid='"+fklid+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
       
       
       
       
       public int checkfkl2(String fklid){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from masgndata where fklid='"+fklid+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
       
public String getFklid(String ip)
 {
       
      String p=null;
           
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select fklid from mdata where ip='"+ip+"' ");
      resultSet.next();
      p= resultSet.getString("fklid");
                        
      
      resultSet.close();
                
                
      
       
        
      
    } catch (Exception e) {
        }
    return p;
           
        
           
           
           
           
          
       
       }


public String getPid(String fklid)
 {
       
      String p=null;
           
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select pid from masgndata where fklid='"+fklid+"' ");
      resultSet.next();
      p= resultSet.getString("pid");
                        
      
      resultSet.close();
                
                
      
       
        
      
    } catch (Exception e) {
        }
    return p;
           
        
           
           
           
           
          
       
       }

public String checkDept(String id){
    
    String olddept=null;
    
    try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return olddept;
            }
    
    
            String sql = "select dept from empdata where id='"+id+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.next();
            olddept= rs.getString("dept");
            rs.close();
            st.close();
            con.close();
            
            return olddept;
    
     
    }catch(SQLException e)
    {
        e.printStackTrace();
        return olddept;
    }
    
}


 public int checkAdmn(String aname){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from admin where aname='"+aname+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
 
public int checkPrinter(String ip){
    
    int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(masgndata.fklid) as rowcount from masgndata,mdata where mdata.pid=masgndata.pid and mdata.ip='"+ip+"' ");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;


}
     
public int deptChange(String oldid, String id){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(distinct dept_id) as dc from deptlist, empdata where empdata.dept=deptlist.dept and empdata.id in ('"+oldid+"','"+id+"') ");
      resultSet.next();
        count = resultSet.getInt("dc");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}

 public int checkIp3(String ip){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where ip='"+ip+"' and pid!=0");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}
 
 
 
public int checkDeletingId(String id){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from mdata where id='"+id+"';");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}


public int checkEmpId(String id){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from empdata where id='"+id+"'");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}



public String getTagNumber(){
		

      int count = 0;
      String a=null,b=null,tag=null;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT fklid from mdata order by fklid desc limit 1;");
      resultSet.next();
        a = resultSet.getString("fklid");
        
        System.out.println("The last Tag in DB : "+a);
        
        resultSet.close();
        
      
      } catch (Exception e) {
        }
      
      
      b=a.substring(a.lastIndexOf(".") + 1);
        System.out.println("Last 5 Digit Of This Tag : "+b);
        
        int c= Integer.parseInt(b);
        
        count=c+1;
        
        System.out.println("Convert it to number and add 1  : "+count);
        
        tag=Integer.toString(count); 
        
         System.out.println(tag);
      
      
    return tag;  
    
}



public int checkNdeptId(String id){
		

      int count = 0;
        
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select count(*) as rowcount from main_deptlist where dept_id='"+id+"'");
      resultSet.next();
        count = resultSet.getInt("rowcount");
        resultSet.close();
      
      } catch (Exception e) {
        }
    return count;  
    
}



public String getFklidForMessage()
 {
       
      String p=null;
           
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select fklid from mdata order by fklid desc limit 1 ");
      
      //System.out.println("");
      
      resultSet.next();
      p= resultSet.getString("fklid");
      
      System.out.println("New Tag for display : _"+p);
                        
      
      resultSet.close();
                
                
      
       
        
      
    } catch (Exception e) {
        }
    return p;
           
        
           
           
           
           
          
       
       }


public String getPidForMessage()
 {
       
      String p=null;
           
      try 
      {
      // This will load the MySQL driver, each DB has its own driver
      Connection con=DBconnection.getConnection();

      // Statements allow to issue SQL queries to the database
      Statement statement = con.createStatement();
      ResultSet resultSet = statement.executeQuery("select pid from mbuydata order by pid desc limit 1 ");
      resultSet.next();
      p= resultSet.getString("pid");
      
      System.out.println("New Pid for display : _"+p);
                        
      
      resultSet.close();
                
                
      
       
        
      
    } catch (Exception e) {
        }
    return p;
           
        
           
           
           
           
          
       
       }
     
     
     


}