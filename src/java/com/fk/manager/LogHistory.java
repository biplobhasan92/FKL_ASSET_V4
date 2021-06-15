/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager;

import com.fk.bean.HistoryBean;
import com.fk.manager.*;
import com.fk.bean.IpBean;
import java.util.List;

/**
 *
 * @author Hasan
 */
public interface LogHistory {
    public List<HistoryBean> getLogHistory();
}
