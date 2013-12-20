package com.hrxc.auction.dao;

import com.hrxc.auction.domain.GoodsList;
import com.hrxc.auction.domain.vo.GoodsListVo;
import com.hrxc.auction.util.MyBatisUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class GoodsListDao {

    /**
     *
     * @param vo
     * @return
     */
    public List getAllObjectInfo(GoodsListVo vo) {
        return (List<GoodsList>) MyBatisUtils.selectList("GoodsList.getAllObjectInfo", vo);
    }

    /**
     *
     * @param pkId
     * @return
     */
    public GoodsList getObjectById(String pkId) throws SQLException {
        GoodsListVo vo = new GoodsListVo();
        vo.setPkId(pkId);
        return (GoodsList) MyBatisUtils.selectOne("GoodsList.getAllObjectInfo", vo);
    }

    /**
     * 根据主键删除数据
     *
     * @param list
     */
    public void deleteObjectById(ArrayList<String> list) throws SQLException {
        MyBatisUtils.deleteOnTransaction("GoodsList.deleteObjectById", list);
    }

    public int insertObject(GoodsList dto) {
        return MyBatisUtils.insert("GoodsList.insertObject", dto);
    }

    public void insertObject(ArrayList<GoodsList> list) {
        MyBatisUtils.insertOnTransaction("GoodsList.insertObject", list);
    }

    public int updateObjectById(GoodsList dto) {
        return MyBatisUtils.update("GoodsList.updateObjectById", dto);
    }
}
