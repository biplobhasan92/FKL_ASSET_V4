/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.action;

import com.fk.bean.HistoryBean;
import com.fk.manager.impl.LogHistoryImp;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;

/**
 *
 * @author Hasan
 */
public class LogHistoryAction extends ActionSupport implements ModelDriven<HistoryBean>{

    HistoryBean bean = new HistoryBean();
    LogHistoryImp LogImp = new LogHistoryImp();
    private List<HistoryBean> getHistoryList;
    
    public String log_history(){
        getGetHistoryList();
        return "success";
    }

    public HistoryBean getBean(){
        return bean;
    }

    public void setBean(HistoryBean bean){
        this.bean = bean;
    }

    public List<HistoryBean> getGetHistoryList(){
        return LogImp.getLogHistory();
    }

    public void setGetHistoryList(List<HistoryBean> getHistoryList){
        this.getHistoryList = getHistoryList;
    }
    
    
    
    @Override
    public HistoryBean getModel() {
        return bean;
    }
    
}
