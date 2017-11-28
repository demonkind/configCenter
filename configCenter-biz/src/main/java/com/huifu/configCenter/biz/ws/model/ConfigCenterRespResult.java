package com.huifu.configCenter.biz.ws.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 配置中心响应信息
 * 
 * @author zhanghaijie
 * @version $Id: ConfigCenterRespResult.java, v 0.1 2012-9-5 下午03:00:28 zhanghaijie Exp $
 */
@XStreamAlias("configCenter")
public class ConfigCenterRespResult implements Serializable {

    /**  */
    private static final long serialVersionUID = -3616230654163631878L;

    @XStreamAlias("respCode")
    private String            code;

    @XStreamAlias("systemName")
    private String            systemName;

    @XStreamAlias("environment")
    private String            environment;

    @XStreamAlias("ip")
    private String            ip;

    @XStreamAlias("configuration")
    private String            config;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

}
