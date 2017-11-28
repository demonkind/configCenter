package com.huifu.configCenter.service.core.constants;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigCenterCodeEnum.java, v 0.1 2012-8-28 下午2:05:33 zhanghaijie Exp $
 */
public enum ConfigCenterCodeEnum {

    SUCCESS("000", "执行成功"),

    REQUEST_PARAMS_ERROR("060", "请求数据格式非法"),

    RECORD_NOT_EXISTED("070", "数据不存在"),

    SYSTEM_ERROR("099", "系统异常");

    private ConfigCenterCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;

    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
