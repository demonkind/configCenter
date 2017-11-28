package com.huifu.configCenter.dal.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author zhanghaijie
 * @version $Id: CBasicInfoDO.java, v 0.1 2012-8-27 下午2:21:50 zhanghaijie Exp $
 */
public class CBasicInfoDO implements Serializable {

    /**  */
    private static final long serialVersionUID = 8059065205286308725L;

    private String            basicId;

    private String            projectName;

    private String            version;

    private String            environment;

    private String            gmtCreate;

    private String            gmtModify;

    private String            memo;

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

}
