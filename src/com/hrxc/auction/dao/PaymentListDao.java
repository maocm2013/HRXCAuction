package com.hrxc.auction.dao;

import com.hrxc.auction.domain.PaymentList;
import com.hrxc.auction.domain.vo.PaymentListVo;
import com.hrxc.auction.util.MyBatisUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author maochangming
 */
public class PaymentListDao {

    private static final Logger log = Logger.getLogger(PaymentListDao.class);

    /**
     *
     * @param vo
     * @return
     */
    public List getAllObjectInfo(PaymentListVo vo) {
        return (List<PaymentList>) MyBatisUtils.selectList("PaymentList.getAllObjectInfo", vo);
    }

    /**
     *
     * @param pkId
     * @return
     */
    public PaymentList getObjectById(String pkId) throws SQLException {
        PaymentListVo vo = new PaymentListVo();
        vo.setPkId(pkId);
        return (PaymentList) MyBatisUtils.selectOne("PaymentList.getAllObjectInfo", vo);
    }

    /**
     * 根据主键删除数据
     *
     * @param list
     */
    public void deleteObjectById(ArrayList<String> list) throws SQLException {
        MyBatisUtils.deleteOnTransaction("PaymentList.deleteObjectById", list);
    }

    public int insertObject(PaymentList dto) {
        return MyBatisUtils.insert("PaymentList.insertObject", dto);
    }

    public int updateObjectById(PaymentList dto) {
        return MyBatisUtils.update("PaymentList.updateObjectById", dto);
    }
}
