/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.action;

import com.hrxc.auction.dao.GoodsListDao;
import com.hrxc.auction.domain.GoodsList;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class GoodsListAction {

    private static final Logger log = Logger.getLogger(GoodsListAction.class);
    private static final GoodsListDao dao = new GoodsListDao();


    /**
     * 根据条件查询数据信息
     * @param goodsNo
     * @param goodsName
     * @return 
     */
    public static Object[][] getAllTableData(String goodsNo, String goodsName) {
        Object[][] data = null;
        try {
            List<GoodsList> list = dao.getAllObjectInfo(goodsNo, goodsName);
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    private static Object[][] List2TableData(List<GoodsList> list) {
        Object[][] data = new String[list.size()][GoodsListTableConfig.tableColumnNames.length];
        for (int i = 0; i < list.size(); i++) {
            int seq = 0;
            GoodsList dto = list.get(i);
            data[i][seq++] = null;
            data[i][seq++] = dto.getPkId();
            data[i][seq++] = String.valueOf(i + 1);
            data[i][seq++] = dto.getGoodsNo();
            data[i][seq++] = dto.getGoodsName();
            data[i][seq++] = dto.getGoodsIntact();
            data[i][seq++] = dto.getGoodsSize();
            data[i][seq++] = dto.getCertificateNo();
            data[i][seq++] = dto.getKeepPrice();
            data[i][seq++] = dto.getMarketPrice();
            data[i][seq++] = dto.getOnsetPrice();
        }
        return data;
    }

    /**
     * 保存或新增数据信息
     * @param dto 
     */
    public static void saveOrUpdateObject(GoodsList dto) {
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
    public static GoodsList getObjectById(String pkId) {
        GoodsList dto = null;
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
