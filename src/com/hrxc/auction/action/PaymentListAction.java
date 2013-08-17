package com.hrxc.auction.action;

import com.hrxc.auction.dao.PaymentListDao;
import com.hrxc.auction.domain.PaymentList;
import com.hrxc.auction.domain.vo.PaymentListVo;
import com.hrxc.auction.util.UITools;
import com.hrxc.auction.util.DictEnum;
import com.hrxc.auction.util.MyTableConfig;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author maochangming
 */
public class PaymentListAction {

    private static final Logger log = Logger.getLogger(PaymentListAction.class);
    private static final PaymentListDao dao = new PaymentListDao();

    /**
     * 根据条件查询数据信息
     *
     * @return
     */
    public static Object[][] getAllTableData(PaymentListVo condition) {
        Object[][] data = null;
        try {
            List<PaymentList> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                data = UITools.List2TableData(list,MyTableConfig.PaymentList.columns);
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
    public static void saveOrUpdateObject(PaymentList dto) {
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
     * 根据主键查询数据信息
     *
     * @param pkId
     * @return
     */
    public static PaymentList getObjectById(String pkId) {
        PaymentList dto = null;
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
