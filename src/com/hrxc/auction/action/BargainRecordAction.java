package com.hrxc.auction.action;

import com.hrxc.auction.dao.BargainRecordDao;
import com.hrxc.auction.domain.BargainRecord;
import com.hrxc.auction.domain.vo.BargainRecordVo;
import com.hrxc.auction.util.UITools;
import com.hrxc.auction.util.DictEnum;
import com.hrxc.auction.util.MyTableConfig;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class BargainRecordAction {

    private static final Logger log = Logger.getLogger(BargainRecordAction.class);
    private static final BargainRecordDao dao = new BargainRecordDao();

    /**
     * 根据竞拍号牌获取所有成交记录
     *
     * @param projectNo
     * @param paddleNo
     * @return
     */
    public static List<BargainRecord> getBargainRecordListByPaddleNo(String projectNo, String paddleNo) {
        List<BargainRecord> list = null;
        try {
            BargainRecordVo condition = new BargainRecordVo();
            condition.setProjectNo(projectNo);
            condition.setPaddleNo(paddleNo);
            list = dao.getAllObjectInfo(condition);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return list;
    }

    public static List<BargainRecord> getBargainRecordListByPaymentNo(String projectNo, String paymentNo) {
        BargainRecordVo condition = new BargainRecordVo();
        condition.setProjectNo(projectNo);
        condition.setPaymentNo(paymentNo);
        return dao.getAllObjectInfo(condition);
    }

    /**
     *
     * @param condition
     * @return
     */
    public static Object[][] getAllTableData(BargainRecordVo condition) {
        Object[][] data = null;
        try {
            List<BargainRecord> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                data = UITools.List2TableData(list, MyTableConfig.BargainRecord.columns);
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
    public static void saveOrUpdateObject(BargainRecord dto) {
        try {
            if (StringUtils.isNotEmpty(dto.getPkId())) {
                dao.updateObjectById(dto);
            } else {
                dto.setPkId(UITools.generateUUID());
                //默认结算状态为“已成交”
                dto.setSettleState(DictEnum.SettleState.BARGAIN);
                dao.insertObject(dto);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    /**
     * 根据主键查询数据信息
     *
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

    public static int updateSettleState(String settleState, String pkId, String paymentNo) {
        BargainRecord condition = new BargainRecord();
        condition.setSettleState(settleState);
        condition.setPkId(pkId);
        condition.setPaymentNo(paymentNo);
        return dao.updateObjectById(condition);
    }
}
