package com.huifu.configCenter.biz.util;

import java.util.List;

import org.apache.log4j.Logger;

import com.huifu.configCenter.biz.ws.model.ConfigCenterRespResult;
import com.huifu.configCenter.service.core.constants.ConfigCenterCodeEnum;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigIpInfo;
import com.huifu.configCenter.service.core.model.ConfigMapperInfo;
import com.huifu.saturn.common.utils.SaturnLoggerUtils;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * @author zhanghaijie
 * @version $Id: IpConfigXMLUtil.java, v 0.1 2012-8-30 上午11:01:18 zhanghaijie Exp $
 */
public class ConfigurationServiceUtil {

    private static final Logger logger = Logger.getLogger(ConfigurationServiceUtil.class);

    /**
     * 
     * @param configIpInfos
     * @param sysName
     * @return
     */
    public static String convertIpConfigFromListToXML(List<ConfigIpInfo> configIpInfos,
                                                      String sysName, String env) {
        ConfigCenterRespResult result = converIpConfigFromListToResult(configIpInfos, sysName, env);
        String xml = convertFromResultToXML(result);
        return xml;
    }

    /**
     * 
     * @param configIpInfos
     * @param sysName
     * @return
     */
    public static ConfigCenterRespResult converIpConfigFromListToResult(List<ConfigIpInfo> configIpInfos,
                                                                        String sysName, String env) {
        ConfigCenterRespResult result = new ConfigCenterRespResult();
        result.setSystemName(sysName);
        result.setEnvironment(env);
        if (null == configIpInfos || configIpInfos.size() == 0) {
            SaturnLoggerUtils.warn(logger, null, "【获取集群IP异常】找不到目标系统IP信息", "目标系统", sysName);
            result.setCode(ConfigCenterCodeEnum.RECORD_NOT_EXISTED.getCode());
            return result;
        }

        result.setCode(ConfigCenterCodeEnum.SUCCESS.getCode());
        String ips = convertIpFromListToString(configIpInfos);
        result.setIp(ips);
        return result;
    }

    public static String convertConfigFromConfigBasicInfoToXML(String system, String env,
                                                               ConfigBasicInfo configBasicInfo) {
        ConfigCenterRespResult configCenterRespResult = convertConfigFromConfigBasicInfoToResult(
            system, env, configBasicInfo);
        String xml = convertFromResultToXML(configCenterRespResult);
        return xml;
    }

    /**
     * 
     * @param system
     * @param env
     * @param configBasicInfo
     * @return
     */
    public static ConfigCenterRespResult convertConfigFromConfigBasicInfoToResult(String system,
                                                                                  String env,
                                                                                  ConfigBasicInfo configBasicInfo) {
        ConfigCenterRespResult result = new ConfigCenterRespResult();
        result.setSystemName(system);
        result.setEnvironment(env);
        if (null == configBasicInfo) {
            SaturnLoggerUtils.warn(logger, null, "【获取集群IP异常】找不到目标系统配置信息", "目标系统", system);
            result.setCode(ConfigCenterCodeEnum.RECORD_NOT_EXISTED.getCode());
            return result;
        }

        String ips = convertIpFromListToString(configBasicInfo.getIpInfos());
        String mappers = convertConfigMapperFromListToString(configBasicInfo.getMapperInfo());
        result.setIp(ips);
        result.setConfig(mappers);
        result.setCode(ConfigCenterCodeEnum.SUCCESS.getCode());

        return result;
    }

    /**
     * 
     * @param configIpInfo
     * @return
     */
    public static String convertIpFromListToString(List<ConfigIpInfo> configIpInfo) {
        if (null == configIpInfo || configIpInfo.size() < 0) {
            return null;
        }
        StringBuffer ips = new StringBuffer();
        for (int i = 0; i < configIpInfo.size(); i++) {
            StringBuffer ipWithPort = new StringBuffer();
            ConfigIpInfo config = configIpInfo.get(i);
            ipWithPort.append(config.getIp());
            ipWithPort.append(":");
            ipWithPort.append(config.getPort());
            ips.append(ipWithPort.toString());
            if ((configIpInfo.size() - i) > 1) {
                ips.append(",");
            }
        }
        return ips.toString();
    }

    /**
     * 
     * @param result
     * @return
     */
    public static String convertFromResultToXML(ConfigCenterRespResult result) {
        XStream stream = new XStream();
        stream.processAnnotations(new Class[] { ConfigCenterRespResult.class });
        String resultXML = stream.toXML(result);
        SaturnLoggerUtils.info(logger, "【获取集群IP】XML结果：", resultXML);
        return resultXML;
    }

    /**
     * 
     * @param mapperInfo
     * @return
     */
    /**
     * 
     * @param mapperInfos
     * @return
     */
    private static String convertConfigMapperFromListToString(List<ConfigMapperInfo> mapperInfos) {
        if (null == mapperInfos || mapperInfos.size() < 0) {
            return null;
        }
        StringBuffer config = new StringBuffer();
        for (int i = 0; i < mapperInfos.size(); i++) {
            ConfigMapperInfo configMapperInfo = mapperInfos.get(i);
            config.append(configMapperInfo.getKey());
            config.append("=");
            config.append(configMapperInfo.getValue());
            if ((mapperInfos.size() - i) > 1) {
                config.append(",");
            }
        }
        return config.toString();
    }
}
