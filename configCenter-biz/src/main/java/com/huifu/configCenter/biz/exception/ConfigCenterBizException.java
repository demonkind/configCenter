package com.huifu.configCenter.biz.exception;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigCenterBizException.java, v 0.1 2012-8-29 下午1:19:22 zhanghaijie Exp $
 */
public class ConfigCenterBizException extends Exception {

    /**  */
    private static final long serialVersionUID = -2478341630978834575L;

    public ConfigCenterBizException() {
        super();
    }

    public ConfigCenterBizException(String code) {
        super(code);
    }

    public ConfigCenterBizException(String code, Throwable e) {
        super(code, e);
    }

}
