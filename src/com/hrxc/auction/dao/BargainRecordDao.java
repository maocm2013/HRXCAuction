package com.hrxc.auction.dao;

import com.hrxc.auction.domain.BargainRecord;
import com.hrxc.auction.domain.vo.BargainRecordVo;
import com.hrxc.auction.util.MyBatisUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class BargainRecordDao {

    public List getAllObjectInfo(BargainRecordVo condition) {
        return (List<BargainRecord>) MyBatisUtils.selectList("BargainRecord.getAllObjectInfo", condition);
    }

    /**
     * 根据主键获取数据信息
     *
     * @param pkId
     * @return
     */
    public BargainRecord getObjectById(String pkId) {
        BargainRecordVo condition = new BargainRecordVo();
        condition.setPkId(pkId);
        return (BargainRecord) MyBatisUtils.selectOne("BargainRecord.getAllObjectInfo", condition);
    }

    /**
     * 根据主键删除数据
     *
     */
    public void deleteObjectById(ArrayList<String> list) {
        MyBatisUtils.deleteOnTransaction("BargainRecord.deleteObjectById", list);
    }

    public int insertObject(BargainRecord dto) {
        return MyBatisUtils.insert("BargainRecord.insertObject", dto);
    }

    public int updateObjectById(BargainRecord dto) {
        return MyBatisUtils.update("BargainRecord.updateObjectById", dto);
    }
}
