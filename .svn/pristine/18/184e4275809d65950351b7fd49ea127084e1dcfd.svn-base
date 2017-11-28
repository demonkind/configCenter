package com.huifu.configCenter.service.config.impl;

import org.apache.log4j.Logger;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.huifu.cache.client.CPCacheClient;
import com.huifu.configCenter.dal.dao.CConfigInfoDAO;
import com.huifu.configCenter.dal.model.CConfigInfoDO;
import com.huifu.configCenter.service.config.ConfigInfoService;
import com.huifu.configCenter.service.core.converter.ConfigMapperInfoConverter;
import com.huifu.configCenter.service.core.model.ConfigBasicInfo;
import com.huifu.configCenter.service.core.model.ConfigMapperInfo;
import com.huifu.configCenter.service.utils.CacheUtils;
import com.huifu.configCenter.utils.ConfigCenterIpUtils;
import com.huifu.saturn.common.utils.SaturnLoggerUtils;

/**
 * 
 * @author zhanghaijie
 * @version $Id: ConfigInfoServiceImpl.java, v 0.1 2012-10-15 下午08:03:05 zhanghaijie Exp $
 */
public class ConfigInfoServiceImpl implements ConfigInfoService {

    private static final Logger logger = Logger.getLogger(ConfigInfoServiceImpl.class);

    private CConfigInfoDAO      cConfigInfoDAO;

    private CPCacheClient       cpCacheClient;

    private TransactionTemplate transactionTemplate;

    /** 
     * @see com.huifu.configCenter.service.config.ConfigInfoService#addConfigInfo(com.huifu.configCenter.service.core.model.ConfigMapperInfo)
     */
    @Override
    public void addConfigInfo(final ConfigMapperInfo configMapperInfo) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                removeCache(configMapperInfo.getBasicInfo());
                String sequence = cConfigInfoDAO.getSequenceForUpdate();
                String configID = ConfigCenterIpUtils.generateID(sequence);
                configMapperInfo.setConfigId(configID);
                SaturnLoggerUtils.info(logger, "【添加配置信息】配置信息：", configMapperInfo.toString());
                CConfigInfoDO cConfigInfoDO = ConfigMapperInfoConverter
                    .converterFromModelToDo(configMapperInfo);
                cConfigInfoDAO.addConfigInfo(cConfigInfoDO);
            }
        });
    }

    /** 
     * @see com.huifu.configCenter.service.config.ConfigInfoService#modifyConfigInfo(com.huifu.configCenter.service.core.model.ConfigMapperInfo)
     */
    @Override
    public void modifyConfigInfo(final ConfigMapperInfo configMapperInfo) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                removeCache(configMapperInfo.getBasicInfo());
                SaturnLoggerUtils.info(logger, "【更新配置信息】配置信息：", configMapperInfo.toString());
                CConfigInfoDO cConfigInfoDO = ConfigMapperInfoConverter
                    .converterFromModelToDo(configMapperInfo);
                cConfigInfoDAO.updateConfigInfo(cConfigInfoDO);
            }
        });
    }

    /**
     * 
     * @param basicInfo
     */
    private void removeCache(ConfigBasicInfo basicInfo) {
        String key = CacheUtils.getConfigInfoKey(basicInfo.getProjectName(),
            basicInfo.getEnvironment());
        cpCacheClient.removeObject(key);
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setcConfigInfoDAO(CConfigInfoDAO cConfigInfoDAO) {
        this.cConfigInfoDAO = cConfigInfoDAO;
    }

    public void setCpCacheClient(CPCacheClient cpCacheClient) {
        this.cpCacheClient = cpCacheClient;
    }

	@Override
	public CConfigInfoDO get(String key) {
		return cConfigInfoDAO.getByKey(key);
	}

}
