/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * author : Ahsan, Hasan Mobarak
 */

package com.fk.bean;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Lob;




public class EmpBean {

    private String serial;
    private String id;
    private String name;
    private String designation;
    private String dept;
    private String mid;
    private String fklid;
    private String ip;
    private String description;
    private String hdd;
    private String mboard;
    private String ram;    
    @Lob
    @Column(name="chip", length=512)
    private String chip;
    private String message;
    private String message2;
    private String poid;
    private int pid;
    private String pcstatus;
    private String nstatus;
    private String date;
    private String hdate;
    private String supplier;
    private String cost;
    private String prdtlife;
    private String suplrwrnty;
    private String memo;
    private String imgdate; 
    private String imgloc;
    private String buydate;
    private String mtype;
    private String mdept;
    private String remarks;
    private String date1;
    private String date2;
    private String oldId;
    private String oldDept;
    private String dStatus;
    private String dRemarks;
    private String nDept;
    private String nDeptCode;
    private String utype;
    private String pvs_extension;
    private String images;
    private String monitor_desc;

    
    
    public String getMonitor_desc() {
        return monitor_desc;
    }

    public void setMonitor_desc(String monitor_desc) {
        this.monitor_desc = monitor_desc;
    }
    
    
    public String getImages(){
        return images;
    }

    public void setImages(String images){
        this.images = images;
    }
    
    
    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }
    
    
    
    

    public String getnDept() {
        return nDept;
    }

    public void setnDept(String nDept) {
        this.nDept = nDept;
    }

    public String getnDeptCode() {
        return nDeptCode;
    }

    public void setnDeptCode(String nDeptCode) {
        this.nDeptCode = nDeptCode;
    }
    
    

    public String getOldDept() {
        return oldDept;
    }

    public void setOldDept(String oldDept) {
        this.oldDept = oldDept;
    }

    public String getdStatus() {
        return dStatus;
    }

    public void setdStatus(String dStatus) {
        this.dStatus = dStatus;
    }

    public String getdRemarks() {
        return dRemarks;
    }

    public void setdRemarks(String dRemarks) {
        this.dRemarks = dRemarks;
    }

    public String getPvs_extension() {
        return pvs_extension;
    }
    
    public void setPvs_extension(String pvs_extension){
        this.pvs_extension = pvs_extension;
    }
    
    
    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }
    
    
    
    
    
    

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }
    
    

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    

    public String getMdept() {
        return mdept;
    }

    public void setMdept(String mdept) {
        this.mdept = mdept;
    }
    
    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    
    
    

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }
    
    
    
    
    

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPrdtlife() {
        return prdtlife;
    }

    public void setPrdtlife(String prdtlife) {
        this.prdtlife = prdtlife;
    }

    public String getSuplrwrnty() {
        return suplrwrnty;
    }

    public void setSuplrwrnty(String suplrwrnty) {
        this.suplrwrnty = suplrwrnty;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getImgdate() {
        return imgdate;
    }

    public void setImgdate(String imgdate) {
        this.imgdate = imgdate;
    }

    public String getImgloc() {
        return imgloc;
    }

    public void setImgloc(String imgloc) {
        this.imgloc = imgloc;
    }
    
    
    
    

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }
     
     
    
    
    
    //EmpBean eB= new EmpBean();

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }
    
    

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getFklid() {
        return fklid;
    }

    public void setFklid(String fklid) {
        this.fklid = fklid;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getMboard() {
        return mboard;
    }

    public void setMboard(String mboard) {
        this.mboard = mboard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    
    
    
    
    
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
    
    
    public String getNstatus() {
        return nstatus;
    }

    public void setNstatus(String nstatus) {
        this.nstatus = nstatus;
    }
    
    

    public String getPcstatus() {
        return pcstatus;
    }

    public void setPcstatus(String pcstatus) {
        this.pcstatus = pcstatus;
    }

    
    
    

   
    

    private List<EmpBean> eBeans;
    
    private List<EmpBean> eDeptList;

    public List<EmpBean> geteDeptList() {
        return eDeptList;
    }

    public void seteDeptList(List<EmpBean> eDeptList) {
        this.eDeptList = eDeptList;
    }
    

    
    
    
    public List<EmpBean> geteBeans() {
        return eBeans;
    }

    public void seteBeans(List<EmpBean> eBeans) {
        this.eBeans = eBeans;
    }

    



    public String getPoid() {
        return poid;
    }

    public void setPoid(String poid) {
        this.poid = poid;
    }
   



    
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public void setMessage(int chkId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }







}
