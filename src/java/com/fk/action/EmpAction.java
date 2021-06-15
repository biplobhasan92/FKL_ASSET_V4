/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */

package com.fk.action;

import com.fk.bean.EmpBean;
import com.fk.bean.adminBean;
import com.fk.bean.userBean;
import com.fk.database.DBconnection;
import com.fk.manager.EmpManager;
import com.fk.manager.impl.EmpManagerImpl;
import com.fk.manager.impl.EmpManagerCheck;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.Year;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.xwork.StringUtils;



public class EmpAction extends ActionSupport implements ModelDriven<EmpBean>{

    private EmpBean eBean=new EmpBean();
    private EmpManager eManager= new EmpManagerImpl();
    private EmpManagerCheck eCheck= new EmpManagerCheck();
    public String p = null;
    public String r = null;
    public String x = null;
    public int a = 0;
    private static final AtomicInteger count = new AtomicInteger(0);
    MenuAction eAction=new MenuAction();
    public List deptList = new ArrayList();
    public List availableTagList = new ArrayList();
    public HttpServletRequest request;
    public HttpServletResponse response;
    public HttpSession session;
    
    
    Calendar calendar = Calendar.getInstance();
    java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
    private List productList = new ArrayList();
    
    
    public List getProductList() {
        return productList;
    }

