package com.chinapnr.configCenter.biz.test.ws;

import junit.framework.TestCase;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import com.huifu.configCenter.facade.service.IpInfoService;

public class IpInfoServiceTest extends TestCase {

    private ApplicationContext applicationContext;

    private IpInfoService      ipInfoService;

    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(new String[] {
                "applicationContext-service-config.xml", "applicationContext-dao.xml",
                "applicationContext-biz-ws.xml" });
        ipInfoService = (IpInfoService) applicationContext.getBean("ipInfoService");
    }

    public void test() {
        System.out.println(ipInfoService.getAvaliableIp("Test", "DEV"));
    }

}
