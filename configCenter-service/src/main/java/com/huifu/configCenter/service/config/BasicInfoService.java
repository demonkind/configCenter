package com.huifu.configCenter.service.config;

import java.util.List;

import com.huifu.configCenter.service.core.model.ConfigBasicInfo;

/**
 * 
 * @author zhanghaijie
 * @version $Id: BasicInfoService.java, v 0.1 2012-8-28 下午5:14:39 zhanghaijie Exp $
 */
public interface BasicInfoService {

    /**
     * 
     * @param configBasicInfo
     */
    public void createSystemInfo(ConfigBasicInfo configBasicInfo);

    /**
     * 
     * @param systemName
     * @return
     */
    public ConfigBasicInfo getConfigBasicInfo(String systemName, String env);

    /**
     * 
     * @param ip
     * @return
     */
    public List<ConfigBasicInfo> getConfigBasicInfoByIP(String ip);

    /**
     * 获取系统配置参数，包括IP参数及Config参数
     * 
     * @param systemName
     * @param env
     * @return
     */
    public ConfigBasicInfo getConfigInfo(String systemName, String env);

    /**
     * 获取系统配置参数，包括IP参数及Config参数
     * 
     * @param systemName
     * @param env
     * @param key
     * @return
     */
    public ConfigBasicInfo getConfigInfo(String systemName, String env, String key);

}
