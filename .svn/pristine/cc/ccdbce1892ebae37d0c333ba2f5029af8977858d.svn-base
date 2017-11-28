package com.huifu.configCenter.facade.service;

/**
 * <h>配置信息服务</h>
 * 
 * @author zhanghaijie
 * @version $Id: ConfigurationService.java, v 0.1 2012-8-27 下午3:58:59 zhanghaijie Exp $
 */
public interface ConfigurationService {

    /**
     * 通过目标系统获取系统所有配置信息
     *<br>
     *返回格式xml
     * 
     * <br/>
     * 返回码说明：000返回成功 060请求参数格式非法 070请求数据不存在（查询为空）099系统异常
     * 
     * @param system
     * @param env
     * @return
     */
    public String getConfiguration(String system, String env);

    /**
     * 通过目标系统获取系统所有配置信息
     *<br>
     *返回格式xml
     * 
     * <br/>
     * 返回码说明：000返回成功 060请求参数格式非法 070请求数据不存在（查询为空）099系统异常
     * 
     * @param system
     * @param env
     * @param key
     * @return
     */
    public String getConfiguration(String system, String env, String key);

}
