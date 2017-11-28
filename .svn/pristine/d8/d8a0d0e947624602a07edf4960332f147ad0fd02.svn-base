package com.huifu.configCenter.service.config.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.huifu.cache.client.CPCacheClient;
import com.huifu.configCenter.dal.dao.CBasicInfoDAO;
import com.huifu.configCenter.dal.dao.CConfigInfoDAO;
import com.huifu.configCenter.dal.model.CBasicInfoDO;
import com.huifu.configCenter.dal.model.CConfigInfoDO;
import com.huifu.configCenter.service.config.BasicInfoService;
import com.huifu.configCenter.service.core.converter.ConfigBasicInfoConverter;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigMapperInfo;
import com.huifu.configCenter.service.utils.CacheUtils;
import com.huifu.configCenter.utils.ConfigCenterIpUtils;

/**
 * 
 * @author zhanghaijie
 * @version $Id: BasicInfoServiceImpl.java, v 0.1 2012-8-28 下午5:15:58 zhanghaijie Exp $
 */
public class BasicInfoServiceImpl implements BasicInfoService {

    private CBasicInfoDAO       cBasicInfoDAO;

    private CConfigInfoDAO      cConfigInfoDAO;

    private CPCacheClient       cpCacheClient;

    private TransactionTemplate transactionTemplate;

    /** 
     * @see com.chinapnr.configCenter.service.config.BasicInfoService#createSystemInfo(com.chinapnr.configCenter.core.model.ConfigBasicInfo)
     */
    public void createSystemInfo(final ConfigBasicInfo configBasicInfo) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                CBasicInfoDO cBasicInfoDO = ConfigBasicInfoConverter
                    .converterFromModelToDo(configBasicInfo);
                String sequence = cBasicInfoDAO.getSequenceForUpdate();
                String id = ConfigCenterIpUtils.generateID(sequence);
                cBasicInfoDO.setBasicId(id);
                cBasicInfoDAO.saveBasicInfo(cBasicInfoDO);
            }
        });

    }

    /** 
     * @see com.chinapnr.configCenter.service.config.BasicInfoService#getConfigBasicInfo(java.lang.String)
     */
    public ConfigBasicInfo getConfigBasicInfo(String systemName, String env) {
        CBasicInfoDO basicInfoDO = cBasicInfoDAO.getBasicInfoBySystem(systemName, env);
        ConfigBasicInfo configBasicInfo = ConfigBasicInfoConverter.converterFromDoToModel(
            basicInfoDO, null, null);
        return configBasicInfo;
    }

    /** 
     * @see com.chinapnr.configCenter.service.config.BasicInfoService#getConfigBasicInfoByIP(java.lang.String)
     */
    public List<ConfigBasicInfo> getConfigBasicInfoByIP(String ip) {
        List<CBasicInfoDO> basicInfoDOs = cBasicInfoDAO.getBasicInfoByIP(ip);
        List<ConfigBasicInfo> configBasicInfos = new LinkedList<ConfigBasicInfo>();
        for (CBasicInfoDO basicInfoDO : basicInfoDOs) {
            ConfigBasicInfo configBasicInfo = ConfigBasicInfoConverter.converterFromDoToModel(
                basicInfoDO, null, null);
            configBasicInfos.add(configBasicInfo);
        }
        return configBasicInfos;
    }

    /** 
     * @see com.huifu.configCenter.service.config.BasicInfoService#getConfigInfo(java.lang.String, java.lang.String)
     */
    @Override
    public ConfigBasicInfo getConfigInfo(String systemName, String env) {
        String key = CacheUtils.getConfigInfoKey(systemName, env);
        ConfigBasicInfo configBasicInfo = (ConfigBasicInfo) cpCacheClient.getObject(key);
        if (null == configBasicInfo) {
            configBasicInfo = getConfigInfoFromDB(systemName, env);
        }
        return configBasicInfo;
    }

    /**
     * 
     * @param systemName
     * @param env
     * @return
     */
    private ConfigBasicInfo getConfigInfoFromDB(String systemName, String env) {
        CBasicInfoDO basicInfoDO = cBasicInfoDAO.getBasicInfoBySystem(systemName, env);
        if (null == basicInfoDO) {
            return null;
        }

        String basicId = basicInfoDO.getBasicId();
        List<CConfigInfoDO> cConfigInfoDOs = cConfigInfoDAO.getConfigInfoByBasicID(basicId);

        ConfigBasicInfo configBasicInfo = ConfigBasicInfoConverter.converterFromDoToModel(
            basicInfoDO, null, cConfigInfoDOs);

        String key = CacheUtils.getConfigInfoKey(systemName, env);

        cpCacheClient.putObject(key, configBasicInfo);
        return configBasicInfo;
    }

    /** 
     * @see com.huifu.configCenter.service.config.BasicInfoService#getConfigInfo(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public ConfigBasicInfo getConfigInfo(String systemName, String env, String key) {
        String cachKey = CacheUtils.getConfigInfoKey(systemName, env);
        ConfigBasicInfo configBasicInfo = (ConfigBasicInfo) cpCacheClient.getObject(cachKey);
        if (null == configBasicInfo) {
            configBasicInfo = getConfigInfoFromDB(systemName, env);
        }
        if (configBasicInfo != null) {
        	List<ConfigMapperInfo> mapperInfos = configBasicInfo.getMapperInfo();
            if (null != mapperInfos && mapperInfos.size() > 0) {
                for (ConfigMapperInfo configMapperInfo : mapperInfos) {
                    if (StringUtils.equals(configMapperInfo.getKey(), key)) {
                        mapperInfos.clear();
                        mapperInfos.add(configMapperInfo);
                        return configBasicInfo;
                    }
                }
            }
        }
        return null;
    }

    public void setcConfigInfoDAO(CConfigInfoDAO cConfigInfoDAO) {
        this.cConfigInfoDAO = cConfigInfoDAO;
    }

    public void setcBasicInfoDAO(CBasicInfoDAO cBasicInfoDAO) {
        this.cBasicInfoDAO = cBasicInfoDAO;
    }

    public void setCpCacheClient(CPCacheClient cpCacheClient) {
        this.cpCacheClient = cpCacheClient;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

}