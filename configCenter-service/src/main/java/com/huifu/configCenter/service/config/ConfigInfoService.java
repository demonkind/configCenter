package com.huifu.configCenter.service.config;

import com.huifu.configCenter.dal.model.CConfigInfoDO;
import com.huifu.configCenter.service.core.model.ConfigMapperInfo;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigInfoService.java, v 0.1 2012-10-15 下午08:02:55 zhanghaijie Exp $
 */
public interface ConfigInfoService {

	public CConfigInfoDO get(String key);
	
    /**
     * 
     * @param configMapperInfo
     */
    public void addConfigInfo(ConfigMapperInfo configMapperInfo);

    /**
     * 
     * @param configMapperInfo
     */
    public void modifyConfigInfo(ConfigMapperInfo configMapperInfo);

}