    public void setProductList(List productList) {

        try {
            Connection con = DBconnection.getConnection();
            String sql = "select distinct mtype from item_type";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                productList.add(rs.getString("mtype"));
            }

            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public List getAvailableTagList() {                                         //   TO SHOW AVAILABLE TAG IN DROPDOWN LIST FORM 
        return availableTagList;
    }

    public void setAvailableTagList(List availableTagList) {                    //  TO SHOW AVAILABLE TAG IN DROPDOWN LIST FORM 

        try {
            Connection con = DBconnection.getConnection();
            String sql = "select fklid from mdata where mdata.fklid not in( select fklid from masgndata )";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                availableTagList.add(rs.getString("fklid"));
            }

            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    

    public List getDeptList() {                                                 //for generate dropdown list for dept field
        return deptList;
    }

    public void setDeptList(List deptList) {                                    //for generate dropdown list for dept field

        try {
            Connection con = DBconnection.getConnection();

            String sql = "select distinct dept from deptlist";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                deptList.add(rs.getString("dept"));
            }

            st.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public String showPerson() {
        List<EmpBean> eBeanList = eManager.getAllperson();
        eBean.seteBeans(eBeanList);
        return "success";
    }
    
    public String viewPerson(){
        List<EmpBean> eBeanList = eManager.getAllperson2();
        eBean.seteBeans(eBeanList);
        return "success";
    }



    public String updateData(){
        
        
        System.out.println(".. updateData()... ");
        
        EmpBean pb = eManager.getPerson(eBean.getPid());
        eBean.setPid(pb.getPid());
        eBean.setId(pb.getId());
        eBean.setName(pb.getName());
        eBean.setDesignation(pb.getDesignation());
        eBean.setDept(pb.getDept());
        eBean.setIp(pb.getIp());
        eBean.setMid(pb.getMid());
        eBean.setFklid(pb.getFklid());
        eBean.setHdd(pb.getHdd());
        eBean.setMboard(pb.getMboard());
        eBean.setRam(pb.getRam());
        eBean.setChip(pb.getChip());
        eBean.setPcstatus(pb.getPcstatus());
        eBean.setNstatus(pb.getNstatus());
        eBean.setMtype(pb.getMtype());
        eBean.setHdate(pb.getHdate());
        eBean.setImgdate(pb.getImgdate());
        eBean.setImgloc(pb.getImgloc());
        eBean.setRemarks(pb.getRemarks());
        eBean.setMonitor_desc(pb.getMonitor_desc());
        eBean.setPvs_extension(pb.getPvs_extension());
        eBean.setImages(pb.getImages());
        List<EmpBean> eBeanList = eManager.getAllperson();
        eBean.seteBeans(eBeanList);
        setDeptList(this.deptList);
        setProductList(this.productList);

        String mtype = eBean.getMtype();
        return "success";

    }
  
    
    
    
    
    
    public String searchData(){
        
        if((eBean.getId() == null || eBean.getId().trim().isEmpty()) && (eBean.getIp() == null || eBean.getIp().trim().isEmpty()))
        {
            eBean.setMessage2("Enter ID or IP");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return  "error";
        }
        
       
        if((eBean.getIp().trim().isEmpty()) && (eBean.getId().trim().isEmpty()==false)){        
            String id;
            if(eBean.getId().length()<6){
                id=StringUtils.leftPad(eBean.getId(), 6,"0");
            }else{
                id=eBean.getId();
            }
            int x1=eCheck.checkId(id);
            if (x1>1){
                List<EmpBean> eBeanList = eManager.getAllperson4(id);
                eBean.seteBeans(eBeanList);
                eBean.setMessage("Multiple Resource have found against this id! ");
                setDeptList(this.deptList);
                setProductList(this.productList);
                return "fail";
            }
        else{
            EmpBean pb=eManager.getPerson3(id);
            if (pb==null){
                eBean.setMessage2("This id not exists....");
                setDeptList(this.deptList);
                setProductList(this.productList);
                return "error";
            }else{
                eBean.setId(pb.getId());
                eBean.setName(pb.getName());
                eBean.setDesignation(pb.getDesignation());
                eBean.setDept(pb.getDept());
                eBean.setIp(pb.getIp());
                eBean.setMid(pb.getMid());
                eBean.setFklid(pb.getFklid());
                eBean.setHdd(pb.getHdd());
                eBean.setMboard(pb.getMboard());
                eBean.setRam(pb.getRam());
                eBean.setChip(pb.getChip());
                eBean.setPid(pb.getPid());
                eBean.setPcstatus(pb.getPcstatus());
                eBean.setNstatus(pb.getNstatus());
                eBean.setMtype(pb.getMtype());
                eBean.setHdate(pb.getHdate());
                eBean.setImgdate(pb.getImgdate());
                eBean.setImgloc(pb.getImgloc());
                eBean.setRemarks(pb.getRemarks());    
                eBean.setPvs_extension(pb.getPvs_extension());
                eBean.setMonitor_desc(pb.getMonitor_desc());
                eBean.setImages(pb.getImages());
                List<EmpBean> eBeanList = eManager.getAllperson();
                eBean.seteBeans(eBeanList);
                setDeptList(this.deptList);
                setProductList(this.productList);
                return "success";          
            }
        }
    }
       
       
       
       if((eBean.getIp().trim().isEmpty()==false) && (eBean.getId().trim().isEmpty()))// search with ip
        {
            EmpBean pb=eManager.getPerson4(eBean.getIp());
         
            if(pb==null) {
                eBean.setMessage2("This ip not exists....");
                setDeptList(this.deptList);
                setProductList(this.productList);
                return "error";
            }else{
                eBean.setId(pb.getId());
                eBean.setName(pb.getName());
                eBean.setDesignation(pb.getDesignation());
                eBean.setDept(pb.getDept());
                eBean.setIp(pb.getIp());
                eBean.setMid(pb.getMid());
                eBean.setFklid(pb.getFklid());
                eBean.setHdd(pb.getHdd());
                eBean.setMboard(pb.getMboard());
                eBean.setRam(pb.getRam());
                eBean.setChip(pb.getChip());
                eBean.setPid(pb.getPid());
                eBean.setPcstatus(pb.getPcstatus());
                eBean.setNstatus(pb.getNstatus());
                eBean.setMtype(pb.getMtype());
                eBean.setHdate(pb.getHdate());
                eBean.setImgdate(pb.getImgdate());
                eBean.setImgloc(pb.getImgloc());
                eBean.setPvs_extension(pb.getPvs_extension());
                List<EmpBean> eBeanList = eManager.getAllperson();
                eBean.seteBeans(eBeanList);
                setDeptList(this.deptList);
                setProductList(this.productList);            
                return "success";
            }
        }
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";    
       }
 
    public String searchEmpData(){
       if(eBean.getId() == null || eBean.getId().trim().isEmpty())
        {
            eBean.setMessage2("Enter ID");
            setDeptList(this.deptList);
            return  "fail";
        }
       
         // to make inputed id in 6 digit if it is less then 6 digit
            String id;
            
            if(eBean.getId().length()<6){
                //id="000000".substring(eBean.getId().length()) + eBean.getId();
                id=StringUtils.leftPad(eBean.getId(), 6,"0");
            }else{
                id=eBean.getId();
            }
    

            
         EmpBean pb=eManager.getPerson2(id);
         
         if (pb==null) {
             
             eBean.setMessage2("This id not exists....");
             setDeptList(this.deptList);
             return "fail";
            
        } else {
             
             
             eBean.setId(pb.getId());
          eBean.setName(pb.getName());
          eBean.setDesignation(pb.getDesignation());
          eBean.setDept(pb.getDept());
          



          List<EmpBean> eBeanList = eManager.getAllperson();
            eBean.seteBeans(eBeanList);
            setDeptList(this.deptList);
            
           return "success";
           
        }
  
       }
    
 
    @Override
    public EmpBean getModel() {

        return  eBean;
    }
    
    
    private void clear()
    {
        
        //eBean.setPoid("");
        eBean.setId("");
        eBean.setName("");
        eBean.setDesignation("");
        eBean.setDept("");
        eBean.setFklid("");
        eBean.setMid("");
        eBean.setIp("");
        //eBean.setPid();
        eBean.setChip("");
        eBean.setMboard("");
        eBean.setHdd("");
        eBean.setRam("");
        eBean.setMtype("");
        
        //eBean.setDescription("");
        eBean.setPcstatus("");
        eBean.setNstatus("");
        eBean.setImgdate("");
        eBean.setImgloc("");
        eBean.setBuydate("");
        eBean.setHdate("");
        eBean.setMemo("");
        eBean.setCost("");
        eBean.setPrdtlife("");
        eBean.setSuplrwrnty("");
        eBean.setSupplier("");
        
    }
   
   
   public String updateEntry2(){
       
       
       if(eBean.getId() == null || eBean.getId().trim().isEmpty())
        {
            eBean.setMessage2("Enter ID");
            setDeptList(this.deptList);
             setProductList(this.productList);
            return  "fail";
        }
       
       if(eBean.getIp() == null || eBean.getIp().trim().isEmpty())
        {
            eBean.setMessage2("Enter IP");
            setDeptList(this.deptList);
             setProductList(this.productList);
            return  "fail";
        }
       
       int i=eCheck.checkfkl(eBean.getIp(), eBean.getFklid());
       
       if (i==0) {
           
           eBean.setMessage2("IP Mismatch with Tag NO.");
           setDeptList(this.deptList);
            setProductList(this.productList);
           return "fail";
           
       } else {
       
        
                    boolean isUpdate = eManager.updateEditEntry2(eBean);
                    if(isUpdate)
                    {
                       List<EmpBean> eBeanList = eManager.getAllperson();
                        eBean.seteBeans(eBeanList);

                            eBean.setMessage2("Data Updated");
                            setDeptList(this.deptList);
                             setProductList(this.productList);
                            clear();
                            return "success";

                    }
                    else
                    {
                        //eBean.setMessage(" "+eBean.getId());
                            eBean.setMessage2("Unable to Update Data!!!");
                            setDeptList(this.deptList);
                             setProductList(this.productList);
                            return "fail";
                    }  
                
           }          
                    
    }
   
   
   public String updateEntry3() {

        if (eBean.getId() == null || eBean.getId().trim().isEmpty()) {
            eBean.setMessage2("Enter ID");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }

        boolean isUpdate = eManager.update1(eBean);
        if (isUpdate){
            List<EmpBean> eBeanList = eManager.getAllperson();
            eBean.seteBeans(eBeanList);
            eBean.setMessage2("Data Updated");
            setDeptList(this.deptList);
            setProductList(this.productList);
            clear();
            return "success";
        }else{
            eBean.setMessage2("Unable to Update Data!!!");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }
    }
   
   
   
   
   
   public String updateEntryP3(){
       
       System.out.println("Session Name : "+eBean.getName());
       
       int y=eCheck.checkUpdateMip(eBean.getIp(),eBean.getFklid()); 
        boolean isUpdate = eManager.update2(eBean);
        if(isUpdate)
        {
           List<EmpBean> eBeanList = eManager.getAllperson();
            eBean.seteBeans(eBeanList);

                eBean.setMessage2("Data Updated");
                setDeptList(this.deptList);
                 setProductList(this.productList);
                clear();
                return "success";

        }
        else
        {
            //eBean.setMessage(" "+eBean.getId());
                eBean.setMessage2("Unable to Update Data!!!");
                setDeptList(this.deptList);
                 setProductList(this.productList);
                return "fail";
        }  
                
                   
                    
    }
   
   
    public String searchM(){
       if(eBean.getFklid()== null || eBean.getFklid().trim().isEmpty())
        {
            eBean.setMessage2("Enter Tag No");
            setAvailableTagList(this.availableTagList);
            return  "fail";
        }
    

            
         EmpBean pb=eManager.getM(eBean.getFklid());
         
         if (pb==null) {
             
             eBean.setMessage2("This Tag not exists....");
             setAvailableTagList(this.availableTagList);
             return "fail";
            
        } else {
             
             
          eBean.setIp(pb.getIp());
          eBean.setFklid(pb.getFklid());
          //eBean.setMid(pb.getMid());
          eBean.setHdd(pb.getHdd());
          eBean.setMboard(pb.getMboard());
          eBean.setRam(pb.getRam());
          eBean.setChip(pb.getChip());
          eBean.setMtype(pb.getMtype());
          
          List<EmpBean> eBeanList = eManager.getAllpc();
          setAvailableTagList(this.availableTagList);
            eBean.seteBeans(eBeanList);
            
           return "success";
           
        }
  
       }
    
    
    
    
    public String searchM2(){
       if(eBean.getFklid()== null || eBean.getFklid().trim().isEmpty())
        {
            eBean.setMessage2("Enter Tag No");
            setAvailableTagList(this.availableTagList);
            return  "fail";
        }
       
       int x=eCheck.checkfkl2(eBean.getFklid());
          
         EmpBean pb=eManager.getM2(eBean.getFklid());
         
         if (pb==null) {
             
             eBean.setMessage2("This Tag not exists....");
             setAvailableTagList(this.availableTagList);
             return "fail";
            
        } else {
             
             
          eBean.setIp(pb.getIp());
          eBean.setFklid(pb.getFklid());
          //eBean.setMid(pb.getMid());
          eBean.setHdd(pb.getHdd());
          eBean.setMboard(pb.getMboard());
          eBean.setRam(pb.getRam());
          eBean.setChip(pb.getChip());
          eBean.setMtype(pb.getMtype());
          
          List<EmpBean> eBeanList = eManager.getAllpc();
            eBean.seteBeans(eBeanList);
            setAvailableTagList(this.availableTagList);
            
           return "success";
           
        }
  
       }
    
     public String searchM3(){
       if(eBean.getFklid()== null || eBean.getFklid().trim().isEmpty())
        {
            eBean.setMessage2("Select Tag No");
            setAvailableTagList(this.availableTagList);
            return  "fail";
        }
        
       int x=eCheck.checkfkl2(eBean.getFklid());
       
       
         if (x==0) {
              EmpBean pb=eManager.getM2(eBean.getFklid());
         
         if (pb==null) {
             
             eBean.setMessage2("This Tag not exists....");
             setAvailableTagList(this.availableTagList);
             return "fail";
            
        } else {
             
             
          eBean.setIp(pb.getIp());
          eBean.setFklid(pb.getFklid());
          //eBean.setMid(pb.getMid());
          eBean.setHdd(pb.getHdd());
          eBean.setMboard(pb.getMboard());
          eBean.setRam(pb.getRam());
          eBean.setChip(pb.getChip());
          eBean.setMtype(pb.getMtype());
          
          List<EmpBean> eBeanList = eManager.getAllpc();
            eBean.seteBeans(eBeanList);
            setAvailableTagList(this.availableTagList);
            
           return "success";
           
        }
             
         } else {
             
             eBean.setMessage2("This tag is already in use!");
             setAvailableTagList(this.availableTagList);
             return "fail";
             
             
         }
      
       }
     
    public String searchM4(){
       if(eBean.getFklid()== null || eBean.getFklid().trim().isEmpty())
        {
            eBean.setMessage2("Select Tag No");
            setAvailableTagList(this.availableTagList);
            return  "fail";
        }
      
       int x=eCheck.checkfkl2(eBean.getFklid());
       
       
         if (x==0) {
              EmpBean pb=eManager.getM(eBean.getFklid());
         
         if (pb==null) {
             
             eBean.setMessage2("This Tag not exists....");
             setAvailableTagList(this.availableTagList);
             return "fail";
            
        } else {
             
             
          eBean.setIp(pb.getIp());
          eBean.setFklid(pb.getFklid());
          //eBean.setMid(pb.getMid());
          eBean.setHdd(pb.getHdd());
          eBean.setMboard(pb.getMboard());
          eBean.setRam(pb.getRam());
          eBean.setChip(pb.getChip());
          eBean.setMtype(pb.getMtype());
          eBean.setId(pb.getId());
        
          List<EmpBean> eBeanList = eManager.getAllpc();
            eBean.seteBeans(eBeanList);
            setAvailableTagList(this.availableTagList);
            
           return "success";
           
        }
             
             
             
         } else {
             
             eBean.setMessage2("This tag is already in use!");
             setAvailableTagList(this.availableTagList);
             return "fail";
             
             
         }
       

       }
    
    public String updateM()
    {
               
            if(eBean.getIp()== null || eBean.getIp().trim().isEmpty())
            {
             eBean.setMessage2("Enter IP");
             setAvailableTagList(this.availableTagList);
            return  "fail";
             }


            int i= eCheck.checkUpdateMip(eBean.getIp(), eBean.getFklid());// check whether inputed ip is already used by another machine

            if (i>0) {

               eBean.setMessage2("This ip already used by another machine!"); 
               setAvailableTagList(this.availableTagList);
               return  "fail";

            } 
            else {

                boolean isUpdate = eManager.updateM(eBean);
                if(isUpdate)
                {
                   List<EmpBean> eBeanList = eManager.getAllpc();
                    eBean.seteBeans(eBeanList);

                        eBean.setMessage2("Data Updated");
                        setAvailableTagList(this.availableTagList);
                        clear();
                        return "success";

                }
                else
                {
                        eBean.setMessage2("Unable to Update Data!!!");
                        setAvailableTagList(this.availableTagList);
                        return "fail";
                }

            }
    }
    
    
    
    
    public String saveM1(){                                                     // update machine that already has tag 
        
         if(eBean.getIp()== null || eBean.getIp().trim().isEmpty())
                    {
                     eBean.setMessage2("Enter IP");
                     setAvailableTagList(this.availableTagList);
                    return  "fail";
                     }
        
        
        int x=eCheck.checkfkl2(eBean.getFklid());
        int y=eCheck.checkUpdateMip(eBean.getIp(),eBean.getFklid());
        int z=eCheck.checkId2(eBean.getId());
        boolean isSave= false;
        
        if (x>0) {                                                              // Is given fklid has already assigned?  
            
            eBean.setMessage2("This Tag No. has already assigned!");
            setAvailableTagList(this.availableTagList);
            return "fail";
            
        } else {
            
            if (y>0) {                                                          //Is given ip has already assigned to other fklid? 
                
                eBean.setMessage2("This Ip has already assigned to another Machine!");
                setAvailableTagList(this.availableTagList);
                return "fail";
                
            } else {
                
                if(eBean.getId()== null || eBean.getId().trim().isEmpty())      // only machine update no emp id inputed
                    {
                        isSave=eManager.saveM1(eBean);                          // update data of machine in mdata and insert new data in logdata table
                        if(isSave)
                        {
                        List<EmpBean> eBeanList = eManager.getAllpc2();
                        eBean.seteBeans(eBeanList);
                      
                            eBean.setMessage2("Data Saved");
                            setAvailableTagList(this.availableTagList);
                            setDeptList(this.deptList);
                             setProductList(this.productList);
                            return  "success";
                        }
                        else
                        {
                            eBean.setMessage2("Unable to Save Data!!!");
                            setAvailableTagList(this.availableTagList);
                            setDeptList(this.deptList);
                             setProductList(this.productList);
                            return  "fail";
                        }
                     
                  
                    }
                else                                                            // machine update with emo id inputed
                {
                    if (z>0) {                                                  //now check the inputed emp id exists or not
                        
                        isSave=eManager.saveM2(eBean); // update mdata, add new data in masgndata by assigning the tag to an existing emp, add new data in logdata
                        if(isSave)
                        {
                        List<EmpBean> eBeanList = eManager.getAllpc();
                        eBean.seteBeans(eBeanList);
                      
                            eBean.setMessage2("Data Saved");
                            setAvailableTagList(this.availableTagList);
                            setDeptList(this.deptList);
                             setProductList(this.productList);
                            return  "success";
                           
                        }
                        else
                        {
                            eBean.setMessage2("Unable to Save Data!!!");
                            setAvailableTagList(this.availableTagList);
                            setDeptList(this.deptList);
                             setProductList(this.productList);
                            return  "fail";
                        }
                        
                    } else {                                                    // if iputed emp id is new then send it to addEmp ui
                        
                        eBean.setMessage2("Id don't exists! please Add new employee here..");
                        setAvailableTagList(this.availableTagList);
                        setDeptList(this.deptList);
                         setProductList(this.productList);
                        return "error";                                         // if iputed emp id is new then send it to addEmp ui by "error" result
                    }
                } 
            }
        }     
    }
   
    
    
    // add new machine data
    
    public String saveM(){
        
       if(eBean.getUtype()== null || eBean.getUtype().trim().isEmpty()){
            eBean.setMessage2("Select User Type..");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return  "fail";
        }
        String mtype=eBean.getMtype();
        String utype=eBean.getUtype();
            if (utype.equals("Individual")){               
                if(eBean.getId()== null || eBean.getId().trim().isEmpty()){
                    eBean.setMessage2("Enter ID");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return  "fail";
                }

                if(eBean.getHdate()== null || eBean.getHdate().trim().isEmpty()){
                    eBean.setMessage2("Enter Handover Date");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return  "fail";
                }

                if(eBean.getPrdtlife()== null || eBean.getPrdtlife().trim().isEmpty()){
                    eBean.setMessage2("Enter Product Lifetime");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return  "fail";
                }

                if(eBean.getSuplrwrnty()== null || eBean.getSuplrwrnty().trim().isEmpty()){
                    eBean.setMessage2("Enter Supplier Warrenty");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return  "fail";
                }

                if(eBean.getBuydate()== null || eBean.getBuydate().trim().isEmpty()){
                    eBean.setMessage2("Enter Product Purchase Date");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return  "fail";
                }


                int x=eCheck.checkfkl2(eBean.getFklid());
                int y=eCheck.checkIp3(eBean.getIp());
                System.out.println(y+"........."+eBean.getFklid());                



                String id;
                if (eBean.getId().length() < 6) {
                    id = StringUtils.leftPad(eBean.getId(), 6, "0");
                } else {
                    id = eBean.getId();
                }

                int z=eCheck.checkId2(id);
                boolean isSave= false;
                    if(eBean.getId()== null || eBean.getId().trim().isEmpty())  // only add machine data  no emp id inputed
                        {
                            isSave = eManager.saveM3(eBean);                    // add new data of machine in mdata and  new data in logdata table
                            if (isSave){
                                List<EmpBean> eBeanList = eManager.getAllpc2();
                                eBean.seteBeans(eBeanList);
                                String fkl = eCheck.getFklid(eBean.getIp());
                                eBean.setMessage2("Data Saved with Machine Tag No " + eCheck.getFklidForMessage() + " , and Product ID " + eCheck.getPidForMessage());
                                setDeptList(this.deptList);
                                setProductList(this.productList);
                                return "success";
                            }else{
                                eBean.setMessage2("Unable to Save Data!!!");
                                setDeptList(this.deptList);
                                setProductList(this.productList);
                                return "fail";
                            }
                        }else{                                                   // machine update with emp id inputed

                        if (z > 0) {                                             // now check the inputed emp id exists or not
                            isSave = eManager.saveM4(eBean);                     // add new data in mdata, in  masgndata by assigning the new tag to an existing emp, 
                            if (isSave)                                          // add new data in logdata
                            {
                                List<EmpBean> eBeanList = eManager.getAllpc();
                                eBean.seteBeans(eBeanList);
                                String fkl = eCheck.getFklid(eBean.getIp());
                                eBean.setMessage2("Data Saved with Machine Tag No " + eCheck.getFklidForMessage() + " , and Product ID " + eCheck.getPidForMessage());
                                setDeptList(this.deptList);
                                setProductList(this.productList);
                                return "success";
                            }else{
                                eBean.setMessage2("Unable to Save Data!!!");
                                setDeptList(this.deptList);
                                setProductList(this.productList);
                                return "fail";
                            }
                        }else{ // if iputed emp id is new then send it to addEmp ui
                            eBean.setMessage2("Id don't exists! please Add new employee here..");
                            setDeptList(this.deptList);
                            setProductList(this.productList);
                            return "error";                                     // if iputed emp id is new then send it to addEmp ui by "error" result
                        }
                }
            }else{
                
                System.out.println("Inputed.......Dept......................\\"+eBean.getDept()+"//");
                        
                if (eBean.getDept() == null || eBean.getDept().trim().isEmpty()) {
                    eBean.setMessage2("Enter Dept");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return "fail";
                }
                        
                if (eBean.getHdate() == null || eBean.getHdate().trim().isEmpty()) {
                    eBean.setMessage2("Enter Handover Date");
                    setDeptList(this.deptList);
                    setProductList(this.productList);

                    return "fail";
                }
        
                if (eBean.getPrdtlife() == null || eBean.getPrdtlife().trim().isEmpty()) {
                    eBean.setMessage2("Enter Product Lifetime");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return "fail";
                }

                if (eBean.getSuplrwrnty() == null || eBean.getSuplrwrnty().trim().isEmpty()) {
                    eBean.setMessage2("Enter Supplier Warrenty");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return "fail";
                }

                if (eBean.getBuydate() == null || eBean.getBuydate().trim().isEmpty()) {

                    eBean.setMessage2("Enter Product Purchase Date");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return "fail";
                }
                int y=eCheck.checkIp3(eBean.getIp());

                boolean isSave= false;
                isSave=eManager.savePrinter(eBean);                             // add new data of machine in mdata and  new data in logdata table
                
                if (isSave) {
                    List<EmpBean> eBeanList = eManager.getAllpc2();
                    eBean.seteBeans(eBeanList);
                    String fkl = eCheck.getFklid(eBean.getIp());
                    eBean.setMessage2("Data Saved with Machine Tag No " + eCheck.getFklidForMessage() + " , and Product ID " + eCheck.getPidForMessage());
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return "success";

                } else {
                    eBean.setMessage2("Unable to Save Data!!!");
                    setDeptList(this.deptList);
                    setProductList(this.productList);
                    return "fail";
                }  
            }
    } 
    
    
    public String saveEmp()
    {
        
        //validation------------------------------------------------------
        if(eBean.getId() == null || eBean.getId().trim().isEmpty())
        {
            eBean.setMessage2("Enter ID");
            setDeptList(this.deptList);
            return  "fail";
        }

        if(eBean.getName() == null || eBean.getName().trim().isEmpty())
        {
            eBean.setMessage2("Enter Name");
            
            setDeptList(this.deptList);
            return  "fail";
        }


        if(eBean.getDept() == null || eBean.getDept().trim().isEmpty())
        {
            eBean.setMessage2("Enter Dept.");
            setDeptList(this.deptList);
            return  "fail";
        }

        if(eBean.getDesignation() == null || eBean.getDesignation().trim().isEmpty())
        {
            eBean.setMessage2("Enter Designation");
            setDeptList(this.deptList);
            return  "fail";
        }
        
        String id;
            
        if(eBean.getId().length()<6){
            //id="000000".substring(eBean.getId().length()) + eBean.getId();
            id=StringUtils.leftPad(eBean.getId(), 6,"0");
        }else{
            id=eBean.getId();
        }
        
        
        
        int x=eCheck.checkId2(id);
        
        if (x==0) {// check that the inputed id is not in empdata
            
            boolean isSave;
            isSave=eManager.saveEmp(eBean); // add new employee

            if(isSave)
            {
            List<EmpBean> eBeanList = eManager.getAllperson3();
            eBean.seteBeans(eBeanList);

                eBean.setMessage2("Data Saved");
                setDeptList(this.deptList);
                setAvailableTagList(this.availableTagList);
                return  "success";

            }
            else
            {
                eBean.setMessage2("Unable to Save Data!!!");
                setDeptList(this.deptList);
                return  "fail";
            }                        
        } else {            
            eBean.setMessage2("Id exists!");
            setDeptList(this.deptList);
            return  "fail";           
        }
    }
    
    
    
    
    
    public String searchEmp() {
        if (eBean.getId() == null || eBean.getId().trim().isEmpty()) {
            eBean.setMessage2("Enter ID");
            setDeptList(this.deptList);
            return "fail";
        }

        String id;

        if (eBean.getId().length() < 6) {
            id = StringUtils.leftPad(eBean.getId(), 6, "0");
        } else {
            id = eBean.getId();
        }
        
        EmpBean pb = eManager.getPerson2(id);

        if (pb == null) {
            eBean.setMessage2("This id not exists....");
            setDeptList(this.deptList);
            return "fail";
        } else {
            eBean.setId(pb.getId());
            eBean.setName(pb.getName());
            //eBean.setMid(pb.getMid());
            eBean.setDept(pb.getDept());
            eBean.setDesignation(pb.getDesignation());
            eBean.setOldId(pb.getId());
            eBean.setOldDept(pb.getDept());
            eBean.setPvs_extension(pb.getPvs_extension());
            List<EmpBean> eBeanList = eManager.getAllpc();
            setAvailableTagList(this.availableTagList);
            eBean.seteBeans(eBeanList);
            setDeptList(this.deptList);

            return "success";
        }

    }
    
    
    public String upEmp() {
        
        if (eBean.getId() == null || eBean.getId().trim().isEmpty()) {
            eBean.setMessage2("Enter ID");
            setDeptList(this.deptList);
            return "fail";
        }
        
        String id;
        if (eBean.getId().length() < 6) {
            id = StringUtils.leftPad(eBean.getId(), 6, "0");
        } else {
            id = eBean.getId();
        }

        int chkEmp = eCheck.checkEmpId(id);
        if (!(eBean.getOldId().equals(id)) && chkEmp > 0) {

            eBean.setMessage2("The New ID you have inputed is already Exists!");
            setDeptList(this.deptList);
            return "fail";
        }

        boolean isUpdate = eManager.upEmp(eBean);
        if (isUpdate) {
            eBean.setMessage2("Data Updated");
            setDeptList(this.deptList);
            clear();
            return "success";
        } else {
            eBean.setMessage2("Unable to Update Data!!!");
            setDeptList(this.deptList);
            return "fail";
        }

    }
    
    
    public String deleteEmp() {

        if (eBean.getId() == null || eBean.getId().trim().isEmpty()) {
            eBean.setMessage2("Enter ID");
            setDeptList(this.deptList);
            return "fail";
        }
        String id;
        if (eBean.getId().length() < 6) {
            id = StringUtils.leftPad(eBean.getId(), 6, "0");
        } else {
            id = eBean.getId();
        }

        int checkDeletingId = eCheck.checkDeletingId(id);
        if (checkDeletingId > 0) {
            eBean.setMessage2("This employee already has machine! Please Update in All Machine Records First!!");
            setDeptList(this.deptList);
            return "fail";
        }

        boolean isDelete = eManager.deleteEmp(id);
        if (isDelete) {
            eBean.setMessage2("Data Deleted");
            setDeptList(this.deptList);
            clear();
            return "success";
        } else {
            eBean.setMessage2("Unable to Delete Data!!!");
            setDeptList(this.deptList);
            return "fail";
        }

    }
    
    
    
    public String deleteMdata() {

        if (eBean.getPcstatus() == null || eBean.getPcstatus().trim().isEmpty()) {
            eBean.setMessage2("Select Machine Status");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }

        if (eBean.getRemarks() == null || eBean.getRemarks().trim().isEmpty()) {
            eBean.setMessage2("Select Remarks");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }

        String fklid = null, remarks = null, pcstatus = null;

        fklid = eBean.getFklid();
        remarks = eBean.getRemarks();
        pcstatus = eBean.getPcstatus();

        boolean isDelete = eManager.deleteMdata(fklid, remarks, pcstatus, eBean.getName());
        if (isDelete) {
            eBean.setMessage2("Data Deleted");
            setDeptList(this.deptList);
            setProductList(this.productList);
            clear();
            return "success";

        } else {
            eBean.setMessage2("Unable to Delete Data!!!");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }
    }
    
    
    
        public String deletePdata() {
            System.out.println("FKL ID deletePdata in EmpAcxtion.java ");
            System.out.println("FKL ID : "+eBean.getFklid());
            System.out.println("FKL getRemarks : "+eBean.getRemarks());
            System.out.println("FKL getPcstatus : "+eBean.getPcstatus());
            System.out.println("Session name : "+eBean.getName());
            
            
        if (eBean.getPcstatus() == null || eBean.getPcstatus().trim().isEmpty()) {
            eBean.setMessage2("Select Machine Status");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }

        if (eBean.getRemarks() == null || eBean.getRemarks().trim().isEmpty()) {
            eBean.setMessage2("Select Remarks");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }

        String fklid = null, remarks = null, pcstatus = null, id = null;

        fklid = eBean.getFklid();
        remarks = eBean.getRemarks();
        pcstatus = eBean.getPcstatus();
        id = eBean.getId();

        boolean isDelete = eManager.deletePdata(fklid, remarks, pcstatus, id, eBean.getName());
        if (isDelete) {
            eBean.setMessage2("Data Deleted");
            setDeptList(this.deptList);
            setProductList(this.productList);
            clear();
            return "success";
        } else {
            eBean.setMessage2("Unable to Delete Data!!!");
            setDeptList(this.deptList);
            setProductList(this.productList);
            return "fail";
        }
    }


    
    
    public String searchProduct() {
        EmpBean pb = eManager.getProduct(eBean.getPid());
        if (pb == null) {
            eBean.setMessage2("This Product id not exists....");
            return "fail";
        } else {
            eBean.setPid(pb.getPid());
            eBean.setMemo(pb.getMemo());
            eBean.setCost(pb.getCost());
            eBean.setSupplier(pb.getSupplier());
            eBean.setBuydate(pb.getBuydate());
            eBean.setSuplrwrnty(pb.getSuplrwrnty());
            eBean.setPrdtlife(pb.getPrdtlife());
            return "success";

        }
    }
    
    
    public String updateProduct(){

        if (eBean.getBuydate() == null || eBean.getBuydate().trim().isEmpty()) {
            eBean.setMessage2("Product Parchase Date can't be remain blank");
            return "fail";
        }

        if (eBean.getPrdtlife() == null || eBean.getPrdtlife().trim().isEmpty()) {
            eBean.setMessage2("Product LifeTime can't be remain blank");
            return "fail";
        }

        if (eBean.getSuplrwrnty() == null || eBean.getSuplrwrnty().trim().isEmpty()) {
            eBean.setMessage2("Supplier Warrenty can't be remain blank");
            return "fail";
        }

        boolean isUpdate = eManager.updateProduct(eBean);
        if (isUpdate) {
            eBean.setMessage2("Data Updated");
            clear();
            return "success";

        } else {
            eBean.setMessage2("Unable to Update Data!!!");
            setDeptList(this.deptList);
            return "fail";
        }
    }
    
    
    public String viewPrinter() {
        List<EmpBean> eBeanList = eManager.getPrinter();
        eBean.seteBeans(eBeanList);
        return "success";
    }
    
    
    public String updatePrinterData() {
        System.out.println("test.............." + eBean.getPid());
        EmpBean pb = eManager.getPrinter2(eBean.getPid());
        System.out.println("test..............MTYPE: " + pb.getMtype());

        eBean.setPid(pb.getPid());
        eBean.setId(pb.getId());
        eBean.setDept(pb.getDept());
        eBean.setIp(pb.getIp());
        eBean.setMid(pb.getMid());
        eBean.setFklid(pb.getFklid());
        eBean.setPcstatus(pb.getPcstatus());
        eBean.setNstatus(pb.getNstatus());
        eBean.setMtype(pb.getMtype());
        eBean.setHdate(pb.getHdate());
        eBean.setImgdate(pb.getImgdate());
        eBean.setImgloc(pb.getImgloc());
        eBean.setRemarks(pb.getRemarks());
        eBean.setImages(pb.getImages());
        List<EmpBean> eBeanList = eManager.getPrinter();
        eBean.seteBeans(eBeanList);
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";
    }
    
    
    
    
    public String getDeletingPrntrData(){
        EmpBean pb = eManager.getPrinter2(eBean.getPid());
        eBean.setPid(pb.getPid());
        eBean.setId(pb.getId());
        eBean.setDept(pb.getDept());
        eBean.setIp(pb.getIp());
        eBean.setMid(pb.getMid());
        eBean.setFklid(pb.getFklid());
        eBean.setNstatus(pb.getNstatus());
        eBean.setMtype(pb.getMtype());
        eBean.setHdate(pb.getHdate());
        eBean.setImgdate(pb.getImgdate());
        eBean.setImgloc(pb.getImgloc());
        List<EmpBean> eBeanList = eManager.getPrinter();
        eBean.seteBeans(eBeanList);
        setDeptList(this.deptList);
        setProductList(this.productList);
        return "success";
    }
    
    
    

    public String getDeletingData(){
        EmpBean pb=eManager.getPerson(eBean.getPid());
        eBean.setPid(pb.getPid());
        eBean.setId(pb.getId());
        eBean.setName(pb.getName());
        eBean.setDesignation(pb.getDesignation());
        eBean.setDept(pb.getDept());
        eBean.setIp(pb.getIp());
        eBean.setMid(pb.getMid());
        eBean.setFklid(pb.getFklid());
        eBean.setHdd(pb.getHdd());
        eBean.setMboard(pb.getMboard());
        eBean.setRam(pb.getRam());
        eBean.setChip(pb.getChip());  
        eBean.setNstatus(pb.getNstatus());
        eBean.setMtype(pb.getMtype());
        eBean.setHdate(pb.getHdate());
        eBean.setImgdate(pb.getImgdate());
        eBean.setImgloc(pb.getImgloc());  
        List<EmpBean> eBeanList = eManager.getAllperson();
        eBean.seteBeans(eBeanList);
        setDeptList(this.deptList);
        setProductList(this.productList);
        String mtype=eBean.getMtype();
        if (mtype.equals("Printer")|| mtype.equals("Scanner")|| mtype.equals("Camera")){
            System.out.println("test................."+mtype);
            return "error";
        }else{
            return "success";
        }
    }
    
    
    public String saveDeptSettings() {                                           // this method add new depertment in Dept Name showing the combo box in Add/Assign New Machine Form

        //validation------------------------------------------------------
        if (eBean.getnDept() == null || eBean.getnDept().trim().isEmpty()){
            eBean.setMessage2("Enter Dept Name");
            return "fail";
        }

        if (eBean.getnDeptCode() == null || eBean.getnDeptCode().trim().isEmpty()){
            eBean.setMessage2("Enter Dept Code");
            return "fail";
        }

        boolean isSave;
        isSave = eManager.saveDeptSettings(eBean);                              // add new Department
        if (isSave) {
            eBean.setMessage2("Data Saved");
            return "success";
        } else {
            eBean.setMessage2("Unable to Save Data!!!");
            return "fail";
        }
    }
    
    
    
    public String saveMtypeSettings() {

        //validation------------------------------------------------------
        if (eBean.getMtype() == null || eBean.getMtype().trim().isEmpty()) {
            eBean.setMessage2("Enter Item type..");
            setDeptList(this.deptList);
            return "fail";
        }
        boolean isSave;
        isSave = eManager.saveMtypeSettings(eBean.getMtype()); // add new employee
        if (isSave) {
            eBean.setMessage2("Data Saved");
            return "success";
        } else {
            eBean.setMessage2("Unable to Save Data!!!");
            return "fail";
        }

    }
    
    
    public String getTagData() {

        EmpBean pb = eManager.getTagData(eBean.getFklid());
        eBean.setId(pb.getId());
        eBean.setName(pb.getName());
        eBean.setDesignation(pb.getDesignation());
        eBean.setDept(pb.getDept());
        eBean.setIp(pb.getIp());
        eBean.setMid(pb.getMid());
        eBean.setFklid(pb.getFklid());
        eBean.setHdd(pb.getHdd());
        eBean.setMboard(pb.getMboard());
        eBean.setRam(pb.getRam());
        eBean.setChip(pb.getChip());
        eBean.setPid(pb.getPid());
        eBean.setPcstatus(pb.getPcstatus());
        eBean.setNstatus(pb.getNstatus());
        eBean.setMtype(pb.getMtype());
        eBean.setHdate(pb.getHdate());
        eBean.setImgdate(pb.getImgdate());
        eBean.setImgloc(pb.getImgloc());
        eBean.setRemarks(pb.getRemarks());

        return "success";
    }
    
    
    
    
    

}
