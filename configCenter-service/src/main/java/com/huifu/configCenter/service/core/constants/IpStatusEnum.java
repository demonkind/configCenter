package com.huifu.configCenter.service.core.constants;

/**
 * 
 * @author zhanghaijie
 * @version $Id: IpStatusEnum.java, v 0.1 2012-8-28 下午2:57:41 zhanghaijie Exp $
 */
public enum IpStatusEnum {

    AVALIABLE("01", "IP地址有效"),

    INAVALIABLE("02", "IP地址无效");

    private IpStatusEnum(String code, String desc) {
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

    public static IpStatusEnum valueByCode(String code) {
        for (IpStatusEnum ipStatus : IpStatusEnum.values()) {
            if (ipStatus.getCode().equals(code)) {
                return ipStatus;
            }
        }
        return null;
    }
}
