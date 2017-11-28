package com.huifu.configCenter.service.config;

import java.util.List;

import com.huifu.configCenter.service.core.model.ConfigIpInfo;

/**
 * 
 * @author zhanghaijie
 * @version $Id: IpInfoService.java, v 0.1 2012-8-27 下午8:04:36 zhanghaijie Exp $
 */
public interface IpConfigService {

    /**
     * 获取IP地址信息
     * 
     * @param systemName
     * @param status
     * @return
     */
    public List<ConfigIpInfo> getIpInfo(String systemName, String env, String status);

    /**
     *  ip 地址更新
     * 
     * @param ip
     * @param status
     */
    public void mofidyStatus(String ip, String status);

    /**
     * 添加Ip
     * @param configIpInfo
     */
    public void addIp(ConfigIpInfo configIpInfo);

    /**
     * 获取配置
     * 
     * @param ip
     * @return
     */
    public ConfigIpInfo getConfigIpInfoByIp(String ip);
}
