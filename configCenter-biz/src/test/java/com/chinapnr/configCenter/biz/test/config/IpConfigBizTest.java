package com.chinapnr.configCenter.biz.test.config;

import junit.framework.TestCase;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

import com.huifu.configCenter.biz.config.IpConfigBiz;
import com.huifu.configCenter.biz.exception.ConfigCenterBizException;
import com.huifu.configCenter.service.core.constants.IpStatusEnum;

public class IpConfigBizTest extends TestCase {

    private ApplicationContext applicationContext;

    private IpConfigBiz        ipConfigBiz;

    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(new String[] {
                "applicationContext-biz-config.xml", "applicationContext-dao.xml",
                "applicationContext-service-config.xml", "applicationContext-resources-jdbc.xml" });
        ipConfigBiz = (IpConfigBiz) applicationContext.getBean("ipConfigBiz");
    }

    public void test() throws ConfigCenterBizException {
        System.out.println(ipConfigBiz);
        System.out.println((IpConfigBiz) applicationContext.getBean("ipConfigBiz"));
        //ipConfigBiz.updateIpStatus("localhost", IpStatusEnum.INAVALIABLE);
    }
}
