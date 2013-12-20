package com.hrxc.auction.action;

import com.hrxc.auction.dao.GoodsListDao;
import com.hrxc.auction.domain.GoodsList;
import com.hrxc.auction.domain.vo.GoodsListVo;
import com.hrxc.auction.util.MyTableConfig;
import com.hrxc.auction.util.UITools;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class GoodsListAction {

    private static final Logger log = Logger.getLogger(GoodsListAction.class);
    private static final GoodsListDao dao = new GoodsListDao();

    /**
     * 根据拍品编号获取拍品信息
     *
     * @param projectNo
     * @param goodsNo
     * @return
     */
    public static GoodsList getGoodsListByGoodsNo(String projectNo, String goodsNo) {
        GoodsList dto = null;
        try {
            GoodsListVo condition = new GoodsListVo();
            condition.setProjectNo(projectNo);
            condition.setGoodsNo(goodsNo);
            List<GoodsList> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                dto = list.get(0);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return dto;
    }

    /**
     *
     * @param condition
     * @return
     */
    public static Object[][] getAllTableData(GoodsListVo condition) {
        Object[][] data = null;
        try {
            List<GoodsList> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                data = UITools.List2TableData(list,MyTableConfig.GoodsList.columns);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    /**
     * 保存或新增数据信息
     *
     * @param dto
     */
    public static void saveOrUpdateObject(GoodsList dto) {
        try {
            if (StringUtils.isNotEmpty(dto.getPkId())) {
                dao.updateObjectById(dto);
            } else {
                dto.setPkId(UITools.generateUUID());
                dao.insertObject(dto);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }
    
    /**
     * 批量添加数据
     * @param list 
     */
    public static void batchSaveObject(ArrayList<GoodsList> list){
        dao.insertObject(list);
    }

    /**
     * 根据主键查询数据信息
     *
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
     *
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
