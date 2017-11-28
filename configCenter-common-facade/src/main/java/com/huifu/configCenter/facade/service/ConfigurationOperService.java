package com.huifu.configCenter.facade.service;

/**
 * 配置信息操作服务
 * 
 * @author zhanghaijie
 * @version $Id: ConfigurationOperService.java, v 0.1 2012-10-16 上午08:47:30 zhanghaijie Exp $
 */
public interface ConfigurationOperService {

    /**
     * 添加配置信息
     * <br>
     * 返回格式，String,错误码
     * 
     * 返回码说明：000返回成功 060请求参数格式非法 071数据已存在 099系统异常
     * 
     * @param system
     * @param env
     * @param key
     * @param value
     * @return
     */
    public String addConfiguration(String system, String env, String key, String value);

    /**
     * 更新配置信息
      * <br>
     * 返回格式，String,错误码
     * 
     * 返回码说明：000返回成功 060请求参数格式非法 099系统异常
     * 
     * @param system
     * @param env
     * @param key
     * @param value
     * @return
     */
    public String modifyConfiguration(String system, String env, String key, String value);
}
