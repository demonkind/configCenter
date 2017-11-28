package com.huifu.configCenter.service.core.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigMapperInfo.java, v 0.1 2012-8-27 下午2:49:01 zhanghaijie Exp $
 */
public class ConfigMapperInfo implements Serializable {

    /**  */
    private static final long serialVersionUID = 6059598108286735845L;

    private String          configId;

    private String          key;

    private String          value;

    private String          memo;

    private String            gmtCreate;

    private String            gmtModify;

    private ConfigBasicInfo basicInfo;

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

	public ConfigBasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(ConfigBasicInfo basicInfo) {
        this.basicInfo = basicInfo;
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
