package com.hrxc.auction.dao;

import com.hrxc.auction.domain.BiddingPaddle;
import com.hrxc.auction.domain.vo.BiddingPaddleVo;
import com.hrxc.auction.util.MyBatisUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class BiddingPaddleDao {

    private static final Logger log = Logger.getLogger(BiddingPaddleDao.class);

    public List getAllObjectInfo(BiddingPaddleVo condition) {
        return (List<BiddingPaddle>) MyBatisUtils.selectList("BiddingPaddle.getAllObjectInfo", condition);
    }

    public BiddingPaddle getSinglePaddleInfo(BiddingPaddleVo condition) {
        return (BiddingPaddle) MyBatisUtils.selectOne("BiddingPaddle.getAllObjectInfo", condition);
    }

    /**
     * 根据主键获取数据信息
     *
     * @param pkId
     * @return
     */
    public BiddingPaddle getObjectById(String pkId) {
        BiddingPaddleVo condition = new BiddingPaddleVo();
        condition.setPkId(pkId);
        return (BiddingPaddle) MyBatisUtils.selectOne("BiddingPaddle.getAllObjectInfo", condition);
    }

    /**
     * 根据主键删除数据
     *
     * @param list
     */
    public void deleteObjectById(ArrayList<String> list) {
        MyBatisUtils.deleteOnTransaction("BiddingPaddle.deleteObjectById", list);
    }

    public int insertObject(BiddingPaddle dto) {
        return MyBatisUtils.insert("BiddingPaddle.insertObject", dto);
    }

    public int updateObjectById(BiddingPaddle dto) {
        return MyBatisUtils.update("BiddingPaddle.updateObjectById", dto);
    }
}
