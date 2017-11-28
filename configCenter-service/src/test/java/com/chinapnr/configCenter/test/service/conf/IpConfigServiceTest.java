package com.chinapnr.configCenter.test.service.conf;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huifu.configCenter.service.config.IpConfigService;

public class IpConfigServiceTest extends TestCase {

    private ApplicationContext applicationContext;

    private IpConfigService    ipConfigService;

    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(
            "applicationContext-service-config.xml", "applicationContext-dao.xml");
        ipConfigService = (IpConfigService) applicationContext.getBean("ipConfigService");
    }

    public void testGetIpInfoBySystemName() {
    }
}
