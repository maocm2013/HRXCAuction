package com.hrxc.auction.action;

import com.hrxc.auction.dao.BiddingPaddleDao;
import com.hrxc.auction.domain.BiddingPaddle;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class BiddingPaddleAction {

    private static final Logger log = Logger.getLogger(BiddingPaddleAction.class);
    private static final BiddingPaddleDao dao = new BiddingPaddleDao();


    /**
     * 根据条件查询数据信息
     * @param projectNo
     * @param paddleNo
     * @param custName
     * @return 
     */
    public static Object[][] getAllTableData(String projectNo,String paddleNo, String custName) {
        Object[][] data = null;
        try {
            List<BiddingPaddle> list = dao.getAllObjectInfo(projectNo,paddleNo, custName);
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    private static Object[][] List2TableData(List<BiddingPaddle> list) {
        Object[][] data = new Object[list.size()][BiddingPaddleTableConfig.tableColumnNames.length];
        for (int i = 0; i < list.size(); i++) {
            int seq = 0;
            BiddingPaddle dto = list.get(i);
            data[i][seq++] = null;
            data[i][seq++] = dto.getPkId();
            data[i][seq++] = String.valueOf(i + 1);
            data[i][seq++] = dto.getPaddleNo();
            data[i][seq++] = dto.getCustName();
            data[i][seq++] = dto.getCertType();
            data[i][seq++] = dto.getCertNo();
            data[i][seq++] = dto.getCustTel();
            data[i][seq++] = dto.getCustAddr();
            data[i][seq++] = dto.getCashDeposit();
            data[i][seq++] = dto.getRemarks();
            data[i][seq++] = dto.getProjectNo();
        }
        return data;
    }

    /**
     * 保存或新增数据信息
     * @param dto 
     */
    public static void saveOrUpdateObject(BiddingPaddle dto) {
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
