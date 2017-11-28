package com.huifu.configCenter.dal.dao;

import java.util.List;

import com.huifu.configCenter.dal.model.CBasicInfoDO;

/**
 * 
 * @author zhanghaijie
 * @version $Id: CBasicInfoDAO.java, v 0.1 2012-8-27 下午3:40:59 zhanghaijie Exp $
 */
public interface CBasicInfoDAO {

    public void saveBasicInfo(CBasicInfoDO basicInfoDO);

    public CBasicInfoDO getBasicInfoById(String basicId);

    public String getSequenceForUpdate();

    public CBasicInfoDO getBasicInfoBySystem(String system, String env);

    public List<CBasicInfoDO> getBasicInfoByIP(String ip);
}
