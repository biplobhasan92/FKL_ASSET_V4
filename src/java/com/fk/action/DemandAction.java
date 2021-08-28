/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.action;

import com.fk.bean.Demand;
import com.fk.bean.DemandBean;
import com.fk.bean.DemandDesc;
import com.fk.bean.DemandDetails;
import com.fk.bean.EmpBean;
import com.fk.manager.DemandManager;
import com.fk.manager.impl.DemandManagerImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;

/**
 * @since 2.0
 * @author Hasan Mobarak
 * @version 3.0
 * @email biplobjugp40@gmail.com
 */

public class DemandAction extends ActionSupport implements ModelDriven<Demand>{ // implements ModelDriven<DemandBean>
    
    private Demand d = new Demand();
    private DemandBean demand;
    private DemandDetails demand_Det;    
    private List<Demand> dList;
    private List<Demand> descList;
    private List<DemandBean> demandList;
    private List<DemandDetails> demandDetail;
    private List<String> demandDesc;
    private int rowindex;
    DemandManager dmnManager = new DemandManagerImp();

    public Demand getD() {
        return d;
    }

    public void setD(Demand d){
        this.d = d;
    }

    public List<String> getDemandDesc(){
        return demandDesc;
    }

    public void setDemandDesc(List<String> demandDesc){
        this.demandDesc = demandDesc;
    }
    
    
    public DemandBean getDemand(){
        return demand;
    }
    
    
    public void setDemand(DemandBean demand){
        this.demand = demand;
    }
    

    public DemandDetails getDemand_Det(){
        return demand_Det;
    }

    public void setDemand_Det(DemandDetails demand_Det){
        this.demand_Det = demand_Det;
    }

    public List<DemandBean> getDemandList(){
        return demandList;
    }

    public void setDemandList(List<DemandBean> demandList){
        this.demandList = demandList;
    }

    public List<DemandDetails> getDemandDetail(){
        return demandDetail;
    }

    public void setDemandDetail(List<DemandDetails> demandDetail){
        this.demandDetail = demandDetail;
    }

    public int getRowindex(){
        return rowindex;
    }

    public void setRowindex(int rowindex){
        this.rowindex = rowindex;
    }

    public List<Demand> getdList(){
        return dList;
    }

    public void setdList(List<Demand> dList){
        this.dList = dList;
    }

    public List<Demand> getDescList(){
        return descList;
    }

    public void setDescList(List<Demand> descList){
        this.descList = descList;
    }
    
    
    


    @Override
    public String execute(){
        gotoDemandInputForm();
        System.out.println("Execute()... ");
        demand = new DemandBean();
        List<DemandDetails> dds = new ArrayList<>();
        demand_Det = new DemandDetails();
        demand_Det.setDescription("asd");
        demand_Det.setBrand("asd");
        demand_Det.setModel("asd");
        demand_Det.setWeight(02);
        demand_Det.setPcs(0);
        demand_Det.setPartsNo(20);
        demand_Det.setLocation("wqe");
        demand_Det.setRemarks("weq");
        dds.add(demand_Det);
        demand.setDemandDetail(dds);
        return SUCCESS;
    }
    
    
    
    

    public String saveDemandNote(){
        
        demand = getDemand();            
        demandDetail = demand.getDemandDetail();        
        if(demand.getDdn_no() <= 0){
            demand.setMessage("Enter ID");
            return  "fail";
        }
        
        if(demand.getDemandDate()== null || demand.getDemandDate().trim().isEmpty()){
            demand.setMessage(" Select Date ");
            return  "fail";
        }
        
        if(demand.getSubmitedTo()== null || demand.getSubmitedTo().trim().isEmpty()){
            demand.setMessage(" Select Date ");
            return  "fail";
        }
        
        try{
            if(dmnManager.saveDemand(demand)){
                return SUCCESS;
            }else{
                return "fail";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    
    public String editDemandNote(){
        
        demand = getDemand();            
        demandDetail = demand.getDemandDetail();
        
        if(demand.getDdn_no() <= 0){
            demand.setMessage("Enter ID");
            return  "fail";
        }
        
        if(demand.getDemandDate()== null || demand.getDemandDate().trim().isEmpty()){
            demand.setMessage(" Select Date ");
            return  "fail";
        }
        
        if(demand.getSubmitedTo()== null || demand.getSubmitedTo().trim().isEmpty()){
            demand.setMessage(" Select Date ");
            return  "fail";
        }
        
        try{
            if(dmnManager.editDemand(demand)){
                return SUCCESS;
            }else{
                return "fail";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }
    
    public String gotoEditDemandInput(){
        demand = dmnManager.getDemandBean(d.getDdn_no());
        dList  = dmnManager.getSingleDemand(d.getDdn_no());
        return SUCCESS;
    }
    
    
    
    public String gotoDeleteDemandInput(){
        if(dmnManager.deleteSingleDescription(d.getSl()))
        {
            dList = dmnManager.getAllDemand();
            return SUCCESS;
        }else{
            return "fail";   
        }
    }
    
    
    
    public String getAllDescription(){
        descList = dmnManager.getAllDescription();
        d.setSl(0);
        d.setDescription("");
        return "success";
    }
    
    
    public String getAllDemand(){
        dList = dmnManager.getAllDemand();
        return "success";
    }
    
    
    public String editDemandDesc(){
        return "success";
    }
    
    
    public String testAction(){
        gotoDemandInputForm();
        return "success";
    }
    
    
    /*
        public String machineReport(){
            List<EmpBean> eBeanList = eManager.getAllRecords();
            eBean.seteBeans(eBeanList);
            return "success";
        }
    */
    
    
    public String gotoDemandInputForm(){
        // demandDesc = dmnManager.getAllDesc();
        demandDesc = new ArrayList<String>();
        demandDesc.add(" Test Data 1 ");
        demandDesc.add(" Test Data 2 ");
        demandDesc.add(" Test Data 3 ");
        demandDesc.add(" Test Data 4 ");
        demandDesc.add(" Test Data 5 ");
        return "success";
    }
    
    
    public String gotoDemandList(){
        return "success";
    }
    
    
    public String gotoDescription(){
        getAllDescription();
        return "success";
    }
    
    
    
    public String addDescription(){
        if(d.getSl()>0){
            dmnManager.updateDescription(d.getSl(), d.getDescription());
        }else{ // wrire insert statment .......
            if(!d.getDescription().trim().isEmpty()){
                dmnManager.addDescription(d.getDescription().toString());
            }else{
                System.err.println(" Description empty ");
            }
        }
        getAllDescription();
        return "success";
    }
    
    
    
    public String getEditDemandData(){
        d = dmnManager.getSingleDescription(d.getSl());
        descList = dmnManager.getAllDescription();
        return "success";
    }
    
    
    
    @Override
    public Demand getModel(){
        return d;
    }
    
}
