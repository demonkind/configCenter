package com.huifu.configCenter.service.core.converter;

import com.huifu.configCenter.dal.model.CBasicInfoDO;
import com.huifu.configCenter.dal.model.CIpInfoDO;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigIpInfo;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigIpInfoConverter.java, v 0.1 2012-8-27 下午2:55:59 zhanghaijie Exp $
 */
public class ConfigIpInfoConverter {

    /**
     * 
     * @param ipInfoDO
     * @param basicInfoDO
     * @return
     */
    public static final ConfigIpInfo converterFromDoToModel(CIpInfoDO ipInfoDO,
                                                            CBasicInfoDO basicInfoDO) {
        if (null == ipInfoDO) {
            return null;
        }

        ConfigIpInfo configIpInfo = new ConfigIpInfo();
        configIpInfo.setGmtCreate(ipInfoDO.getGmtCreate());
        configIpInfo.setGmtModify(ipInfoDO.getGmtModify());
        configIpInfo.setIp(ipInfoDO.getIp());
        configIpInfo.setMac(ipInfoDO.getMac());
        configIpInfo.setStatus(ipInfoDO.getStatus());
        configIpInfo.setIpId(ipInfoDO.getIpId());
        configIpInfo.setPort(ipInfoDO.getPort());
        configIpInfo.setMemo(ipInfoDO.getMemo());

        ConfigBasicInfo configBasicInfo = new ConfigBasicInfo();
        if (null != basicInfoDO) {
            configBasicInfo = ConfigBasicInfoConverter.converterFromDoToModel(basicInfoDO, null,
                null);
        }
        configBasicInfo.setBasicId(ipInfoDO.getBasicId());
        configIpInfo.setBasicInfo(configBasicInfo);

        return configIpInfo;
    }

    /**
     * 
     * @param configIpInfo
     * @return
     */
    public static final CIpInfoDO converterFromModelToDO(ConfigIpInfo configIpInfo) {
        if (null == configIpInfo) {
            return null;
        }

        CIpInfoDO ipInfoDO = new CIpInfoDO();
        ipInfoDO.setBasicId(configIpInfo.getBasicInfo().getBasicId());
        ipInfoDO.setIp(configIpInfo.getIp());
        ipInfoDO.setMac(configIpInfo.getMac());
        ipInfoDO.setStatus(configIpInfo.getStatus());
        ipInfoDO.setIpId(configIpInfo.getIpId());
        ipInfoDO.setPort(configIpInfo.getPort());
        ipInfoDO.setMemo(configIpInfo.getMemo());
        return ipInfoDO;
    }
}
