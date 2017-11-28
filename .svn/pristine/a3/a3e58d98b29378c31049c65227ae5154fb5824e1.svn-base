package com.huifu.configCenter.service.utils;

import com.huifu.configCenter.service.core.constants.ConfigCenterConstants;

/**
 * 
 * @author zhanghaijie
 * @version $Id: CacheUtils.java, v 0.1 2012-10-15 下午09:08:43 zhanghaijie Exp $
 */
public class CacheUtils {

    /**
     * 获取配置缓存KEY
     * 
     * @param systemName
     * @param env
     * @return
     */
    public static String getConfigInfoKey(String systemName, String env) {
        StringBuffer key = new StringBuffer(ConfigCenterConstants.CACHE_CONFIG_PREX);
        key.append(systemName);
        key.append("_");
        key.append(env);
        return key.toString();
    }
}
