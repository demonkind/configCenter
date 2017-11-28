package com.huifu.configCenter.dal.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zhanghaijie
 * @version $Id: CIpInfoDO.java, v 0.1 2012-8-27 下午2:24:16 zhanghaijie Exp $
 */
public class CIpInfoDO implements Serializable {

    /**  */
    private static final long serialVersionUID = -1578912555702370551L;

    private String            ipId;

    private String            ip;

    private String            mac;

    private String            status;

    private String            basicId;

    private String            port;

    private String              gmtCreate;

    private String              gmtModify;

    private String            memo;

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

    public String getBasicId() {
        return basicId;
    }

    public void setBasicId(String basicId) {
        this.basicId = basicId;
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

}
