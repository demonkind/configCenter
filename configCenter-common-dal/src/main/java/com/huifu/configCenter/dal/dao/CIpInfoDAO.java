package com.huifu.configCenter.dal.dao;

import java.util.List;

import com.huifu.configCenter.dal.model.CIpInfoDO;

/**
 * 
 * @author zhanghaijie
 * @version $Id: CConfigInfoDAO.java, v 0.1 2012-8-27 下午7:29:35 zhanghaijie Exp $
 */
public interface CIpInfoDAO {

    public String getSequenceForUpdate();

    public List<CIpInfoDO> getIpInfosBySystemName(String systemName, String env, String ipStatus);

    public void updateIpStatus(String ip, String status);

    public void addIp(CIpInfoDO ipInfoDO);

    public CIpInfoDO getIpInfoByIp(String ip);

    public List<CIpInfoDO> getIpInfosByBasicID(String basicID);
}
