package com.hrxc.auction.dao;

import com.hrxc.auction.domain.ClientSide;
import com.hrxc.auction.domain.vo.ClientSideVo;
import com.hrxc.auction.util.MyBatisUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class ClientSideDao {

    private static final Logger log = Logger.getLogger(ClientSideDao.class);
    /**
     * 
     * @param vo
     * @return 
     */
    public List getAllObjectInfo(ClientSideVo vo) {
        return (List<ClientSide>) MyBatisUtils.selectList("ClientSide.getAllObjectInfo", vo);
    }

    /**
     * 
     * @param pkId
     * @return
     */
    public ClientSide getObjectById(String pkId) throws SQLException {
        ClientSideVo vo = new ClientSideVo();
        vo.setPkId(pkId);
        return (ClientSide) MyBatisUtils.selectOne("ClientSide.getAllObjectInfo", vo);
    }

    /**
     * 根据主键删除数据
     *
     * @param list
     */
    public void deleteObjectById(ArrayList<String> list) throws SQLException {
        MyBatisUtils.deleteOnTransaction("ClientSide.deleteObjectById", list);
    }

    public int insertObject(ClientSide dto){
         return MyBatisUtils.insert("ClientSide.insertObject", dto);
    }
    
    public int updateObjectById(ClientSide dto){
        return MyBatisUtils.update("ClientSide.updateObjectById", dto);
    }
}

