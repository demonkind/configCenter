package com.huifu.configCenter.biz.config;

import com.huifu.configCenter.biz.exception.ConfigCenterBizException;
import com.huifu.configCenter.service.core.constants.IpStatusEnum;
import com.huifu.configCenter.service.core.model.ConfigIpInfo;

/**
 * 
 * @author zhanghaijie
 * @version $Id: IpConfigBiz.java, v 0.1 2012-8-28 下午7:10:46 zhanghaijie Exp $
 */
public interface IpConfigBiz {

    /**
     * 添加IP地址
     * 
     * @param system
     * @param configIpInfo
     */
    public void addIp(String system, String env, ConfigIpInfo configIpInfo)
                                                                           throws ConfigCenterBizException;

    /**
     * 更新IP地址状态
     * 
     * @param ip
     * @param status
     * @throws ConfigCenterBizException 
     */
    public void updateIpStatus(String ip, IpStatusEnum status) throws ConfigCenterBizException;

}
