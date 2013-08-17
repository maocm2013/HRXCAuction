package com.hrxc.auction.action;

import com.hrxc.auction.dao.BiddingPaddleDao;
import com.hrxc.auction.domain.BiddingPaddle;
import com.hrxc.auction.domain.vo.BiddingPaddleVo;
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
public class BiddingPaddleAction {

    private static final Logger log = Logger.getLogger(BiddingPaddleAction.class);
    private static final BiddingPaddleDao dao = new BiddingPaddleDao();

    /**
     * 根据项目编号及号牌编号获取号牌信息
     * @param projectNo
     * @param paddleNo
     * @return 
     */
    public static BiddingPaddle getPaddleInfoByNo(String projectNo,String paddleNo){
        BiddingPaddleVo condition = new BiddingPaddleVo();
        condition.setProjectNo(projectNo);
        condition.setPaddleNo(paddleNo);
        return dao.getSinglePaddleInfo(condition);
    }
    
    /**
     * 根据条件查询数据信息
     *
     * @return
     */
    public static Object[][] getAllTableData(BiddingPaddleVo condition) {
        Object[][] data = null;
        try {
            List<BiddingPaddle> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                data = UITools.List2TableData(list,MyTableConfig.BiddingPaddle.columns);
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
    public static void saveOrUpdateObject(BiddingPaddle dto) {
        try {
            if (StringUtils.isNotEmpty(dto.getPkId())) {
                dao.updateObjectById(dto);
            } else {
                dto.setPkId(UITools.generateUUID());
                //默认保证金使用状态为“未使用”
                dto.setCashDepositState(DictEnum.CashDepositState.NOT_USE);
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
    public static BiddingPaddle getObjectById(String pkId) {
        BiddingPaddle dto = null;
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
