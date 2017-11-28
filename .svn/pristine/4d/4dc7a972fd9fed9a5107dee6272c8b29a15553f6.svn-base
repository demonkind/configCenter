package com.huifu.configCenter.biz.ws.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huifu.configCenter.biz.util.ConfigurationServiceUtil;
import com.huifu.configCenter.biz.ws.model.ConfigCenterRespResult;
import com.huifu.configCenter.dal.model.CConfigInfoDO;
import com.huifu.configCenter.facade.service.ConfigurationOperService;
import com.huifu.configCenter.service.config.BasicInfoService;
import com.huifu.configCenter.service.config.ConfigInfoService;
import com.huifu.configCenter.service.core.constants.ConfigCenterCodeEnum;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigMapperInfo;
import com.huifu.saturn.common.constants.constants.SaturnCommonConstants;
import com.huifu.saturn.common.utils.SaturnLoggerUtils;
import com.huifu.saturn.runtime.mq.sender.MessageSender;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigurationOperServiceImpl.java, v 0.1 2012-10-16 上午08:50:04 zhanghaijie Exp $
 */
public class ConfigurationOperServiceImpl implements ConfigurationOperService {

    private static final Logger logger = Logger.getLogger(ConfigurationServiceImpl.class);

    private BasicInfoService    basicInfoService;

    private ConfigInfoService   configInfoService;

    private MessageSender       messageSender;

    /** 
     * @see com.huifu.configCenter.facade.service.ConfigurationOperService#addConfiguration(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String addConfiguration(String system, String env, String key, String value) {
        if (!paramCheck(system, env, key, value)) {
            return ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode();
        }
        try {
            ConfigBasicInfo configBasicInfo = basicInfoService.getConfigBasicInfo(system, env);
            if (null == configBasicInfo) {
                SaturnLoggerUtils.warn(logger, null, "【配置添加】系统参数不存在,system", system, "env", env,
                    "key", key, "value", value);
                return ConfigCenterCodeEnum.RECORD_NOT_EXISTED.getCode();
            }
            if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            	SaturnLoggerUtils.warn(logger, null, "【配置添加】系统参数异常,system", system, "env", env,
                        "key", key, "value", value);
                    return ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode();
            }
            CConfigInfoDO cConfigInfoDO = this.configInfoService.get(key);
            if (cConfigInfoDO != null) {
            	SaturnLoggerUtils.warn(logger, null, "【配置添加】系统配置已存在,system", system, "env", env,
                        "key", key, "value", value);
                    return ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode();
            }
            addConfigMapperInfo(configBasicInfo, key, value);
            configBroadCast(system, env, key);
        } catch (Exception e) {
            SaturnLoggerUtils.error(logger, e, "【添加配置信息】添加配置信息失败,system", system, "env", env,
                "key", key, "value", value);
            return ConfigCenterCodeEnum.SYSTEM_ERROR.getCode();
        }
        return ConfigCenterCodeEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param system
     * @param env
     * @param key
     */
    private void configBroadCast(String system, String env, String key) {
        ConfigBasicInfo configBasicInfo = basicInfoService.getConfigInfo(system, env, key);
        ConfigCenterRespResult result = ConfigurationServiceUtil
            .convertConfigFromConfigBasicInfoToResult(system, env, configBasicInfo);
        String xml = ConfigurationServiceUtil.convertFromResultToXML(result);
        SaturnLoggerUtils.info(logger, "【配置信息广播】配置信息广播XML", xml);
        messageSender.send(SaturnCommonConstants.TP_PUB_SUB_CONFIG_INFO, xml);
    }

    /**
     * 
     * @param configBasicInfo
     * @param key
     * @param value
     */
    private void addConfigMapperInfo(ConfigBasicInfo configBasicInfo, String key, String value) {
        ConfigMapperInfo configMapperInfo = new ConfigMapperInfo();
        configMapperInfo.setBasicInfo(configBasicInfo);
        configMapperInfo.setKey(key);
        configMapperInfo.setValue(value);
        configInfoService.addConfigInfo(configMapperInfo);
    }

    /** 
     * @see com.huifu.configCenter.facade.service.ConfigurationOperService#modifyConfiguration(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String modifyConfiguration(String system, String env, String key, String value) {
        if (!paramCheck(system, env, key, value)) {
            return ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode();
        }

        try {
            ConfigBasicInfo configBasicInfo = basicInfoService.getConfigInfo(system, env, key);
            if (null == configBasicInfo || null == configBasicInfo.getMapperInfo()
                || configBasicInfo.getMapperInfo().size() < 1) {
                SaturnLoggerUtils.warn(logger, null, "【配置更改】系统参数不存在,system", system, "env", env,
                    "key", key, "value", value);
                return ConfigCenterCodeEnum.RECORD_NOT_EXISTED.getCode();
            }
            if (StringUtils.isBlank(key) || StringUtils.isBlank(value)) {
            	SaturnLoggerUtils.warn(logger, null, "【配置更改】系统参数异常,system", system, "env", env,
                        "key", key, "value", value);
                    return ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode();
            }
            modifyMapperInfo(configBasicInfo, key, value);
            configBroadCast(system, env, key);
        } catch (Exception e) {
            SaturnLoggerUtils.error(logger, e, "【更改配置信息】更改配置信息失败,system", system, "env", env,
                "key", key, "value", value);
            return ConfigCenterCodeEnum.SYSTEM_ERROR.getCode();
        }
        return ConfigCenterCodeEnum.SUCCESS.getCode();
    }

    /**
     * 
     * @param configBasicInfo
     * @param key
     * @param value
     */
    private void modifyMapperInfo(ConfigBasicInfo configBasicInfo, String key, String value) {
        ConfigMapperInfo configMapperInfo = new ConfigMapperInfo();
        configMapperInfo.setBasicInfo(configBasicInfo);
        configMapperInfo.setConfigId(configBasicInfo.getMapperInfo().get(0).getConfigId());
        configMapperInfo.setKey(key);
        configMapperInfo.setValue(value);
        configInfoService.modifyConfigInfo(configMapperInfo);
    }

    /**
     * 
     * @param system
     * @param env
     * @param key
     * @param value
     * @return
     */
    private boolean paramCheck(String system, String env, String key, String value) {
        SaturnLoggerUtils.info(logger, "【参数校验】system:", system, "env:", env, "key:", key, "value",
            value);
        if (StringUtils.isBlank(system) || StringUtils.isBlank(env) || StringUtils.isBlank(key)
            || StringUtils.isBlank(value)) {
            return false;
        }
        return true;
    }

    public void setBasicInfoService(BasicInfoService basicInfoService) {
        this.basicInfoService = basicInfoService;
    }

    public void setConfigInfoService(ConfigInfoService configInfoService) {
        this.configInfoService = configInfoService;
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

}
