package com.huifu.configCenter.biz.ws.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huifu.configCenter.biz.util.ConfigurationServiceUtil;
import com.huifu.configCenter.biz.ws.model.ConfigCenterRespResult;
import com.huifu.configCenter.facade.service.ConfigurationService;
import com.huifu.configCenter.service.config.BasicInfoService;
import com.huifu.configCenter.service.core.constants.ConfigCenterCodeEnum;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.saturn.common.utils.SaturnLoggerUtils;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigurationServiceImpl.java, v 0.1 2012-9-5 下午02:34:38 zhanghaijie Exp $
 */
public class ConfigurationServiceImpl implements ConfigurationService {

    private static final Logger logger = Logger.getLogger(ConfigurationServiceImpl.class);

    private BasicInfoService    basicInfoService;

    /** 
     * @see com.huifu.configCenter.facade.service.ConfigurationService#getConfiguration(java.lang.String, java.lang.String)
     */
    @Override
    public String getConfiguration(String system, String env) {
        ConfigCenterRespResult result = new ConfigCenterRespResult();
        if (!paramCheck(system, env)) {
            result.setCode(ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode());
            return ConfigurationServiceUtil.convertFromResultToXML(result);
        }

        try {
            ConfigBasicInfo configBasicInfo = basicInfoService.getConfigInfo(system, env);
            result = ConfigurationServiceUtil.convertConfigFromConfigBasicInfoToResult(system, env,
                configBasicInfo);
        } catch (Exception e) {
            SaturnLoggerUtils.error(logger, e, "【获取配置信息】目标系统：", system, "环境:", env);
            result.setCode(ConfigCenterCodeEnum.SYSTEM_ERROR.getCode());
            result.setSystemName(system);
        }

        String xml = ConfigurationServiceUtil.convertFromResultToXML(result);
        return xml;
    }

    /** 
     * @see com.huifu.configCenter.facade.service.ConfigurationService#getConfiguration(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String getConfiguration(String system, String env, String key) {
        ConfigCenterRespResult result = new ConfigCenterRespResult();
        if (!paramCheck(system, env)) {
            result.setCode(ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode());
            return ConfigurationServiceUtil.convertFromResultToXML(result);
        }

        try {
            ConfigBasicInfo configBasicInfo = basicInfoService.getConfigInfo(system, env, key);
            result = ConfigurationServiceUtil.convertConfigFromConfigBasicInfoToResult(system, env,
                configBasicInfo);
        } catch (Exception e) {
            SaturnLoggerUtils.error(logger, e, "【获取配置信息】目标系统：", system, "环境:", env);
            result.setCode(ConfigCenterCodeEnum.SYSTEM_ERROR.getCode());
            result.setSystemName(system);
        }

        String xml = ConfigurationServiceUtil.convertFromResultToXML(result);
        return xml;
    }

    public void setBasicInfoService(BasicInfoService basicInfoService) {
        this.basicInfoService = basicInfoService;
    }

    /**
     * 
     * @param system
     * @param env
     * @return
     */
    private boolean paramCheck(String system, String env) {
        if (StringUtils.isBlank(system)) {
            SaturnLoggerUtils.warn(logger, null, "【系统配置】系统名为空");
            return false;
        }

        if (StringUtils.isBlank(env)) {
            SaturnLoggerUtils.warn(logger, null, "【系统配置】系统环境为空");
            return false;
        }
        return true;
    }

}
