

package com.fk.manager;

import com.fk.bean.EmpBean;
import com.fk.bean.adminBean;
import java.util.List;


public interface  EmpManager {
    
    public boolean saveM1(EmpBean eBean);
    public boolean saveM2(EmpBean eBean);
    public boolean saveM3(EmpBean eBean);
    public boolean saveM4(EmpBean eBean);
    public boolean saveEmp(EmpBean eBean);
    public boolean savePrinter(EmpBean eBean);    
    public boolean updateEditEntry2(EmpBean eBean);
    public boolean updateM(EmpBean eBean);
    public boolean update1(EmpBean eBean);
    public boolean update2(EmpBean eBean);
    public boolean upEmp(EmpBean eBean);
    public boolean updateProduct(EmpBean eBean);         
    public List<EmpBean> getAllperson();
    public List<EmpBean> getAllperson2();
    public List<EmpBean> getAllperson3();
    public List<EmpBean> getAllpc();
    public List<EmpBean> getAllpc2();
    public List<EmpBean> getPrinter();
    public List<EmpBean> getAllRecords();        
    public boolean saveAdmn(adminBean aBean);
    public boolean upAdmn(adminBean aBean);
    public boolean changePass(adminBean aBean);
    public adminBean getAdmn(String aname);        
    public boolean deleteEmp(String id);    
    public boolean deleteMdata(String fklid, String remarks, String pcstatus,  String sessionName);
    public boolean deletePdata(String fklid, String remarks, String pcstatus, String id, String sessionname);
    public List<EmpBean> getAllperson4(String id);
    public EmpBean getPerson(int poid);
    public EmpBean getPerson2(String poid);
    public EmpBean getPerson3(String poid);
    public EmpBean getPerson4(String poid);
    public EmpBean getM(String poid);
    public EmpBean getM2(String poid);
    public EmpBean getProduct(int poid);
    public EmpBean getPrinter2(int poid);     
    public EmpBean getTagData(String poid);            
    public boolean saveDeptSettings(EmpBean eBean);    
    public boolean saveMtypeSettings(String mtype);
}
