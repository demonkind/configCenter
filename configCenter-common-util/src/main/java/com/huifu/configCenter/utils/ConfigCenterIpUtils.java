package com.huifu.configCenter.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

/**
 * ConfigCenterID规则：
 * 
 * 长度32位
 * 
 * 
 * @author zhanghaijie
 * @version $Id: ConfigCenterIpUtils.java, v 0.1 2012-8-28 下午5:20:53 zhanghaijie Exp $
 */
public class ConfigCenterIpUtils {

    /**
     * 
     * @param sequence
     * @return
     */
    public static String generateID(String sequence) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String pre = sdf.format(cal.getTime());
        String lastSeq = StringUtils.leftPad(sequence, 8, "0");

        StringBuffer id = new StringBuffer();
        id.append(pre);
        id.append(lastSeq);
        return id.toString();
    }

}
