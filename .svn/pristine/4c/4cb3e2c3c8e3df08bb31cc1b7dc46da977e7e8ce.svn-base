package com.huifu.configCenter.service.core.converter;

import java.util.LinkedList;
import java.util.List;

import com.huifu.configCenter.dal.model.CBasicInfoDO;
import com.huifu.configCenter.dal.model.CConfigInfoDO;
import com.huifu.configCenter.dal.model.CIpInfoDO;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigIpInfo;
import com.huifu.configCenter.service.core.model.ConfigMapperInfo;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigBasicInfoConverter.java, v 0.1 2012-8-27 下午2:54:52 zhanghaijie Exp $
 */
public class ConfigBasicInfoConverter {

    public static final CBasicInfoDO converterFromModelToDo(ConfigBasicInfo configBasicInfo) {
        if (null == configBasicInfo) {
            return null;
        }

        CBasicInfoDO cBasicInfoDO = new CBasicInfoDO();
        cBasicInfoDO.setBasicId(configBasicInfo.getBasicId());
        cBasicInfoDO.setProjectName(configBasicInfo.getProjectName());
        cBasicInfoDO.setVersion(configBasicInfo.getVersion());
        cBasicInfoDO.setEnvironment(configBasicInfo.getEnvironment());
        cBasicInfoDO.setMemo(configBasicInfo.getMemo());
        return cBasicInfoDO;
    }

    /**
     * 
     * @param basicInfoDO
     * @param ipInfoDOs
     * @param configInfoDOs
     * @return
     */
    public static final ConfigBasicInfo converterFromDoToModel(CBasicInfoDO basicInfoDO,
                                                               List<CIpInfoDO> ipInfoDOs,
                                                               List<CConfigInfoDO> configInfoDOs) {
        if (null == basicInfoDO) {
            return null;
        }

        ConfigBasicInfo configBasicInfo = new ConfigBasicInfo();
        configBasicInfo.setBasicId(basicInfoDO.getBasicId());
        configBasicInfo.setGmtCreate(basicInfoDO.getGmtCreate());
        configBasicInfo.setGmtModify(basicInfoDO.getGmtModify());
        configBasicInfo.setProjectName(basicInfoDO.getProjectName());
        configBasicInfo.setVersion(basicInfoDO.getVersion());
        configBasicInfo.setEnvironment(basicInfoDO.getEnvironment());
        configBasicInfo.setMemo(basicInfoDO.getMemo());

        if (ipInfoDOs != null && ipInfoDOs.size() > 0) {
            List<ConfigIpInfo> configIpInfos = new LinkedList<ConfigIpInfo>();
            for (CIpInfoDO ipInfoDO : ipInfoDOs) {
                ConfigIpInfo configIpInfo = ConfigIpInfoConverter.converterFromDoToModel(ipInfoDO,
                    basicInfoDO);
                configIpInfos.add(configIpInfo);
            }
            configBasicInfo.setIpInfos(configIpInfos);
        }

        if (configInfoDOs != null && configInfoDOs.size() > 0) {
            List<ConfigMapperInfo> configMapperInfos = new LinkedList<ConfigMapperInfo>();
            for (CConfigInfoDO configInfoDO : configInfoDOs) {
                ConfigMapperInfo configMapperInfo = ConfigMapperInfoConverter
                    .converterFromDoToModel(configInfoDO, basicInfoDO);
                configMapperInfos.add(configMapperInfo);
            }
            configBasicInfo.setMapperInfo(configMapperInfos);
        }

        return configBasicInfo;
    }
}
