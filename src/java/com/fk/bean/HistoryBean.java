/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.bean;

/**
 *
 * @author Hasan
 */
public class HistoryBean {
    
    int sl;
    String fklId;
    String Ip;
    String mid;
    String mtype;
    String hdd;
    String mboard;
    String ram;
    String chip;
    int pid;
    String id;
    String img_date;
    String img_loc;
    String emp_name;
    String img_designation;
    String handover_date;
    String dept;
    String pcstatus;
    String nstatus;
    String date;
    String remarks;
    String note;
    String action_by_user;
    String action_take_by_pc;

    public HistoryBean() {
    }

    public HistoryBean(int sl, String fklId, String Ip, String mid, String mtype, String hdd, String mboard, String ram, String chip, int pid, String id, String img_date, String img_loc, String emp_name, String img_designation, String handover_date, String dept, String pcstatus, String nstatus, String date, String remarks, String note) {
        this.sl = sl;
        this.fklId = fklId;
        this.Ip = Ip;
        this.mid = mid;
        this.mtype = mtype;
        this.hdd = hdd;
        this.mboard = mboard;
        this.ram = ram;
        this.chip = chip;
        this.pid = pid;
        this.id = id;
        this.img_date = img_date;
        this.img_loc = img_loc;
        this.emp_name = emp_name;
        this.img_designation = img_designation;
        this.handover_date = handover_date;
        this.dept = dept;
        this.pcstatus = pcstatus;
        this.nstatus = nstatus;
        this.date = date;
        this.remarks = remarks;
        this.note = note;
    }
    
    

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public String getFklId() {
        return fklId;
    }

    public void setFklId(String fklId) {
        this.fklId = fklId;
    }

    public String getIp() {
        return Ip;
    }

    public void setIp(String Ip) {
        this.Ip = Ip;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_date() {
        return img_date;
    }

    public void setImg_date(String img_date) {
        this.img_date = img_date;
    }

    public String getImg_loc() {
        return img_loc;
    }

    public void setImg_loc(String img_loc) {
        this.img_loc = img_loc;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getImg_designation() {
        return img_designation;
    }

    public void setImg_designation(String img_designation) {
        this.img_designation = img_designation;
    }

    public String getHandover_date() {
        return handover_date;
    }

    public void setHandover_date(String handover_date) {
        this.handover_date = handover_date;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPcstatus() {
        return pcstatus;
    }

    public void setPcstatus(String pcstatus) {
        this.pcstatus = pcstatus;
    }

    public String getNstatus() {
        return nstatus;
    }

    public void setNstatus(String nstatus) {
        this.nstatus = nstatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAction_by_user() {
        return action_by_user;
    }

    public void setAction_by_user(String action_by_user) {
        this.action_by_user = action_by_user;
    }

    public String getAction_take_by_pc() {
        return action_take_by_pc;
    }

    public void setAction_take_by_pc(String action_take_by_pc) {
        this.action_take_by_pc = action_take_by_pc;
    }

    @Override
    public String toString() {
        return "HistoryBean{" + "sl=" + sl + ", fklId=" + fklId + ", Ip=" + Ip + ", mid=" + mid + ", mtype=" + mtype + ", hdd=" + hdd + ", mboard=" + mboard + ", ram=" + ram + ", chip=" + chip + ", pid=" + pid + ", id=" + id + ", img_date=" + img_date + ", img_loc=" + img_loc + ", emp_name=" + emp_name + ", img_designation=" + img_designation + ", handover_date=" + handover_date + ", dept=" + dept + ", pcstatus=" + pcstatus + ", nstatus=" + nstatus + ", date=" + date + ", remarks=" + remarks + ", note=" + note + ", action_by_user=" + action_by_user + ", action_take_by_pc=" + action_take_by_pc + '}';
    }
    
    
}
