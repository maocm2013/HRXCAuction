/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.action;

import com.hrxc.auction.dao.BargainRecordDao;
import com.hrxc.auction.domain.BargainRecord;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class BargainRecordAction {

    private static final Logger log = Logger.getLogger(BargainRecordAction.class);
    private static final BargainRecordDao dao = new BargainRecordDao();


    /**
     * 根据条件查询数据信息
     * @param paddleNo
     * @param custName
     * @return 
     */
    public static Object[][] getAllTableData(String paddleNo, String custName) {
        Object[][] data = null;
        try {
            List<BargainRecord> list = dao.getAllObjectInfo(paddleNo, custName);
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    private static Object[][] List2TableData(List<BargainRecord> list) {
        Object[][] data = new String[list.size()][BargainRecordTableConfig.tableColumnNames.length];
        for (int i = 0; i < list.size(); i++) {
            int seq = 0;
            BargainRecord dto = list.get(i);
            data[i][seq++] = null;
            data[i][seq++] = dto.getPkId();
            data[i][seq++] = String.valueOf(i + 1);
            data[i][seq++] = dto.getPaddleNo();
            data[i][seq++] = dto.getGoodsNo();
            data[i][seq++] = dto.getBargainConfirmNo();
            data[i][seq++] = dto.getHammerPrice();
            data[i][seq++] = dto.getCommission();
            data[i][seq++] = dto.getOtherFund();
            data[i][seq++] = dto.getBargainPrice();
            data[i][seq++] = dto.getAccountPaid();
            data[i][seq++] = dto.getNonPayment();
        }
        return data;
    }

    /**
     * 保存或新增数据信息
     * @param dto 
     */
    public static void saveOrUpdateObject(BargainRecord dto) {
        try {
            dao.saveOrUpdateObject(dto);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    /**
     * 根据主键查询数据信息
     * @param pkId
     * @return 
     */
    public static BargainRecord getObjectById(String pkId) {
        BargainRecord dto = null;
        try {
            dto = dao.getObjectById(pkId);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return dto;
    }

    /**
     * 主键集合删除数据信息
     * @param list 
     */
    public static void deleteObjectById(ArrayList<String> list) {
        try {
            dao.deleteObjectById(list);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }
}
