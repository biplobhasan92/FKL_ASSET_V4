/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */


package com.fk.manager.impl;

import com.fk.action.AdminAction;
import com.fk.bean.EmpBean;
import com.fk.bean.adminBean;
import com.fk.manager.EmpManager;
import com.fk.database.DBconnection;
import java.awt.BorderLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.websocket.Session;
import org.apache.commons.codec.binary.Base64;
import static org.apache.commons.lang.xwork.CharSetUtils.count;
import org.apache.commons.lang.xwork.StringUtils;




public class EmpManagerImpl implements EmpManager {
    
    
     private EmpManagerCheck eCheck= new EmpManagerCheck();
     InetAddress ippc;
    
    @Override
    public List<EmpBean> getAllperson(){
        
        List<EmpBean> eBeans=new ArrayList<EmpBean>();
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBeans;
            }
            String sql = "select * from empdata, mdata, masgndata where (mdata.fklid = masgndata.fklid) and (masgndata.id = empdata.id)";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;
            while(rs.next())
            {
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getDate("asgn_update_date").toString());
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));               
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return eBeans;
    }
    
   
    
    
    
    
    
    @Override
    public List<EmpBean> getAllperson2() {//to show all data in view page
        List<EmpBean> eBeans=new ArrayList<EmpBean>();
        try {
            Connection con = DBconnection.getConnection();
            if(con == null){
                return eBeans;
            }
            String sql =
                    "SELECT\n" +
                    "    *,\n" +
                    "    IFNULL(CASE WHEN m.mtype = 'Desktop' THEN (SELECT md.monitor_desc FROM mdata md WHERE md.id=e.id AND md.mtype = 'Monitor') ELSE m.monitor_desc END, 'N/A') AS pro_desc \n" +
                    "FROM\n" +
                    "    empdata e\n" +
                    "JOIN masgndata ms ON (e.id=ms.id)\n" +
                    "JOIN mdata m ON (ms.fklid=m.fklid)\n" +
                    "WHERE (e.emp_name IS NOT NULL OR e.emp_designation IS NOT NULL); ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;            
            while(rs.next()){
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));                
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));               
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getDate("asgn_update_date").toString());
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
                eBean.setMonitor_desc(rs.getString("monitor_desc"));
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return eBeans;
    }
    
    
    
    
    @Override
    public List<EmpBean> getAllRecords() {
        List<EmpBean> eBeans=new ArrayList<EmpBean>();
        try {
            Connection con = DBconnection.getConnection();
            if(con == null){
                return eBeans;
            }
            String sql = " SELECT \n" +
                            "    emp.id,\n" +
                            "    IFNULL(emp.emp_name, 'N/A') AS emp_name,\n" +
                            "    IFNULL(emp.emp_designation, 'N/A') AS emp_designation,\n" +
                            "    IFNULL(emp.dept, 'N/A') AS dept,\n" +
                            "    IFNULL(emp.date, 'N/A') AS DATE ,\n" +
                            "    IFNULL(emp.pvs_extension, 'N/A') AS pvs_extension,\n" +
                            "    IFNULL(md.fklid, 'N/A') AS fklid,\n" +
                            "    IFNULL(md.dept_id, 'N/A') AS dept_id,\n" +
                            "    IFNULL(md.ip, 'N/A') AS ip,\n" +
                            "    IFNULL(md.hdd, 'N/A') AS hdd,\n" +
                            "    IFNULL(md.mboard, 'N/A') AS mboard,\n" +
                            "    IFNULL(md.ram, 'N/A') AS ram,\n" +
                            "    IFNULL(md.chip, 'N/A') AS chip,\n" +
                            "    IFNULL(md.mtype, 'N/A') AS mtype,\n" +
                            "    IFNULL(md.pid, 'N/A') AS pid,\n" +
                            "    IFNULL(md.remarks, 'N/A') AS remarks,\n"+
                            "    IFNULL(msg.mid, 'N/A') AS MID,\n"+
                            "    IFNULL(msg.handover_date, 'N/A') AS handover_date,\n"+
                            "    IFNULL(msg.nstatus, 'N/A') AS nstatus,\n"+
                            "    IFNULL(msg.pcstatus, 'N/A') AS pcstatus,\n"+
                            "    IFNULL(msg.asgn_update_date, 'N/A') AS asgn_update_date,\n"+
                            "    IFNULL(DATE_FORMAT(mb.buydate, \"%d-%m-%Y\"), 'N/A') AS purchase_date\n"+
                            "FROM\n" +
                            "   empdata emp\n" +
                            " JOIN\n" +
                            "   masgndata msg\n" +
                            " ON\n" +
                            "  (emp.id = msg.id)\n" +
                            " JOIN\n" +
                            "   mdata md\n" +
                            " ON\n" +
                            "  (md.fklid = msg.fklid)\n" +
                            " JOIN\n" +
                            "   mbuydata mb\n" +
                            " ON\n" +
                            "  (mb.pid=md.pid)";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;            
            while(rs.next()){
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));                
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));               
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getDate("asgn_update_date").toString());
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setBuydate(rs.getString("purchase_date"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
                
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
      return eBeans;        
    }  

    
    
    
    
    
    
    
    
    @Override
    public List<EmpBean> getAllperson3() {
      List<EmpBean> eBeans=new ArrayList<EmpBean>();
         try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBeans;
            }
            String sql = "select * from empdata";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;
            while(rs.next())
            {
                eBean = new EmpBean();
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));
                eBean.setDate(rs.getString("date"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return eBeans;
    }
    
    @Override
    public List<EmpBean> getAllperson4(String id) {// when search with id
      List<EmpBean> eBeans=new ArrayList<EmpBean>();
         try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBeans;
            }
            String sql ="SELECT\n" +
                        "  *,\n" +
                        " IFNULL((SELECT image_upload.image FROM image_upload WHERE image_upload.fkl_tag = md.fklid), 'N/A') AS images\n" +
                        "FROM\n" +
                        "   empdata emp\n" +
                        "JOIN\n" +
                        "   masgndata msg\n" +
                        "ON\n" +
                        "  (emp.id = msg.id)\n" +
                        "JOIN\n" +
                        "   mdata md\n" +
                        "ON\n" +
                        "  (md.fklid = msg.fklid)\n" +
                        "WHERE\n" +
                        "   emp.id = '"+id+"'\n" +
                        " AND\n" +
                        "  msg.nstatus = 'Active' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;
            
            while(rs.next())
            {
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));              
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                //eBean.setDate(rs.getDate("date").toString());
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
                Blob ph = rs.getBlob("images");
                byte[] encodedBytes = Base64.encodeBase64(ph.getBytes(1, (int) ph.length()));
                StringBuilder imageString = new StringBuilder();
                imageString.append("data:image/png;base64,");
                imageString.append(new String(encodedBytes));
                eBean.setImages(imageString.toString());
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return eBeans;
    }
  
    
    
    
    
    
    
    
    @Override
    public EmpBean getPerson(int pid) { // when search from view UI 
      EmpBean eBean=null;
        try {
            Connection con = DBconnection.getConnection();
            if(con == null){
                return eBean;
            }
            String sql ="SELECT \n" +
                        " *,\n" +
                        " IFNULL((SELECT image_upload.image FROM image_upload WHERE image_upload.fkl_tag = md.fklid), 'N/A') AS images \n" +
                        "FROM\n" +
                        "   empdata emp\n" +
                        "JOIN\n" +
                        "   masgndata msg\n" +
                        "ON \n" +
                        "  (emp.id = msg.id)\n" +
                        "JOIN\n" +
                        "   mdata md\n" +
                        "ON \n" +
                        "  (md.fklid = msg.fklid)\n" +
                        "WHERE\n" +
                        "   msg.pid = '"+pid+"' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setMonitor_desc(rs.getString("monitor_desc"));
                eBean.setDate(rs.getString("date"));
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
                Blob ph = rs.getBlob("images");
                byte[] encodedBytes = Base64.encodeBase64(ph.getBytes(1, (int) ph.length()));
                StringBuilder imageString = new StringBuilder();
                imageString.append("data:image/png;base64,");
                imageString.append(new String(encodedBytes));
                eBean.setImages(imageString.toString());
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

      return eBean;
    }
    
    
    
    
    
    
    
    @Override
    public EmpBean getPerson3(String id){
        
        EmpBean eBean=null;
        try{
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBean;
            }
            String sql
                    =   "SELECT\n" +
                        "  *,\n" +
                        " IFNULL((SELECT image_upload.image FROM image_upload WHERE image_upload.fkl_tag = md.fklid), 'N/A') AS images\n" +
                        "FROM\n" +
                        "   empdata emp\n" +
                        "JOIN\n" +
                        "   masgndata msg\n" +
                        "ON\n" +
                        "  (emp.id = msg.id)\n" +
                        "JOIN\n" +
                        "   mdata md\n" +
                        "ON\n" +
                        "  (md.fklid = msg.fklid)\n" +
                        "WHERE\n" +
                        "   emp.id = '"+id+"' \n" +
                        " AND\n" +
                        "  msg.nstatus = 'Active' ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));                
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getString("date"));
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setMonitor_desc(rs.getString("monitor_desc"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
                Blob ph = rs.getBlob("images");
                byte[] encodedBytes = Base64.encodeBase64(ph.getBytes(1, (int) ph.length()));
                StringBuilder imageString = new StringBuilder();
                imageString.append("data:image/png;base64,");
                imageString.append(new String(encodedBytes));
                eBean.setImages(imageString.toString());
            }
            st.close();
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return eBean;
    }
    
    
    
    
    
    @Override
    public EmpBean getPerson4(String ip){
        
        EmpBean eBean=null;
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBean;
            }
            String sql = "select * from empdata, mdata, masgndata where mdata.fklid=masgndata.fklid and masgndata.id=empdata.id and mdata.ip='"+ip+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));                
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getString("date"));
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {           
            ex.printStackTrace();
        }
      return eBean;
    }
   
    
    
    
    
    
    
    @Override
    public EmpBean getPerson2(String id) {
      EmpBean eBean=null;
      try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBean;
            }
            String sql = "select * from empdata where id='"+id+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                eBean = new EmpBean();
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));
                eBean.setDate(rs.getString("date"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

      return eBean;
    }
    
     @Override
     public boolean updateEditEntry2(EmpBean eBean) {
         
         int x=0;
         try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            
            int i=eCheck.checkEmp(eBean.getId(), eBean.getName(), eBean.getDesignation(), eBean.getDept());// check  if data exists in empData
             
            
             if (i>0) { // data exists in empData                 
                String strperson2="update empdata set id=?, emp_name=?, emp_designation =?, dept=?, pvs_extension=?, date=sysdate() where id=?";
                PreparedStatement ps1=con.prepareStatement(strperson2);                          
                ps1.setString(1,eBean.getId());
                ps1.setString(2,eBean.getName());
                ps1.setString(3,eBean.getDesignation());
                ps1.setString(4,eBean.getDept());
                ps1.setString(5, eBean.getPvs_extension());
                ps1.setString(6,eBean.getId());
                ps1.executeUpdate();
                ps1.close();                 
             } 
             
             
             else // new employee data
             {
                 
                 int j=eCheck.checkId2(eBean.getId()); // data missmatch checking in empData with inputed id
                 
                 if (j==0) {
                     
                    String strperson2="insert into empdata(id,emp_name,emp_designation,dept,date)values(?,?,?,?,"
                            + "())";
                    PreparedStatement ps1=con.prepareStatement(strperson2);
                    ps1.setString(1,eBean.getId());
                    ps1.setString(2,eBean.getName());
                    ps1.setString(3,eBean.getDesignation());
                    ps1.setString(4,eBean.getDept());

                    ps1.addBatch();
                    ps1.executeBatch();
                    ps1.close();
                     
                     
                 } else {
                     
                     x=1;
                     eBean.setMessage("Employee data mismatch!");
                     
                     
                 }
                 
                
             }
             
             
             if (x==0) {
                 
                 
            String strperson="update masgndata set id=?,  mid=?, pcstatus=?, nstatus=?, asgn_update_date=sysdate() where fklid=?";
            PreparedStatement ps=con.prepareStatement(strperson);
            
            ps.setString(1,eBean.getId());
             
             
             ps.setString(2, eBean.getMid());
            
             ps.setString(3,eBean.getPcstatus());
             
             ps.setString(4,eBean.getNstatus());
             ps.setString(5,eBean.getFklid());

             ps.executeUpdate();
             ps.close();
             
             String strperson3="update mdata set ip=?, hdd=?, mboard=?, ram =?, chip=?, mtype=? where fklid=?";
                PreparedStatement ps2=con.prepareStatement(strperson3);
                ps2.setString(1,eBean.getIp());
                ps2.setString(2,eBean.getHdd());


                ps2.setString(3,eBean.getMboard());
                ps2.setString(4,eBean.getRam());
                ps2.setString(5,eBean.getChip());
                ps2.setString(6,eBean.getMtype());
                ps2.setString(7,eBean.getFklid());

                ps2.executeUpdate();
                ps2.close();
                
                
            String strperson4="insert into logdata(fklid,ip,id,date,activity)values(?,?,?,sysdate(),?)";
            PreparedStatement ps3=con.prepareStatement(strperson4);
             ps3.setString(1,eBean.getFklid());
             ps3.setString(2,eBean.getIp());
             ps3.setString(3,eBean.getId());
            
             ps3.setString(4,"update");
             ps3.addBatch();
             ps3.executeBatch();
             ps3.close();
                 
                 
                 
             } 
             con.close();
             if (x==0) {
                 return true;
                 
             } else {
                 return false;
                 
             }
             
             
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }

    }
    
    @Override
    public boolean updateM(EmpBean eBean) {  
        
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            String strperson="update mdata set ip=?, hdd=?, mboard=?, ram=?, chip=?, mtype=? where fklid=?";
            PreparedStatement ps=con.prepareStatement(strperson);
            
             ps.setString(1,eBean.getIp());
             ps.setString(2,eBean.getHdd());


             ps.setString(3,eBean.getMboard());
             ps.setString(4,eBean.getRam());
             ps.setString(5,eBean.getChip());
             ps.setString(6,eBean.getMtype());
             ps.setString(7,eBean.getFklid());

             ps.executeUpdate();
             ps.close();
             
             
            String strperson1="update masgndata set asgn_update_date=sysdate() where fklid=?";
            PreparedStatement ps1=con.prepareStatement(strperson1);
           
             ps1.setString(1,eBean.getFklid());
            
             ps1.executeUpdate();
             ps1.close();
             
             
             String strperson4="insert into logdata(fklid,ip,id,date,activity)values(?,?,?,sysdate(),?)";
            PreparedStatement ps3=con.prepareStatement(strperson4);
             //ps.setString(1,eBean.getPoid());
             ps3.setString(1,eBean.getFklid());
             ps3.setString(2,eBean.getIp());
             //ps2.setString(2,eBean.getFklid());
             //ps3.setString(2,eBean.getFklid());
             ps3.setString(3,eBean.getId());
            
             ps3.setString(4,"update");
            
             ps3.addBatch();
             ps3.executeBatch();
             ps3.close();
             
             con.close();
             return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public EmpBean getM(String fklid) {
        EmpBean eBean=null;
     try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBean;
            }
            String sql = "select * from mdata,empdata,masgndata where mdata.fklid=masgndata.fklid and masgndata.id=empdata.id and mdata.fklid='"+fklid+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                eBean = new EmpBean();
                
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));
                
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));
                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));
                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getString("asgn_update_date"));
               
            }
            
            con.close();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

      return eBean;
    }

    @Override
    public List<EmpBean> getAllpc() {
        List<EmpBean> eBeans=new ArrayList<EmpBean>();
         try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBeans;
            }
            String sql = "select * from mdata,empdata,masgndata where mdata.fklid=masgndata.fklid and masgndata.id=empdata.id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;
            while(rs.next())
            {
                eBean = new EmpBean();
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));
                
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));
                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));
                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getString("asgn_update_date"));
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return eBeans;
    }

    @Override
    public EmpBean getM2(String fklid) {
       EmpBean eBean=null;
     try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBean;
            }
            String sql = "select * from mdata where  mdata.fklid='"+fklid+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                eBean = new EmpBean();
                
                
                eBean.setIp(rs.getString("ip"));
                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));
                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setMtype(rs.getString("mtype"));
               
            }
            
            
            con.close();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

      return eBean;
    }

    @Override
    public boolean saveM1(EmpBean eBean) {
        
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
        
            String strperson="update mdata set ip=?, hdd=?, mboard=?, ram=?, chip=?, mtype=? where fklid=?";
            PreparedStatement ps=con.prepareStatement(strperson);
           
             ps.setString(1,eBean.getIp());
             ps.setString(2,eBean.getHdd());


             ps.setString(3,eBean.getMboard());
             ps.setString(4,eBean.getRam());
             ps.setString(5,eBean.getChip());
             ps.setString(6,eBean.getMtype());
             ps.setString(7,eBean.getFklid());
             

             ps.executeUpdate();
             ps.close();
             
             
            String strperson4="insert into logdata(fklid,ip,date,activity)values(?,?,sysdate(),?)";
            PreparedStatement ps4=con.prepareStatement(strperson4);
            
             ps4.setString(1,eBean.getFklid());
             ps4.setString(2,eBean.getIp());
             
             ps4.setString(3,"machine update");
             
          
             ps4.addBatch();
             ps4.executeBatch();
             ps4.close();
             
             
             
             con.close();
             return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        
        
        
        
    }

    @Override
    public boolean saveM2(EmpBean eBean) {
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            
      
            String strperson="update mdata set ip=?, hdd=?, mboard=?, ram=?, chip=?, mtype=? where fklid=?";
            PreparedStatement ps=con.prepareStatement(strperson);
           
             ps.setString(1,eBean.getIp());
             ps.setString(2,eBean.getHdd());


             ps.setString(3,eBean.getMboard());
             ps.setString(4,eBean.getRam());
             ps.setString(5,eBean.getChip());
             ps.setString(6,eBean.getMtype());
             ps.setString(7,eBean.getFklid());
             

             ps.executeUpdate();
             ps.close();
             
             
             String strperson3="insert into masgndata(id,fklid,mid,pcstatus,nstatus,asgn_update_date)values(?,?,?,?,?,sysdate())";
             PreparedStatement ps3=con.prepareStatement(strperson3);
             ps3.setString(1,eBean.getId());
             ps3.setString(2,eBean.getFklid());
             ps3.setString(3,eBean.getMid());
             ps3.setString(4,eBean.getPcstatus());
             ps3.setString(5,eBean.getNstatus());
             ps3.addBatch();
             ps3.executeBatch();
             ps3.close();
             
             
            String strperson4="insert into logdata(fklid,ip,id,date,activity)values(?,?,?,sysdate(),?)";
            PreparedStatement ps4=con.prepareStatement(strperson4);
             ps4.setString(1,eBean.getFklid());
             ps4.setString(2,eBean.getIp());
             ps4.setString(3,eBean.getId());
            
             ps4.setString(4,"Assign entry");
             ps4.addBatch();
             ps4.executeBatch();
             ps4.close();
             con.close();
             return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveEmp(EmpBean eBean) {
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            // to make inputed id in 6 digit if it is less then 6 digit
            String id;
            
            if(eBean.getId().length()<6){
                //id="000000".substring(eBean.getId().length()) + eBean.getId();
                id=StringUtils.leftPad(eBean.getId(), 6,"0");
            }else{
                id=eBean.getId();
            }
            
            String strperson1="insert into empdata(id,emp_name,emp_designation,dept,date, pvs_extension)values(?,?,?,?,sysdate(),?)";
            PreparedStatement ps1=con.prepareStatement(strperson1);
            ps1.setString(1,id);
            ps1.setString(2,eBean.getName());
            ps1.setString(3,eBean.getDesignation());
            ps1.setString(4,eBean.getDept());
            ps1.setString(5,eBean.getPvs_extension());
            ps1.addBatch();
            ps1.executeBatch();
            ps1.close();
          
             
            String strperson4="insert into logdata(id,date,activity)values(?,sysdate(),?)";
            PreparedStatement ps4=con.prepareStatement(strperson4);
             //ps.setString(1,eBean.getPoid());
            
             ps4.setString(1,id);
             
             ps4.setString(2,"Employee entry");
             ps4.addBatch();
             ps4.executeBatch();
             ps4.close();
             con.close();
             return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        
           
    
    }

    
    
    @Override
    public List<EmpBean> getAllpc2() {
        List<EmpBean> eBeans=new ArrayList<EmpBean>();
         try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBeans;
            }
            String sql   = "select * from mdata";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;
            while(rs.next())
            {
                eBean = new EmpBean();                
                eBean.setIp(rs.getString("ip"));                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setMtype(rs.getString("mtype"));
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
      return eBeans;
    }
    
    
    

    @Override
    public boolean saveM3(EmpBean eBean){
       try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            String p=null, t;                                                   // to store generated of tag no from dept_id of dept table and pid of mdata table
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select (count(mdata.dept_id) +1) as tag from mdata, deptlist, empdata where empdata.dept=deptlist.dept and deptlist.dept_id=mdata.dept_id and empdata.id='"+eBean.getId()+"'; ");
            resultSet.next();
            t = resultSet.getString("tag");
            resultSet.close(); 
            
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select dept_id from deptlist, empdata where empdata.dept=deptlist.dept and empdata.id='"+eBean.getId()+"';");
            resultSet1.next();
            String t1= resultSet1.getString("dept_id");
            String q=StringUtils.leftPad(t, 4,"0");                             // to create format like 0001
            String q1=StringUtils.leftPad(t1, 2,"0");                           // to create format like 01            
            p= "FKLIT"+q1+q;                                                    // final formatted tag eg. FKLIT010001
            resultSet1.close();
            System.out.println(p);
            
            String strperson2="insert into mdata(fklid,ip,hdd,mboard,ram,chip, mtype, dept_id, remarks, img_loc, monitor_desc) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps2=con.prepareStatement(strperson2);
            ps2.setString(1,p);
            ps2.setString(2,eBean.getIp());
            ps2.setString(3,eBean.getHdd());
            ps2.setString(4,eBean.getMboard());
            ps2.setString(5,eBean.getRam());
            ps2.setString(6,eBean.getChip());
            ps2.setString(7,eBean.getMtype());
            ps2.setString(8,t1);
            ps2.setString(9,eBean.getRemarks());
            ps2.setString(10,eBean.getImgloc());
            ps2.setString(11,eBean.getMonitor_desc());
            ps2.addBatch();
            ps2.executeBatch();
            ps2.close();
             
             
            String strperson9="insert into history(id,fklid,ip,mtype,action_by_user,note,dept,remarks,date)"
                    + "values(?,?,?,?,?,'insert',(SELECT dept FROM empdata WHERE id ='"+eBean.getId()+"'),?,sysdate())";
            PreparedStatement ps9=con.prepareStatement(strperson9);            
            ps9.setString(1,eBean.getId());
            ps9.setString(2,p);
            ps9.setString(3,eBean.getIp());
            ps9.setString(4,eBean.getMtype());
            ps9.setString(5,eBean.getName());
            //ps9.setString(6,eBean.getDept());
            ps9.setString(6,eBean.getRemarks());
            ps9.addBatch();
            ps9.executeBatch();
            ps9.close();

            
            String strperson4="insert into logdata(fklid,ip,date,activity)values(?,?,sysdate(),?)";
            PreparedStatement ps4=con.prepareStatement(strperson4);
             ps4.setString(1,p);
             ps4.setString(2,eBean.getIp());
             ps4.setString(3,"Machine entry");
             ps4.addBatch();
             ps4.executeBatch();
             ps4.close();
             con.close();
             return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveM4(EmpBean eBean) {
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return false;
            }
            String id;
            if (eBean.getId().length() < 6) {
                id = StringUtils.leftPad(eBean.getId(), 6, "0");
            } else {
                id = eBean.getId();
            }

            // generation of tag no from dept_id of dept table and pid of mdata table
            String p = null, t;

            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select dept_id from deptlist, empdata where empdata.dept=deptlist.dept and empdata.id='" + id + "';");
            resultSet1.next();
            String t1 = resultSet1.getString("dept_id");

            System.out.println("dept" + t1);

            Statement statement10 = con.createStatement();
            //count the total no of a perticular dept in mdata table and add 1 to it to get the deptwise serial number  
            ResultSet resultSet10 = statement10.executeQuery("select (count(mdata.fklid) +1) as tag from mdata ; ");
            resultSet10.next();
            t = resultSet10.getString("tag");
            resultSet10.close();

            System.out.println("tag" + t);
            String TagCount = eCheck.getTagNumber();
            String q = StringUtils.leftPad(TagCount, 5, "0");                   // to create format like 0001
            //String q1=StringUtils.leftPad(t1, 2,"0");                         // to create format like 01 

            //system date   ---------------------------------------------------- Date Change Two -------------------------------------------------------------------------
  //         LocalDateTime now = LocalDateTime.now();
 //          int year = now.getYear();
  //          String strentryyear = String.valueOf(year);
            Calendar calendar = Calendar.getInstance();
	    java.sql.Date now = new java.sql.Date(calendar.getTime().getTime());
            int year = now.getYear();
            String strentryyear = String.valueOf(year).substring(1, 3);
            p = "FKL." + strentryyear + "." + q;                                      // final formatted tag eg. FKL.17.00001
            //resultSet1.close();
            System.out.println("The Final tag no : " + p);

            String strperson5 = "insert into mbuydata(memo,supplier,cost,prdtlife,suplrwrnty,buydate)values(?,?,?,?,?,?)";
            PreparedStatement ps5 = con.prepareStatement(strperson5);
            ps5.setString(1, eBean.getMemo());
            ps5.setString(2, eBean.getSupplier());
            ps5.setString(3, eBean.getCost());
            ps5.setString(4, eBean.getPrdtlife());
            ps5.setString(5, eBean.getSuplrwrnty());
            ps5.setString(6, eBean.getBuydate());

            ps5.addBatch();
            ps5.executeBatch();
            ps5.close();

            // get pid from mbuydata
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery("select pid  from mbuydata order by pid desc limit 0,1;");//collects the last/latest pid  in table
            resultSet2.next();
            String pid = resultSet2.getString("pid");
            resultSet2.close();
            String strperson2 = "insert into mdata(fklid,ip,hdd,mboard,ram,chip,mtype,dept_id,pid,id,img_date,img_loc,remarks,monitor_desc)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // Note : Img_date, Img_Loc
            PreparedStatement ps2 = con.prepareStatement(strperson2);
            ps2.setString(1, p);
            ps2.setString(2, eBean.getIp());
            ps2.setString(3, eBean.getHdd());
            ps2.setString(4, eBean.getMboard());
            ps2.setString(5, eBean.getRam());
            ps2.setString(6, eBean.getChip());
            ps2.setString(7, eBean.getMtype());
            ps2.setString(8, t1);
            ps2.setString(9, pid);
            ps2.setString(10, id);
            ps2.setString(11, eBean.getImgdate());
            ps2.setString(12, eBean.getImgloc());
            ps2.setString(13, eBean.getRemarks());
            ps2.setString(14, eBean.getMonitor_desc());
            ps2.addBatch();
            ps2.executeBatch();
            ps2.close();
            
            
            String strperson9="insert into history(id,fklid,ip,mtype,action_by_user,note,dept,remarks,date)"
                    + "values(?,?,?,?,?,'insert',(SELECT dept FROM empdata WHERE id ='"+eBean.getId()+"'),?,sysdate())";
            PreparedStatement ps9=con.prepareStatement(strperson9);            
            ps9.setString(1,eBean.getId());
            ps9.setString(2,p);
            ps9.setString(3,eBean.getIp());
            ps9.setString(4,eBean.getMtype());
            ps9.setString(5,eBean.getName());
            //ps9.setString(6,eBean.getDept());
            ps9.setString(6,eBean.getRemarks());
            ps9.addBatch();
            ps9.executeBatch();
            ps9.close();

            
            System.out.println(" saveM4 ");
            System.out.println("getFklid "+eBean.getFklid());
            System.out.println("getIp "+eBean.getIp());
            System.out.println("getMtype "+eBean.getMtype());
            System.out.println("getId "+eBean.getId());
            
            
            String strperson3 = "insert into masgndata(id,fklid,mid,pcstatus,nstatus,asgn_update_date,handover_date,pid)values(?,?,?,?,?,sysdate(),?,?)";
            PreparedStatement ps3 = con.prepareStatement(strperson3);
            ps3.setString(1, id);
            ps3.setString(2, p);
            ps3.setString(3, eBean.getMid());
            ps3.setString(4, eBean.getPcstatus());
            ps3.setString(5, eBean.getNstatus());
            ps3.setString(6, eBean.getHdate());
            ps3.setString(7, pid);
            ps3.addBatch();
            ps3.executeBatch();
            ps3.close();

            String strperson6 = "insert into logtag(fklid,pid,id,handover_date)values(?,?,?,?)";
            PreparedStatement ps6 = con.prepareStatement(strperson6);
            ps6.setString(1, p);
            ps6.setString(2, pid);
            ps6.setString(3, id);
            ps6.setString(4, eBean.getHdate());
            ps6.addBatch();
            ps6.executeBatch();
            ps6.close();

            String strperson4 = "insert into logdata(fklid,ip,id,date,activity)values(?,?,?,sysdate(),?)";
            PreparedStatement ps4 = con.prepareStatement(strperson4);
            ps4.setString(1, p);
            ps4.setString(2, eBean.getIp());
            ps4.setString(3, id);
            ps4.setString(4, "Assign entry");
            ps4.addBatch();
            ps4.executeBatch();
            ps4.close();

            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
    
    
    
    
    
    
    @Override
    public boolean update1(EmpBean eBean) {
       
        System.out.println("eBean.getMonitor_desc(): "+eBean.getRemarks());
       String fkl=null, pid=null,  ip=null, oldid=null;
       fkl=eBean.getFklid();
        String id=null;     
        if(eBean.getId().length()<6){
            id=StringUtils.leftPad(eBean.getId(), 6,"0");
        }else{
            id=eBean.getId();
        }
        ip=eBean.getIp();

       try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            int i = eCheck.checkUpdateIp2(ip, fkl);
            int j = eCheck.checkId2(id);    
            if (j==0) {
                return false;
            }else{

                String fklid1=null,ip1=null,mid1=null,mtype1=null,dept1=null,img_date1=null,img_loc1=null,pcstatus1=null,
                        nstatus1=null,hdd1=null,mboard1=null,ram1=null,chip1=null,id1=null,emp_name1=null,emp_designation1=null,remarks1=null,hand_date1=null, pvs_ext=null;
                int pid1=0;
                //get the existing data before update
                String sql11   = "select * from empdata, mdata, masgndata where mdata.fklid=masgndata.fklid and masgndata.id=empdata.id and mdata.fklid='"+eBean.getFklid()+"'";
                Statement st11 = con.createStatement();
                ResultSet rs11 = st11.executeQuery(sql11);
                while(rs11.next()){
                    //eBean = new EmpBean();
                    pid1      = rs11.getInt("pid");
                    dept1     = rs11.getString("dept");
                    mid1      = rs11.getString("mid");
                    ip1       = rs11.getString("ip");
                    fklid1    = rs11.getString("fklid");
                    pcstatus1 = rs11.getString("pcstatus");
                    nstatus1  = rs11.getString("nstatus");
                    mtype1    = rs11.getString("mtype");
                    img_date1 = rs11.getString("img_date");
                    img_loc1  = rs11.getString("img_loc");
                    hdd1      = rs11.getString("hdd");
                    ram1      = rs11.getString("ram");
                    mboard1   = rs11.getString("mboard");
                    chip1     = rs11.getString("chip");
                    id1       = rs11.getString("id");
                    emp_name1 = rs11.getString("emp_name");
                    emp_designation1 = rs11.getString("emp_designation");
                    remarks1   = rs11.getString("remarks");
                    hand_date1 = rs11.getString("handover_date");                    
                }
                st11.close();

                String sql   = "select pid,id from masgndata where fklid='"+fkl+"'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                pid   = rs.getString("pid");
                oldid = rs.getString("id");
                rs.close();
                st.close();
                

                
                // get dept_id for inputed empid
                Statement statement1 = con.createStatement();
                ResultSet resultSet1 = statement1.executeQuery("select dept_id from deptlist, empdata where empdata.dept=deptlist.dept and empdata.id='"+id+"';");
                resultSet1.next();
                String t1 = resultSet1.getString("dept_id");
                resultSet1.close();
                System.out.println("dept"+t1);

                if (!(oldid.equals(id)) ) {// if machine handed to another id
                    System.out.println("xyz .. "+fkl);
                    System.out.println("xyz .. "+pid);
                    System.out.println("xyz .. "+oldid);
                    System.out.println("xyz .. "+id);
                    int deptChange= eCheck.deptChange(oldid, id);
                    System.out.println("xyz .. "+deptChange);
                    //add new tag data in logtag  
                    String strperson6="insert into logtag(fklid,pid,id,handover_date)values(?,?,?,?)";
                    PreparedStatement ps6=con.prepareStatement(strperson6);
                    ps6.setString(1,fkl);
                    ps6.setString(2,pid);
                    ps6.setString(3,id);
                    ps6.setString(4,eBean.getHdate());
                    ps6.addBatch();
                    ps6.executeBatch();
                    ps6.close();
                }
                
                
                
                //update mdata,masgndata 
                String strperson3="update mdata set ip=?, hdd=?, mboard=?, ram =?, chip=?, mtype=?,  fklid=?, dept_id=?, img_date=?, img_loc=?, remarks=?, id=?, monitor_desc=? where pid=?";
                PreparedStatement ps2=con.prepareStatement(strperson3);
                ps2.setString(1,eBean.getIp());
                ps2.setString(2,eBean.getHdd());
                ps2.setString(3,eBean.getMboard());
                ps2.setString(4,eBean.getRam());
                ps2.setString(5,eBean.getChip());
                ps2.setString(6,eBean.getMtype());
                ps2.setString(7,fkl);
                ps2.setString(8,t1);
                ps2.setString(9,eBean.getImgdate());
                ps2.setString(10,eBean.getImgloc());
                ps2.setString(11,eBean.getRemarks());
                ps2.setString(12,id);
                ps2.setString(13,eBean.getMonitor_desc());
                ps2.setString(14,pid);
                ps2.addBatch();
                ps2.executeBatch();
                ps2.close();

                String updtEmppvsExt = "UPDATE empdata SET pvs_extension = ? WHERE id = ? ";
                PreparedStatement psExt = con.prepareStatement(updtEmppvsExt);
                psExt.setString(1, eBean.getPvs_extension());
                psExt.setString(2, eBean.getId());
                psExt.executeUpdate();
                psExt.close();

                String strperson="update masgndata set id=?,  mid=?, pcstatus=?, nstatus=?, asgn_update_date=sysdate(), handover_date=?, fklid=? where pid=? ";
                PreparedStatement ps8=con.prepareStatement(strperson);
                ps8.setString(1,id);
                ps8.setString(2, eBean.getMid());
                ps8.setString(3,eBean.getPcstatus());
                ps8.setString(4,eBean.getNstatus());
                ps8.setString(5,eBean.getHdate());
                ps8.setString(6,fkl);
                ps8.setString(7,pid);
                System.out.println("Update 3 "+strperson);
                System.out.println("pid : "+pid);
                System.out.println("fkl : "+fkl);
                ps8.executeUpdate();
                ps8.close();

                

                
                //add data in logdata
                String strperson4="insert into logdata(fklid,ip,id,date,activity)values(?,?,?,sysdate(),?)";
                PreparedStatement ps3=con.prepareStatement(strperson4);
                 ps3.setString(1,fkl);
                 ps3.setString(2,eBean.getIp());
                 ps3.setString(3,id);
                 ps3.setString(4,"update");
                 ps3.addBatch();
                 ps3.executeBatch();
                 ps3.close();
                
                
                
                 //InetAddress address = InetAddress.getLocalHost();
                 ippc = InetAddress.getLocalHost();
                 String strperson9="insert into history(fklid,ip,mid,mtype,dept,pid,img_date,img_loc,pcstatus,nstatus,date,remarks,note,hdd,ram,mboard,chip,id,emp_name,emp_designation,handover_date,action_by_user,action_take_by_pc)values(?,?,?,?,?,?,?,?,?,?,sysdate(),?,?,?,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement ps9=con.prepareStatement(strperson9);
                 ps9.setString(1,fklid1);
                 ps9.setString(2,ip1);
                 ps9.setString(3,mid1);
                 ps9.setString(4,mtype1);
                 ps9.setString(5,dept1);
                 ps9.setInt(6,pid1);
                 ps9.setString(7,img_date1);
                 ps9.setString(8,img_loc1);
                 ps9.setString(9,pcstatus1);
                 ps9.setString(10,nstatus1);
                 ps9.setString(11,remarks1);
                 ps9.setString(12,"update");
                 ps9.setString(13,hdd1);
                 ps9.setString(14,ram1);
                 ps9.setString(15,mboard1);
                 ps9.setString(16,chip1);
                 ps9.setString(17,id1);
                 ps9.setString(18,emp_name1);
                 ps9.setString(19,emp_designation1);
                 ps9.setString(20,hand_date1);
                 ps9.setString(21, eBean.getName());
                 ps9.setString(22, ippc.getHostAddress());
                 ps9.addBatch();
                 ps9.executeBatch();
                 ps9.close();
            }
            con.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Hasan update 012032 .... !!!! ");
            return false;
        }catch (Exception ex){
            Logger.getLogger(EmpManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }




    
    
    
    @Override
    public boolean update2(EmpBean eBean) {
        //int x=0;
       String fkl=null, pid=null,id=null, dept=null, ip=null, olddept=null;
       fkl=eBean.getFklid();
       dept=eBean.getDept();
       ip=eBean.getIp();
       String fklid1=null,ip1=null,mid1=null,mtype1=null,dept1=null,img_date1=null,img_loc1=null,pcstatus1=null,nstatus1=null,remarks1=null,hand_date1=null;
       int pid1=0;
         
       
       try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            String t1=null;
            
            
            //get existing data before update.....
            String sql1 = "select * from  mdata, masgndata, deptlist where mdata.fklid=masgndata.fklid and mdata.dept_id=deptlist.dept_id and mdata.fklid='"+fkl+"';";
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(sql1);

            while(rs2.next())
            {
                //eBean = new EmpBean();
              pid1   = rs2.getInt("pid");
              dept1  = rs2.getString("dept");
              mid1   = rs2.getString("mid");
              ip1    = rs2.getString("ip");
              fklid1 = rs2.getString("fklid");
              pcstatus1=rs2.getString("pcstatus");
              nstatus1=rs2.getString("nstatus");
              mtype1 = rs2.getString("mtype");
              img_date1=rs2.getString("img_date");
              img_loc1=rs2.getString("img_loc");
              remarks1=rs2.getString("remarks");
              hand_date1=rs2.getString("handover_date");
            }
            st2.close();
            
            
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select dept_id from deptlist where dept='"+eBean.getDept()+"';");
            resultSet1.next();
            t1= resultSet1.getString("dept_id");
            
            System.out.println("dept"+t1);
            
         //get pid, id for already existing fklid
                String sql = "select pid, id from masgndata where fklid='"+fkl+"'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                rs.next();
                pid= rs.getString("pid");
                id= rs.getString("id");
                

                rs.close();
                st.close();
           
            
       //add new tag data in logtag  
                    String strperson6="insert into logtag(fklid,pid,handover_date)values(?,?,?)";
                    PreparedStatement ps6=con.prepareStatement(strperson6);
                     ps6.setString(1,fkl);
                     ps6.setString(2,pid);
                    
                     ps6.setString(3,eBean.getHdate());
                     //ps6.setString(5,"Active");
                     ps6.addBatch();
                     ps6.executeBatch();
                     ps6.close();
                    
               
                
                //update mdata,masgndata 
                String strperson3="update mdata set ip=?, mtype=?,  fklid=?, dept_id=?, img_date=?, img_loc=?, remarks=? where pid=?";
                PreparedStatement ps2=con.prepareStatement(strperson3);
                ps2.setString(1,eBean.getIp());               
                ps2.setString(2,eBean.getMtype());
                ps2.setString(3,fkl);
                ps2.setString(4,t1);
                ps2.setString(5,eBean.getImgdate());
                ps2.setString(6,eBean.getImgloc());
                ps2.setString(7,eBean.getRemarks());                
                ps2.setString(8,pid);
                ps2.executeUpdate();
                ps2.close();



                 String strperson="update masgndata set mid=?, pcstatus=?, nstatus=?, asgn_update_date=sysdate(), handover_date=?, fklid=? where pid=? ";
                    PreparedStatement ps8=con.prepareStatement(strperson);
                    
                    ps8.setString(1, eBean.getMid());
                    ps8.setString(2,eBean.getPcstatus());
                    ps8.setString(3,eBean.getNstatus());
                    ps8.setString(4,eBean.getHdate());
                    ps8.setString(5,fkl);
                    ps8.setString(6,pid);
                    ps8.executeUpdate();
                    ps8.close();
                    
                    
                    
                //update only dept in empdata
                String strperson1="update empdata set  dept=?, date=sysdate() where id=?";
                PreparedStatement ps1=con.prepareStatement(strperson1);


                 ps1.setString(1,eBean.getDept());
                 ps1.setString(2,id);


                 ps1.executeUpdate();
                 ps1.close();
                    

                //add data in logdata
                String strperson4="insert into logdata(fklid,ip,date,activity)values(?,?,sysdate(),?)";
                PreparedStatement ps3=con.prepareStatement(strperson4);
                 ps3.setString(1,fkl);
                 ps3.setString(2,eBean.getIp());
                 

                 ps3.setString(3,"update");
                 ps3.addBatch();
                 ps3.executeBatch();
                 ps3.close();
                    
                ippc = InetAddress.getLocalHost();
                String strperson9="insert into history(fklid,ip,mid,mtype,dept,pid,img_date,img_loc,pcstatus,nstatus,date,remarks,note,handover_date,action_by_user,action_take_by_pc)values(?,?,?,?,?,?,?,?,?,?,sysdate(),?,?,?,?,?)";
                PreparedStatement ps9=con.prepareStatement(strperson9);
                 ps9.setString(1,fklid1);
                 ps9.setString(2,ip1);
                 ps9.setString(3,mid1);
                 ps9.setString(4,mtype1);
                 ps9.setString(5,dept1);
                 
                 ps9.setInt(6,pid1);
                 ps9.setString(7,img_date1);
                 ps9.setString(8,img_loc1);
                 ps9.setString(9,pcstatus1);
                 ps9.setString(10,nstatus1);
                 ps9.setString(11,remarks1);               
                 ps9.setString(12,"update");  
                 ps9.setString(13,hand_date1);
                 ps9.setString(14,eBean.getName());
                 ps9.setString(15, ippc.getHostAddress());
                 
                 ps9.addBatch();
                 ps9.executeBatch();
                 ps9.close();
            
            
             con.close();
             return true;
             
             
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        } catch (UnknownHostException ex) {
             Logger.getLogger(EmpManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
             return false;
         }
        
    }
    
    @Override
    public boolean upEmp(EmpBean eBean) {
        /*
        System.out.println("eBean id : "+eBean.getId());
        System.out.println("eBean old id : "+eBean.getOldId());
        System.out.println("eBean dept old id : "+eBean.getOldDept());
        System.out.println("eBean name : "+eBean.getName());
        Connection con=DBconnection.getConnection();
        
        try {            
            if(con==null){
                return false;
            }
            // to make inputed id in 6 digit if it is less then 6 digit
            String id;            
            if(eBean.getId().length()<6){
                id=StringUtils.leftPad(eBean.getId(), 6,"0");
            }else{
                id=eBean.getId();
            }
            
            //get the existing data before update
            String dept1=null,id1=null,emp_name1=null,emp_designation1=null,idStatus=null,pvs_ext=null, note="Employee Update";                
            String sql11 = "select * from empdata where id='"+eBean.getOldId()+"'";
            Statement st11 = con.createStatement();
            ResultSet rs11 = st11.executeQuery(sql11);
                
            while(rs11.next()){
                dept1 = rs11.getString("dept");
                id1   = rs11.getString("id");
                emp_name1 = rs11.getString("emp_name");
                emp_designation1 = rs11.getString("emp_designation");
                pvs_ext = rs11.getString("pvs_extension");
            }
            st11.close();
            
            System.out.println("dept1 : "+dept1);
            System.out.println("id1 : "+id1);
            System.out.println("emp_name1 : "+emp_name1);
            System.out.println("emp_designation1 name : "+emp_designation1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false; */
        
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }            
            // to make inputed id in 6 digit if it is less then 6 digit
            String id;            
            if(eBean.getId().length()<6){
                id=StringUtils.leftPad(eBean.getId(), 6,"0");
            }else{
                id=eBean.getId();
            }                                                
            //get the existing data before update
            String dept1=null,id1=null,emp_name1=null,emp_designation1=null,idStatus=null,pvs_ext=null, note="Employee Update";                
            String sql11 = "select * from empdata where id='"+eBean.getOldId()+"'";
            Statement st11 = con.createStatement();
            ResultSet rs11 = st11.executeQuery(sql11);
                
            while(rs11.next()){
                dept1 = rs11.getString("dept");
                id1   = rs11.getString("id");
                emp_name1 = rs11.getString("emp_name");
                emp_designation1 = rs11.getString("emp_designation");
                pvs_ext = rs11.getString("pvs_extension");
            }
            st11.close();    
            
            
            // get old dept_id for searched empid
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select dept_id from deptlist where dept='"+dept1+"';");
            resultSet1.next();
            String Old_deptid= resultSet1.getString("dept_id");
            resultSet1.close();
            System.out.println("Old deptid"+Old_deptid);
                
                
            // get dept_id for inputed dept
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery("select dept_id from deptlist where dept='"+eBean.getDept()+"';");
            resultSet2.next();
            String Inputed_deptid= resultSet2.getString("dept_id");
            resultSet2.close();
            System.out.println("Inputed deptid"+Inputed_deptid);
               
               
                
             
            String strperson1="update empdata set id=?, emp_name=?, dept=?, emp_designation=?,pvs_extension=?, date=sysdate() where id=?";
            PreparedStatement ps1=con.prepareStatement(strperson1);           
            ps1.setString(1,id); 
            ps1.setString(2,eBean.getName());
            ps1.setString(3,eBean.getDept());
            ps1.setString(4,eBean.getDesignation());
            ps1.setString(5, eBean.getPvs_extension());
            ps1.setString(6,eBean.getOldId());            
            ps1.executeUpdate();
            ps1.close();
            
            if (!(eBean.getOldId().equals(id)) ) { // emp id is change or not         
                //update mdata,masgndata 
                String strperson2="update mdata set id=? where id=?";
                PreparedStatement ps2=con.prepareStatement(strperson2);
                ps2.setString(1,id);               
                ps2.setString(2,eBean.getOldId());               
                ps2.executeUpdate();
                ps2.close();
                String strperson3="update masgndata set id=? where id=?";
                PreparedStatement ps3=con.prepareStatement(strperson3);
                ps3.setString(1,id);               
                ps3.setString(2,eBean.getOldId());                
                ps3.executeUpdate();
                ps3.close();                
                note=note+" with ID change....";
                idStatus="changed";                                    
            }
                                       
            if (!(Old_deptid.equals(Inputed_deptid)) ) { // emp dept is change or not                                
                String mdataID;
                if (idStatus==null) {                     
                    mdataID=eBean.getOldId();
                    System.out.println("mdata id is: "+mdataID);                     
                } else {
                    mdataID=id;
                    System.out.println("mdata id is: "+mdataID);
                }                 
                
                //update mdata 
                String strperson5="update mdata set dept_id=? where dept_id=? and id=? ";
                PreparedStatement ps5=con.prepareStatement(strperson5);
                ps5.setString(1,Inputed_deptid);               
                ps5.setString(2,Old_deptid);                
                ps5.setString(3,mdataID);                
                ps5.executeUpdate();
                ps5.close();                
                note=note+" with Dept change....";
            }
            
            // insert before update data to history table
            String strperson9="insert into history(dept,date,note,id,emp_name,emp_designation)values(?,sysdate(),?,?,?,?)";
            PreparedStatement ps9=con.prepareStatement(strperson9);
            ps9.setString(1,dept1);
            ps9.setString(2,note);
            ps9.setString(3,id1);
            ps9.setString(4,emp_name1);
            ps9.setString(5,emp_designation1);
            ps9.addBatch();
            ps9.executeBatch();
            ps9.close();
            con.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }     
    }

    
    
    
    @Override
    public boolean updateProduct(EmpBean eBean) {
        
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            String strperson1="update mbuydata set memo=?, cost=?, supplier=?, buydate=?, prdtlife=?, suplrwrnty=? where pid=?";
            PreparedStatement ps1=con.prepareStatement(strperson1);
           
             ps1.setString(1,eBean.getMemo());
             ps1.setString(2,eBean.getCost());
             ps1.setString(3,eBean.getSupplier());
             ps1.setString(4,eBean.getBuydate());
             ps1.setString(5,eBean.getPrdtlife());
             ps1.setString(6,eBean.getSuplrwrnty());
             ps1.setInt(7,eBean.getPid());
             ps1.executeUpdate();
             ps1.close();

             con.close();
             return true;
        }catch(SQLException e){
             e.printStackTrace();
             return false;
        }
    }

    @Override
    public EmpBean getProduct(int pid) {                                        // get specific product by by pid(product ID) to Update Product 
        EmpBean eBean = null;
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return eBean;
            }
            String sql = "select * from mbuydata where pid='" + pid + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setMemo(rs.getString("memo"));

                eBean.setCost(rs.getString("cost"));
                eBean.setSupplier(rs.getString("supplier"));
                eBean.setBuydate(rs.getDate("buydate").toString());
                eBean.setSuplrwrnty(rs.getString("suplrwrnty"));
                eBean.setPrdtlife(rs.getString("prdtlife"));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return eBean;
    }

    @Override
    public boolean saveAdmn(adminBean aBean) {
         try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
             String strperson1="insert into admin(aname,pass,rights)values(?,?,?)";
             PreparedStatement ps1=con.prepareStatement(strperson1);
             ps1.setString(1,aBean.getAname());
             ps1.setString(2,aBean.getPassword());
             ps1.setString(3,aBean.getRight());
             ps1.addBatch();
             ps1.executeBatch();
             ps1.close();
          
             return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    
    
    
    @Override
    public boolean upAdmn(adminBean aBean) {
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            String strperson1="update admin set aname=?, pass=?, rights=?  where aname=?";
            PreparedStatement ps1=con.prepareStatement(strperson1);
            ps1.setString(1,aBean.getAname());
            ps1.setString(2,aBean.getPassword());
            ps1.setString(3,aBean.getRight());
            ps1.setString(4,aBean.getAname());
            ps1.executeUpdate();
            ps1.close();             
            con.close();
            return true;
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    
    @Override
    public boolean changePass(adminBean aBean){
        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
            if(aBean.getPassword().equals(ckCurrentPass(aBean.getEmp_id()))){
                String sql="update admin set aname=?, pass=? where emp_id=?";
                PreparedStatement ps1=con.prepareStatement(sql);
                ps1.setString(1, aBean.getAname());
                ps1.setString(2, aBean.getConfrmPass());
                ps1.setString(3, aBean.getEmp_id());
                ps1.executeUpdate();
                ps1.close();             
                con.close();
                return true;
            }else{
                return false;
            }            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    
    public String ckCurrentPass(String emp_id){
        String pass = "";
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                pass ="";
            }
            String sql = "select pass from admin where emp_id='" + emp_id + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pass = rs.getString("pass");
            }
            st.close();
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return pass;
    }
    
    
    
    
    

    @Override
    public adminBean getAdmn(String aname) {
        adminBean aBean=null;
       
      try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return aBean;
            }
            String sql = "select * from admin where aname='"+aname+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while(rs.next())
            {
                
                aBean = new adminBean();
                //eBean.setPid(rs.getString("pid"));
                aBean.setAname(rs.getString("aname"));
                aBean.setPassword(rs.getString("pass"));

                aBean.setRight(rs.getString("rights"));
                
                
            }
            
           
            st.close();
            con.close();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

      return aBean;
    }

    @Override
    public boolean savePrinter(EmpBean eBean) {
        
    try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }
             
            String d=eBean.getDept().trim();
            //String[] e=d.split(" ");
            String e=d.substring(d.indexOf(" ") + 1);
            
            System.out.println("dept..........."+e);
            Statement statement1 = con.createStatement();
            ResultSet resultSet1 = statement1.executeQuery("select dept_id from deptlist where dept='"+d+"';");
            resultSet1.next();
            String t1= resultSet1.getString("dept_id");
            
            System.out.println("dept"+t1);
            
            
           
            String p=null, t, id=null;
            
            String q1 = null;

            Statement statement10 = con.createStatement();
                //count the total no of a perticular dept in mdata table and add 1 to it to get the deptwise serial number  
                ResultSet resultSet10 = statement10.executeQuery("select (count(mdata.fklid) +1) as tag from mdata ; ");
                resultSet10.next();
                t= resultSet10.getString("tag");
                resultSet10.close();
                
                System.out.println("tag"+t);
             
                String TagCount=eCheck.getTagNumber();
             

            //String q="0000".substring(t.length()) + t; // to create format like 0001
            //String q1="00".substring(t1.length()) + t1; // to create format like 01
            String q=StringUtils.leftPad(TagCount, 5,"0"); // to create format like 0001
            //String q1=StringUtils.leftPad(t1, 2,"0");// to create format like 01 
            //String t= "FKL-"+Year.now().getValue()+"-"+Integer.toString(uniqueID);
            Calendar calendar = Calendar.getInstance();
            java.sql.Date now = new java.sql.Date(calendar.getTime().getTime());
            int year = now.getYear();
            String strentryyear = String.valueOf(year).substring(1, 3);
            p = "FKL." + strentryyear + "." + q; // final formatted tag eg. FKL.17.00001
            //resultSet1.close();
            System.out.println("The Final tag no : " + p);
            id=eBean.getMtype()+q;//formatted virtual id for printer
            System.out.println(p);
            System.out.println("formatted virtual id for printer: "+id);
            
            String strperson5="insert into mbuydata(memo,supplier,cost,prdtlife,suplrwrnty,buydate)values(?,?,?,?,?,?)";
            PreparedStatement ps5=con.prepareStatement(strperson5);            
             ps5.setString(1,eBean.getMemo());//             
             ps5.setString(2,eBean.getSupplier());
             ps5.setString(3,eBean.getCost());
             ps5.setString(4,eBean.getPrdtlife());
             ps5.setString(5,eBean.getSuplrwrnty());
             ps5.setString(6,eBean.getBuydate());             
             ps5.addBatch();
             ps5.executeBatch();
             ps5.close();
            
            Statement statement2 = con.createStatement();
            ResultSet resultSet2 = statement2.executeQuery("select pid  from mbuydata order by pid desc limit 0,1;");//collects the last/latest pid  in table
            resultSet2.next();
            String pid= resultSet2.getString("pid");
            resultSet2.close();

            String strperson2="insert into mdata(fklid,ip,mtype,dept_id,pid,id,img_date,img_loc,remarks,monitor_desc) values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps2=con.prepareStatement(strperson2);
            ps2.setString(1,p);
            ps2.setString(2,eBean.getIp());                          
            ps2.setString(3,eBean.getMtype());
            ps2.setString(4,t1);
            ps2.setString(5,pid);
            ps2.setString(6,id);
            ps2.setString(7,eBean.getImgdate());
            ps2.setString(8,eBean.getImgloc());
            ps2.setString(9,eBean.getRemarks());
            ps2.setString(10,eBean.getMonitor_desc());
            ps2.addBatch();
            ps2.executeBatch();
            ps2.close();

            String strperson3="insert into masgndata(id,fklid,mid,pcstatus,nstatus,asgn_update_date,handover_date,pid)values(?,?,?,?,?,sysdate(),?,?)";
            PreparedStatement ps3=con.prepareStatement(strperson3);            
            ps3.setString(1,id);
            ps3.setString(2,p);
            ps3.setString(3,eBean.getMid());
            ps3.setString(4,eBean.getPcstatus());
            ps3.setString(5,eBean.getNstatus());
            ps3.setString(6,eBean.getHdate());
            ps3.setString(7,pid);
            ps3.addBatch();
            ps3.executeBatch();
            ps3.close();

            String strperson9="insert into history(id,fklid,ip,mtype,action_by_user,note,dept,remarks,date)values(?,?,?,?,?,'insert',?,?,sysdate())";
            PreparedStatement ps9=con.prepareStatement(strperson9);            
            ps9.setString(1,id);
            ps9.setString(2,p);
            ps9.setString(3,eBean.getIp());
            ps9.setString(4,eBean.getMtype());
            ps9.setString(5,eBean.getName());
            ps9.setString(6,eBean.getDept());
            ps9.setString(7,eBean.getRemarks());
            ps9.addBatch();
            ps9.executeBatch();
            ps9.close();          

            String strperson1="insert into empdata(id,dept,date)values(?,?,sysdate())";
            PreparedStatement ps1=con.prepareStatement(strperson1);
            ps1.setString(1,id);             
            ps1.setString(2,d);            
            ps1.addBatch();
            ps1.executeBatch();
            ps1.close();                          
            String strperson6="insert into logtag(fklid,pid,handover_date)values(?,?,?)";
            PreparedStatement ps6=con.prepareStatement(strperson6);
            ps6.setString(1,p);
            ps6.setString(2,pid);             
            ps6.setString(3,eBean.getHdate());
            ps6.addBatch();
            ps6.executeBatch();
            ps6.close();                          
            String strperson4="insert into logdata(fklid,ip,date,activity)values(?,?,sysdate(),?)";
            PreparedStatement ps4=con.prepareStatement(strperson4);
            ps4.setString(1,p);
            ps4.setString(2,eBean.getIp());                         
            ps4.setString(3,"Assign entry");
            ps4.addBatch();
            ps4.executeBatch();
            ps4.close();
            return true;                
        }catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    
    

    @Override
    public List<EmpBean> getPrinter(){     
        List<EmpBean> eBeans=new ArrayList<EmpBean>();
         try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBeans;
            }
            String sql = "select * from empdata, mdata, masgndata where (mdata.fklid=masgndata.fklid) and (masgndata.id=empdata.id) and (empdata.emp_name is null and empdata.emp_designation is null);";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            EmpBean eBean;            
            while(rs.next())
            {
                eBean = new EmpBean();                
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setDept(rs.getString("dept"));
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));
                eBean.setFklid(rs.getString("fklid"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getDate("asgn_update_date").toString());
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));                
                eBeans.add(eBean);
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
      return eBeans;        
    }
    
    
    
    
    
    

    @Override
    public EmpBean getPrinter2(int pid){        
        EmpBean eBean=null;
        try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBean;
            }
            String sql ="SELECT\n" +
                        "  *,\n" +
                        " IFNULL((SELECT image_upload.image FROM image_upload WHERE image_upload.fkl_tag = md.fklid), 'N/A') AS images\n" +
                        "FROM\n" +
                        "   empdata emp\n" +
                        "JOIN\n" +
                        "   masgndata msg\n" +
                        "ON\n" +
                        "  (emp.id = msg.id)\n" +
                        "JOIN\n" +
                        "   mdata md\n" +
                        "ON\n" +
                        "  (md.fklid = msg.fklid)\n" +
                        "WHERE\n" +
                        "   md.pid = '"+pid+"'\n" +
                        " ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setDept(rs.getString("dept"));
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));
                eBean.setFklid(rs.getString("fklid"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getDate("asgn_update_date").toString());
                eBean.setHdate(rs.getString("handover_date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                Blob ph = rs.getBlob("images");
                byte[] encodedBytes = Base64.encodeBase64(ph.getBytes(1, (int) ph.length()));
                StringBuilder imageString = new StringBuilder();
                imageString.append("data:image/png;base64,");
                imageString.append(new String(encodedBytes));
                eBean.setImages(imageString.toString());
            }
            st.close();
            con.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return eBean;
    }
    
    

    
    
    
    @Override
    public boolean deleteEmp(String id) {
        
        boolean status=false;
        
        try
        {
          Connection con = DBconnection.getConnection();
                if(con == null)
                {
                    return status;                    
                }

           //get the existing data before update
                String dept1=null,id1=null,emp_name1=null,emp_designation1=null,idStatus=null,note="Employee Delete";
                
                String sql11 = "select * from empdata where id='"+id+"'";
                Statement st11 = con.createStatement();
                ResultSet rs11 = st11.executeQuery(sql11);
                
                while(rs11.next())
                {
                    //eBean = new EmpBean();
                  dept1=rs11.getString("dept");
                  id1=rs11.getString("id");
                  emp_name1=rs11.getString("emp_name");
                  emp_designation1=rs11.getString("emp_designation");
                  
                }
                st11.close();
                
                
                
          // create the mysql delete statement.
         
          String query = "delete from empdata where id = ?";
          PreparedStatement preparedStmt = con.prepareStatement(query);
          preparedStmt.setString(1,id);

          // execute the preparedstatement
          preparedStmt.execute();
          
          // insert before update data to history table
            String strperson9="insert into history(dept,date,note,id,emp_name,emp_designation)values(?,sysdate(),?,?,?,?)";
            PreparedStatement ps9=con.prepareStatement(strperson9);

            ps9.setString(1,dept1);

            ps9.setString(2,note);

            ps9.setString(3,id1);
            ps9.setString(4,emp_name1);
            ps9.setString(5,emp_designation1);
            ps9.addBatch();
            ps9.executeBatch();
            ps9.close();  

          status=true;

        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
        
        
        return status;
    }

    @Override
    public boolean deleteMdata(String fklid, String remarks, String pcstatus, String sessionName) {
        boolean status = false;
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return status;
            }
            ippc = InetAddress.getLocalHost();
            //get the existing data before update
            String fklid1 = null, ip1 = null, mid1 = null, mtype1 = null, dept1 = null, img_date1 = null, img_loc1 = null, pcstatus1 = null, nstatus1 = null, hdd1 = null, mboard1 = null, ram1 = null, chip1 = null, id1 = null, emp_name1 = null, emp_designation1 = null, remarks1 = null, note = null, hand_date1 = null;
            int pid1 = 0;
            String sql11 = "select * from empdata, mdata, masgndata where mdata.fklid=masgndata.fklid and masgndata.id=empdata.id and mdata.fklid='" + fklid + "'";
            Statement st11 = con.createStatement();
            ResultSet rs11 = st11.executeQuery(sql11);

            while (rs11.next()) {
                //eBean = new EmpBean();
                pid1 = rs11.getInt("pid");
                dept1 = rs11.getString("dept");
                mid1 = rs11.getString("mid");
                ip1 = rs11.getString("ip");
                fklid1 = rs11.getString("fklid");
                pcstatus1 = rs11.getString("pcstatus");
                nstatus1 = rs11.getString("nstatus");
                mtype1 = rs11.getString("mtype");
                img_date1 = rs11.getString("img_date");
                img_loc1 = rs11.getString("img_loc");
                hdd1 = rs11.getString("hdd");
                ram1 = rs11.getString("ram");
                mboard1 = rs11.getString("mboard");
                chip1 = rs11.getString("chip");
                id1 = rs11.getString("id");
                emp_name1 = rs11.getString("emp_name");
                emp_designation1 = rs11.getString("emp_designation");
                remarks1 = rs11.getString("remarks");
                hand_date1 = rs11.getString("handover_date");
            }
            st11.close();

            //update mdata,masgndata 
            String strperson3 = "update mdata set ip=?, hdd=?, mboard=?, ram =?, chip=?, mtype=?,  dept_id=?, img_date=?, img_loc=?, remarks=?, id=? where fklid=?";
            PreparedStatement ps2 = con.prepareStatement(strperson3);
            ps2.setString(1, "DELETED");
            ps2.setString(2, "DELETED");
            ps2.setString(3, "DELETED");
            ps2.setString(4, "DELETED");
            ps2.setString(5, "DELETED");
            ps2.setString(6, "DELETED");
            ps2.setString(7, "DELETED");
            ps2.setString(8, "DELETED");
            ps2.setString(9, "DELETED");
            ps2.setString(10, "DELETED");
            ps2.setString(11, "DELETED");
            ps2.setString(12, fklid);
            //ps2.setString(13,fklid);

            ps2.executeUpdate();
            ps2.close();

            String strperson = "update masgndata set id=?,  mid=?, pcstatus=?, nstatus=?, asgn_update_date=sysdate(), handover_date=?, inactive=? where fklid=? ";
            PreparedStatement ps8 = con.prepareStatement(strperson);
            ps8.setString(1, "DELETED");
            ps8.setString(2, "DELETED");
            ps8.setString(3, "DELETED");
            ps8.setString(4, "DELETED");
            ps8.setString(5, "DELETED");
            ps8.setString(6, "YES");
            ps8.setString(7, fklid);
            ps8.executeUpdate();
            ps8.close();

            // insert deleted data to history table
            String strperson9 = "insert into history(fklid,ip,mid,mtype,dept,pid,img_date,img_loc,pcstatus,nstatus,date,remarks,note,hdd,ram,mboard,chip,id,emp_name,emp_designation,handover_date, action_by_user, action_take_by_pc)values(?,?,?,?,?,?,?,?,?,?,sysdate(),?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps9 = con.prepareStatement(strperson9);
            ps9.setString(1, fklid1);
            ps9.setString(2, ip1);
            ps9.setString(3, mid1);
            ps9.setString(4, mtype1);
            ps9.setString(5, dept1);

            ps9.setInt(6, pid1);
            ps9.setString(7, img_date1);
            ps9.setString(8, img_loc1);
            ps9.setString(9, pcstatus);
            ps9.setString(10, nstatus1);
            ps9.setString(11, remarks);

            ps9.setString(12, "Delete");
            ps9.setString(13, hdd1);
            ps9.setString(14, ram1);
            ps9.setString(15, mboard1);
            ps9.setString(16, chip1);
            ps9.setString(17, id1);
            ps9.setString(18, emp_name1);
            ps9.setString(19, emp_designation1);
            ps9.setString(20, hand_date1);
            ps9.setString(21, sessionName);
            ps9.setString(22, ippc.getHostAddress());
            ps9.addBatch();
            ps9.executeBatch();
            ps9.close();

            status = true;

        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return status;
    }
    
    
    

    @Override
    public boolean deletePdata(String fklid, String remarks, String pcstatus, String id, String sessionName) {
        
        boolean status=false;
        try
        {
          Connection con = DBconnection.getConnection();
                if(con == null)
                {
                    return status;           
                }
                //get the existing data before update
                String fklid1=null,ip1=null,mid1=null,mtype1=null,dept1=null,img_date1=null,img_loc1=null,pcstatus1=null,nstatus1=null,hdd1=null,mboard1=null,ram1=null,chip1=null,id1=null,emp_name1=null,emp_designation1=null,remarks1=null,note=null,hand_date1=null;
                int pid1=0;
                String sql11 = "select * from empdata, mdata, masgndata where mdata.fklid=masgndata.fklid and masgndata.id=empdata.id and mdata.fklid='"+fklid+"'";
                Statement st11 = con.createStatement();
                ResultSet rs11 = st11.executeQuery(sql11);
                
                while(rs11.next())
                {
                    //eBean = new EmpBean();
                  pid1=rs11.getInt("pid");

                  dept1=rs11.getString("dept");

                  mid1=rs11.getString("mid");
                  ip1=rs11.getString("ip");

                  fklid1=rs11.getString("fklid");

                  pcstatus1=rs11.getString("pcstatus");
                  nstatus1=rs11.getString("nstatus");
                  mtype1=rs11.getString("mtype");

                  img_date1=rs11.getString("img_date");
                  img_loc1=rs11.getString("img_loc");
                  hdd1=rs11.getString("hdd");
                  ram1=rs11.getString("ram");
                  mboard1=rs11.getString("mboard");
                  chip1=rs11.getString("chip");
                  id1=rs11.getString("id");
                  emp_name1=rs11.getString("emp_name");
                  emp_designation1=rs11.getString("emp_designation");
                  remarks1=rs11.getString("remarks");
                  hand_date1=rs11.getString("handover_date");

                }
                st11.close(); 

          //update mdata,masgndata 
                String strperson3="update mdata set ip=?, hdd=?, mboard=?, ram =?, chip=?, mtype=?,  dept_id=?, img_date=?, img_loc=?, remarks=?, id=? where fklid=?";
                PreparedStatement ps2=con.prepareStatement(strperson3);
                ps2.setString(1,"DELETED");
                ps2.setString(2,"DELETED");
                ps2.setString(3,"DELETED");
                ps2.setString(4,"DELETED");
                ps2.setString(5,"DELETED");
                ps2.setString(6,"DELETED");
                ps2.setString(7,"DELETED");
                ps2.setString(8,"DELETED");
                ps2.setString(9,"DELETED");
                ps2.setString(10,"DELETED");
                ps2.setString(11,"DELETED");
                ps2.setString(12,fklid);
                //ps2.setString(13,fklid);

                ps2.executeUpdate();
                ps2.close();



                 String strperson="update masgndata set id=?,  mid=?, pcstatus=?, nstatus=?, asgn_update_date=sysdate(), handover_date=?, inactive=? where fklid=? ";
                    PreparedStatement ps8=con.prepareStatement(strperson);
                    ps8.setString(1,"DELETED");
                    ps8.setString(2, "DELETED");
                    ps8.setString(3,"DELETED");
                    ps8.setString(4,"DELETED");
                    ps8.setString(5,"DELETED");
                    ps8.setString(6,"YES");
                    ps8.setString(7,fklid);
                    ps8.executeUpdate();
                    ps8.close();
          
          
          
            ippc = InetAddress.getLocalHost();
            // insert deleted data to history table
            String strperson9="insert into history(fklid,ip,mid,mtype,dept,pid,img_date,img_loc,pcstatus,nstatus,date,remarks,note,hdd,ram,mboard,chip,id,emp_name,emp_designation,handover_date, action_by_user,action_take_by_pc)values(?,?,?,?,?,?,?,?,?,?,sysdate(),?,?,?,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement ps9=con.prepareStatement(strperson9);
                 ps9.setString(1,fklid1);
                 ps9.setString(2,ip1);
                 ps9.setString(3,mid1);
                 ps9.setString(4,mtype1);
                 ps9.setString(5,dept1);
                 
                 ps9.setInt(6,pid1);
                 ps9.setString(7,img_date1);
                 ps9.setString(8,img_loc1);
                 ps9.setString(9,pcstatus);
                 ps9.setString(10,nstatus1);
                 ps9.setString(11,remarks);
                 
                 ps9.setString(12,"Delete");
                 ps9.setString(13,hdd1);
                 ps9.setString(14,ram1);
                 ps9.setString(15,mboard1);
                 ps9.setString(16,chip1);
                 ps9.setString(17,id1);
                 ps9.setString(18,emp_name1);
                 ps9.setString(19,emp_designation1);
                 ps9.setString(20,hand_date1);
                 ps9.setString(21, sessionName);
                 ps9.setString(22, ippc.getHostAddress());
                 
                 ps9.addBatch();
                 ps9.executeBatch();
                 ps9.close();  
          
        
                 
                 
         String query3 = "delete from empdata where id = ?";
          PreparedStatement preparedStmt3 = con.prepareStatement(query3);
          preparedStmt3.setString(1,id);

          // execute the preparedstatement
          preparedStmt3.execute();
                 
          
          
          
          status=true;
          
          
          
          


        }
        catch (Exception e)
        {
          System.err.println("Got an exception! ");
          System.err.println(e.getMessage());
        }
        
        
        return status;
        
        
    }

    @Override
    public boolean saveDeptSettings(EmpBean eBean) {                            // note: don't understand full functionality
        try {
            Connection con = DBconnection.getConnection();
            if (con == null) {
                return false;
            }
            System.out.println(eBean.getnDeptCode());
            int x = eCheck.checkNdeptId(eBean.getnDeptCode());

            if (x > 0) {
                String strperson1 = "insert into deptlist(dept_id,dept)values(?,?)";
                PreparedStatement ps1 = con.prepareStatement(strperson1);
                ps1.setString(1, eBean.getnDeptCode());
                ps1.setString(2, eBean.getnDept());

                ps1.addBatch();
                ps1.executeBatch();
                ps1.close();
                return true;
            } else {
                String strperson1 = "insert into main_deptlist(dept_id,dept_name)values(?,?)";
                PreparedStatement ps1 = con.prepareStatement(strperson1);
                ps1.setString(1, eBean.getnDeptCode());
                ps1.setString(2, eBean.getnDept());

                ps1.addBatch();
                ps1.executeBatch();
                ps1.close();

                String strperson2 = "insert into deptlist(dept_id,dept)values(?,?)";
                PreparedStatement ps2 = con.prepareStatement(strperson2);
                ps2.setString(1, eBean.getnDeptCode());
                ps2.setString(2, eBean.getnDept());
                ps2.addBatch();
                ps2.executeBatch();
                ps2.close();

                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveMtypeSettings(String mtype) {

        try{
            Connection con=DBconnection.getConnection();
            if(con==null){
                return false;
            }  
            String strperson1="insert into item_type(mtype)values(?)";
            PreparedStatement ps1=con.prepareStatement(strperson1);
            ps1.setString(1,mtype);
            
            ps1.addBatch();
            ps1.executeBatch();
            ps1.close();
            return true;
            
            } catch (SQLException e) {
             e.printStackTrace();
            return false;
         }
            
            
             
        
        
        
        
    }
    
    
    
    @Override
    public EmpBean getTagData(String fklid) {
       EmpBean eBean=null;
     try {
            Connection con = DBconnection.getConnection();
            if(con == null)
            {
                return eBean;
            }
            String sql = "select * from empdata, mdata, masgndata where mdata.fklid=masgndata.fklid and masgndata.id=empdata.id and mdata.fklid='"+fklid+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next())
            {
                eBean = new EmpBean();
                eBean.setPid(rs.getInt("pid"));
                eBean.setId(rs.getString("id"));
                eBean.setName(rs.getString("emp_name"));
                eBean.setDesignation(rs.getString("emp_designation"));
                eBean.setDept(rs.getString("dept"));                
                eBean.setMid(rs.getString("mid"));
                eBean.setIp(rs.getString("ip"));                
                eBean.setFklid(rs.getString("fklid"));
                eBean.setHdd(rs.getString("hdd"));
                eBean.setMboard(rs.getString("mboard"));                
                eBean.setRam(rs.getString("ram"));
                eBean.setChip(rs.getString("chip"));
                eBean.setPcstatus(rs.getString("pcstatus"));
                eBean.setNstatus(rs.getString("nstatus"));
                eBean.setMtype(rs.getString("mtype"));
                eBean.setDate(rs.getString("date"));
                eBean.setHdate(rs.getString("handover_date"));
                //eBean.setDate(rs.getString("date"));
                eBean.setImgdate(rs.getString("img_date"));
                eBean.setImgloc(rs.getString("img_loc"));
                eBean.setRemarks(rs.getString("remarks"));
                eBean.setPvs_extension(rs.getString("pvs_extension"));
            }
            st.close();
            con.close();
        } catch (SQLException ex) {
           
            ex.printStackTrace();
        }

      return eBean;
    }
    
 
}
