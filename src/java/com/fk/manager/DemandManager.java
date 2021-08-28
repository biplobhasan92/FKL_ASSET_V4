/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager;

import com.fk.bean.DemandBean;
import com.fk.bean.Demand;
import com.fk.bean.DemandDesc;
import java.util.List;

/**
 *
 * @author Hasan
 */
public interface DemandManager {
    public boolean saveDemand(DemandBean dBena);
    public boolean editDemand(DemandBean dBena);
    public boolean saveDemandSub(DemandBean dBena);
    public List<Demand> getAllDemand();
    public List<Demand> getSingleDemand(int ddn_no);
    // public Demand getDemand(int ddn_no);
    public DemandBean getDemandBean(int ddn_no);
    public int addDescription(String desc);
    public List<Demand> getAllDescription();
    public Demand getSingleDescription(int sl);
    public boolean deleteSingleDescription(int sl);
    public boolean updateDescription(int sl, String desc);
    public List<DemandDesc> getAllDesc();
}
