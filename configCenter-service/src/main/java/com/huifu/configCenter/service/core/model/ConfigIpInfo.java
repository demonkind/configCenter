package com.huifu.configCenter.service.core.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigIpInfo.java, v 0.1 2012-8-27 下午2:45:39 zhanghaijie Exp $
 */
public class ConfigIpInfo implements Serializable {

    /**  */
    private static final long serialVersionUID = -3336822705368933194L;

    private String            ipId;

    private String            ip;

    private String            mac;

    private String            status;

    private String            port;

    private String            memo;

    private String              gmtCreate;

    private String              gmtModify;

    private ConfigBasicInfo   basicInfo;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ConfigBasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(ConfigBasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(String gmtModify) {
		this.gmtModify = gmtModify;
	}

	public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIpId() {
        return ipId;
    }

    public void setIpId(String ipId) {
        this.ipId = ipId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
