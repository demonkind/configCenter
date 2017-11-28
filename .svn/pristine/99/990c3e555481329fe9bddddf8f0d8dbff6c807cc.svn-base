package com.huifu.configCenter.service.config.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.huifu.configCenter.dal.dao.CIpInfoDAO;
import com.huifu.configCenter.dal.model.CIpInfoDO;
import com.huifu.configCenter.service.config.IpConfigService;
import com.huifu.configCenter.service.core.converter.ConfigIpInfoConverter;
import com.huifu.configCenter.service.core.model.ConfigIpInfo;
import com.huifu.configCenter.utils.ConfigCenterIpUtils;

/**
 * 
 * @author zhanghaijie
 * @version $Id: IpInfoServiceImpl.java, v 0.1 2012-8-27 下午8:15:47 zhanghaijie Exp $
 */
public class IpConfigServiceImpl implements IpConfigService {

    private CIpInfoDAO          cIpInfoDAO;

    private TransactionTemplate transactionTemplate;

    public List<ConfigIpInfo> getIpInfo(String systemName, String env, String status) {

        List<CIpInfoDO> ipInfoDOs = cIpInfoDAO.getIpInfosBySystemName(systemName, env, status);
        if (null == ipInfoDOs || ipInfoDOs.size() == 0) {
            return null;
        }

        List<ConfigIpInfo> configIpInfos = new LinkedList<ConfigIpInfo>();
        for (CIpInfoDO ipInfoDO : ipInfoDOs) {
            ConfigIpInfo configIpInfo = ConfigIpInfoConverter
                .converterFromDoToModel(ipInfoDO, null);
            //TODO:缓存处理
            configIpInfos.add(configIpInfo);
        }
        return configIpInfos;
    }

    public void mofidyStatus(final String ip, final String status) {

        //TODO:清除缓存
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                cIpInfoDAO.updateIpStatus(ip, status);
            }
        });
    }

    public void addIp(final ConfigIpInfo configIpInfo) {
        //TODO:清除缓存
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                String sequence = cIpInfoDAO.getSequenceForUpdate();
                String id = ConfigCenterIpUtils.generateID(sequence);
                CIpInfoDO ipInfoDO = ConfigIpInfoConverter.converterFromModelToDO(configIpInfo);
                ipInfoDO.setIpId(id);
                cIpInfoDAO.addIp(ipInfoDO);
            }
        });
    }

    public ConfigIpInfo getConfigIpInfoByIp(String ip) {
        CIpInfoDO cIpInfoDO = cIpInfoDAO.getIpInfoByIp(ip);
        ConfigIpInfo configIpInfo = ConfigIpInfoConverter.converterFromDoToModel(cIpInfoDO, null);
        return configIpInfo;
    }

    public void setcIpInfoDAO(CIpInfoDAO cIpInfoDAO) {
        this.cIpInfoDAO = cIpInfoDAO;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

}
