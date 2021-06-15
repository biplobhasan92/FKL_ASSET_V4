/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fk.manager;

import com.fk.bean.IpBean;
import java.util.List;

/**
 *
 * @author Hasan
 */
public interface IpCheckManager {
    
    public List<IpBean> getIpList100();
    public List<IpBean> getIpList101();
    public List<IpBean> getIpList102();
    public List<IpBean> getIpList103();
    public List<IpBean> getIpList104();
    public List<IpBean> getIpList105();
    public List<IpBean> getIpList106();
    public List<IpBean> getIpList107();
    public List<IpBean> getIpList108();
    public List<IpBean> getIpList109();
    public List<IpBean> getIpList110();
    public List<IpBean> getIpList192();
    
    public boolean saveIpList100(IpBean ipBean);
    public boolean updateIpList100(IpBean ipBean);
    public boolean updateIpList192(IpBean ipBean);
    public boolean deleteIpList100(IpBean ipBean);
    
    public IpBean  getSingleIp100(String ip_no);
    public IpBean  getSingleIp101(String ip_no);
    public IpBean  getSingleIp102(String ip_no);
    public IpBean  getSingleIp103(String ip_no);
    public IpBean  getSingleIp104(String ip_no);
    public IpBean  getSingleIp105(String ip_no);
    public IpBean  getSingleIp106(String ip_no);
    public IpBean  getSingleIp107(String ip_no);
    public IpBean  getSingleIp108(String ip_no);
    public IpBean  getSingleIp109(String ip_no);
    public IpBean  getSingleIp110(String ip_no);
    public IpBean  getSingleIp192(int ip_sl_no);
}
