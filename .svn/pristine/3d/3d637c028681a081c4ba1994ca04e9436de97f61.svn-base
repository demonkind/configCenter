package com.huifu.configCenter.biz.ws.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huifu.configCenter.biz.config.IpConfigBiz;
import com.huifu.configCenter.biz.exception.ConfigCenterBizException;
import com.huifu.configCenter.biz.util.ConfigurationServiceUtil;
import com.huifu.configCenter.biz.ws.model.ConfigCenterRespResult;
import com.huifu.configCenter.facade.service.IpInfoService;
import com.huifu.configCenter.service.config.IpConfigService;
import com.huifu.configCenter.service.core.constants.ConfigCenterCodeEnum;
import com.huifu.configCenter.service.core.constants.IpStatusEnum;
import com.huifu.configCenter.service.core.model.ConfigIpInfo;
import com.huifu.saturn.common.utils.SaturnLoggerUtils;

/**
 * 
 * @author zhanghaijie
 * @version $Id: IpInfoServiceImpl.java, v 0.1 2012-8-27 下午4:03:00 zhanghaijie Exp $
 */
public class IpInfoServiceImpl implements IpInfoService {

    private static final Logger logger = Logger.getLogger(IpInfoServiceImpl.class);

    private IpConfigService     ipConfigService;

    private IpConfigBiz         ipConfigBiz;

    public String getAvaliableIp(String targetSystem, String env) {
        ConfigCenterRespResult result = new ConfigCenterRespResult();
        if (!paramCheck(targetSystem)) {
            result.setCode(ConfigCenterCodeEnum.REQUEST_PARAMS_ERROR.getCode());
            return ConfigurationServiceUtil.convertFromResultToXML(result);
        }

        try {
            List<ConfigIpInfo> configIpInfos = ipConfigService.getIpInfo(targetSystem, env,
                IpStatusEnum.AVALIABLE.getCode());
            result = ConfigurationServiceUtil.converIpConfigFromListToResult(configIpInfos, targetSystem, env);
        } catch (Exception e) {
            SaturnLoggerUtils.error(logger, e, "【获取集群IP异常】目标系统", targetSystem);
            result.setCode(ConfigCenterCodeEnum.SYSTEM_ERROR.getCode());
            result.setSystemName(targetSystem);
        }

        String xml = ConfigurationServiceUtil.convertFromResultToXML(result);

        return xml;
    }

    private boolean paramCheck(String targetSystem) {
        if (StringUtils.isBlank(targetSystem)) {
            SaturnLoggerUtils.warn(logger, null, "【IP获取失败】目标系统名为空");
            return false;
        }
        return true;
    }

    //TODO:需要对IpConfigBiz依赖做调整,仅作测试用
    public void changeIpStatus(String ip, String status) {
        IpStatusEnum ipStatus = IpStatusEnum.valueByCode(status);
        try {
            ipConfigBiz.updateIpStatus(ip, ipStatus);
        } catch (ConfigCenterBizException e) {
            SaturnLoggerUtils.error(logger, e, "");
        }
    }

    public void setIpConfigService(IpConfigService ipConfigService) {
        this.ipConfigService = ipConfigService;
    }

    public void setIpConfigBiz(IpConfigBiz ipConfigBiz) {
        this.ipConfigBiz = ipConfigBiz;
    }

}
