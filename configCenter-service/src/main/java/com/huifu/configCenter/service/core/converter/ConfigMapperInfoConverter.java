package com.huifu.configCenter.service.core.converter;

import com.huifu.configCenter.dal.model.CBasicInfoDO;
import com.huifu.configCenter.dal.model.CConfigInfoDO;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigMapperInfo;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigMapperInfoConverter.java, v 0.1 2012-8-27 下午3:07:08 zhanghaijie Exp $
 */
public class ConfigMapperInfoConverter {

    /**
     * 
     * @param configInfoDO
     * @param basicInfoDO
     * @return
     */
    public static final ConfigMapperInfo converterFromDoToModel(CConfigInfoDO configInfoDO,
                                                                CBasicInfoDO basicInfoDO) {
        if (null == configInfoDO) {
            return null;
        }
        ConfigMapperInfo configMapperInfo = new ConfigMapperInfo();
        configMapperInfo.setConfigId(configInfoDO.getConfigId());
        configMapperInfo.setGmtCreate(configInfoDO.getGmtCreate());
        configMapperInfo.setGmtModify(configInfoDO.getGmtModify());
        configMapperInfo.setKey(configInfoDO.getConfigKey());
        configMapperInfo.setValue(configInfoDO.getConfigValue());
        configMapperInfo.setMemo(configInfoDO.getMemo());

        ConfigBasicInfo configBasicInfo = new ConfigBasicInfo();
        if (null != basicInfoDO) {
            configBasicInfo = ConfigBasicInfoConverter.converterFromDoToModel(basicInfoDO, null,
                null);
        }
        configBasicInfo.setBasicId(configInfoDO.getBasicId());

        configMapperInfo.setBasicInfo(configBasicInfo);
        return configMapperInfo;
    }

    /**
     * 
     * @param configMapperInfo
     * @return
     */
    public static final CConfigInfoDO converterFromModelToDo(ConfigMapperInfo configMapperInfo) {
        if (null == configMapperInfo) {
            return null;
        }
        CConfigInfoDO configInfoDO = new CConfigInfoDO();
        configInfoDO.setBasicId(configMapperInfo.getBasicInfo().getBasicId());
        configInfoDO.setConfigId(configMapperInfo.getConfigId());
        configInfoDO.setConfigKey(configMapperInfo.getKey());
        configInfoDO.setConfigValue(configMapperInfo.getValue());
        configInfoDO.setMemo(configMapperInfo.getMemo());
        return configInfoDO;
    }
}