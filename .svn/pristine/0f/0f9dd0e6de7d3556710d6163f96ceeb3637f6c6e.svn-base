package com.huifu.configCenter.facade.service;

/**
 * <h>IP地址服务</h>
 * 
 * @author zhanghaijie
 * @version $Id: IpInfoService.java, v 0.1 2012-8-27 下午3:59:38 zhanghaijie Exp $
 */
public interface IpInfoService {

    /**
     * 通过目标系统名，获取目标系统集群中各台可用机器的IP及Mac地址
     * 
     * <br>
     * 返回参数格式XML
     *<br>
     * 
     * 
     * @param targetSystem
     * @return
     */
    public String getAvaliableIp(String targetSystem, String env);

    /**
     * 
     * @param ip
     * @param status
     * @return
     */
    //TODO:仅作测试使用，上线前需要删除
    public void changeIpStatus(String ip, String status);
}
