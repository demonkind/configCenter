package com.huifu.configCenter.biz.config.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huifu.configCenter.biz.config.IpConfigBiz;
import com.huifu.configCenter.biz.exception.ConfigCenterBizException;
import com.huifu.configCenter.biz.util.ConfigurationServiceUtil;
import com.huifu.configCenter.service.config.BasicInfoService;
import com.huifu.configCenter.service.config.IpConfigService;
import com.huifu.configCenter.service.core.constants.IpStatusEnum;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigIpInfo;
import com.huifu.saturn.common.constants.code.respCode.SaturnBasicRespCode;
import com.huifu.saturn.common.constants.constants.SaturnCommonConstants;
import com.huifu.saturn.common.utils.SaturnLoggerUtils;
import com.huifu.saturn.runtime.mq.sender.MessageSender;

/**
 * 
 * @author zhanghaijie
 * @version $Id: IpConfigBizImpl.java, v 0.1 2012-8-28 下午7:10:54 zhanghaijie Exp $
 */
public class IpConfigBizImpl implements IpConfigBiz {

    private static final Logger logger = Logger.getLogger(IpConfigBizImpl.class);

    private IpConfigService     ipConfigService;

    private BasicInfoService    basicInfoService;

    private MessageSender       messageSender;

    public void addIp(String system, String env, ConfigIpInfo configIpInfo)
                                                                           throws ConfigCenterBizException {
        if (!addIpParamCheck(system, configIpInfo)) {
            throw new ConfigCenterBizException(
                SaturnBasicRespCode.REQ_PARAMS_ILLEGAL.getReturnCode());
        }

        ConfigBasicInfo configBasicInfo = basicInfoService.getConfigBasicInfo(system, env);
        configIpInfo.setBasicInfo(configBasicInfo);
        ipConfigService.addIp(configIpInfo);

        this.broastCastIpConfiguration(system, env);
    }

    /** 
     * @see com.chinapnr.configCenter.config.IpConfigBiz#updateIpStatus(java.lang.String, com.chinapnr.configCenter.core.constants.IpStatusEnum)
     */
    public void updateIpStatus(String ip, IpStatusEnum status) throws ConfigCenterBizException {
        if (StringUtils.isBlank(ip)) {
            SaturnLoggerUtils.warn(logger, null, "【IP更新异常】传入IP地址为空");
            throw new ConfigCenterBizException(
                SaturnBasicRespCode.REQ_PARAMS_ILLEGAL.getReturnCode());
        }
        ipConfigService.mofidyStatus(ip, status.getCode());
        List<ConfigBasicInfo> configBasicInfos = basicInfoService.getConfigBasicInfoByIP(ip);
        if (null != configBasicInfos && configBasicInfos.size() > 0) {
            for (ConfigBasicInfo configBasicInfo : configBasicInfos) {
                this.broastCastIpConfiguration(configBasicInfo.getProjectName(),
                    configBasicInfo.getEnvironment());
            }
        }

    }

    private boolean addIpParamCheck(String system, ConfigIpInfo configIpInfo) {
        if (StringUtils.isBlank(system)) {
            SaturnLoggerUtils.warn(logger, null, "【IP更新异常】传入system为空", configIpInfo.toString());
            return false;
        }

        if (null == configIpInfo) {
            SaturnLoggerUtils.warn(logger, null, "【IP更新异常】configIpInfo为空", system);
            return false;
        }

        if (StringUtils.isBlank(configIpInfo.getIp()) || StringUtils.isBlank(configIpInfo.getMac())) {
            SaturnLoggerUtils
                .warn(logger, null, "【IP更新异常】configIpInfo不完整", configIpInfo.toString());
            return false;
        }
        return true;
    }

    /**
     * 获取广播信息
     * 
     * @param system
     * @return
     */
    private void broastCastIpConfiguration(String system, String env) {

        List<ConfigIpInfo> avaliableIps = ipConfigService.getIpInfo(system, env,
            IpStatusEnum.AVALIABLE.getCode());

        if (null != avaliableIps && avaliableIps.size() > 0) {
            String xml = ConfigurationServiceUtil.convertIpConfigFromListToXML(avaliableIps,
                system, env);
            this.ipConfigBroadcast(xml);
        }
    }

    /**
     * 
     * @param xml
     */
    private void ipConfigBroadcast(String xml) {
        SaturnLoggerUtils.info(logger, "【配置中心IP广播】Ip配置广播", xml);
        messageSender.send(SaturnCommonConstants.TP_PUB_SUB_CONFIG_IP, xml);
    }

    public void setIpConfigService(IpConfigService ipConfigService) {
        this.ipConfigService = ipConfigService;
    }

    public void setBasicInfoService(BasicInfoService basicInfoService) {
        this.basicInfoService = basicInfoService;
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

}
