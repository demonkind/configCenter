package com.chinapnr.configCenter.biz.test.facade;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

import org.codehaus.xfire.client.Client;

/**
 * 
 * @author zhanghaijie
 * @version $Id: CaptchaCenterFacadeTest.java, v 0.1 2012-11-22 上午10:33:58 zhanghaijie Exp $
 */
public class CaptchaCenterFacadeTest extends TestCase {
    public void test() throws MalformedURLException, Exception {
        Client client = new Client(new URL(
            "http://192.168.0.73:8081/configCenter/services/configurationService?wsdl"));
        Object ob[] = client.invoke("getConfiguration", new Object[] { "ubs", "dev" });
        String xml = (String) ob[0];
        System.out.println(xml);

    }
}
