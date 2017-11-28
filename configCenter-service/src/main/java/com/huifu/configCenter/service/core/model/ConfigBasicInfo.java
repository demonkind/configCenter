package com.huifu.configCenter.service.core.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigBasicInfo.java, v 0.1 2012-8-27 下午2:43:11 zhanghaijie Exp $
 */
public class ConfigBasicInfo implements Serializable {

    /**  */
    private static final long      serialVersionUID = 1710128176860128262L;

    private String                 basicId;

    private String                 projectName;

    private String                 version;

    private String                 environment;

    private String                 memo;

    private String                   gmtModify;

    private String                   gmtCreate;

    private List<ConfigIpInfo>     ipInfos;

    private List<ConfigMapperInfo> mapperInfo;

    public String getBasicId() {
        return basicId;
    }

    public void setBasicId(String basicId) {
        this.basicId = basicId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(String gmtModify) {
		this.gmtModify = gmtModify;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public List<ConfigIpInfo> getIpInfos() {
        return ipInfos;
    }

    public void setIpInfos(List<ConfigIpInfo> ipInfos) {
        this.ipInfos = ipInfos;
    }

    public List<ConfigMapperInfo> getMapperInfo() {
        return mapperInfo;
    }

    public void setMapperInfo(List<ConfigMapperInfo> mapperInfo) {
        this.mapperInfo = mapperInfo;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
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
