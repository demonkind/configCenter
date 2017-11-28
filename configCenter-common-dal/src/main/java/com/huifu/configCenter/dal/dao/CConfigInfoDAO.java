package com.huifu.configCenter.dal.dao;

import java.util.List;

import com.huifu.configCenter.dal.model.CConfigInfoDO;

/**
 * 
 * @author zhanghaijie
 * @version $Id: CConfigInfoDAO.java, v 0.1 2012-9-5 下午02:01:00 zhanghaijie Exp $
 */
public interface CConfigInfoDAO {

    public String getSequenceForUpdate();

    public List<CConfigInfoDO> getConfigInfoByBasicID(String basicId);

    public void addConfigInfo(CConfigInfoDO configInfoDO);

    public void updateConfigInfo(CConfigInfoDO configInfoDO);

	public CConfigInfoDO getByKey(String key);
}
