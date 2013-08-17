package com.hrxc.auction.dao;

import com.hrxc.auction.domain.ProjectInfo;
import com.hrxc.auction.domain.vo.ProjectInfoVo;
import com.hrxc.auction.util.MyBatisUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class ProjectInfoDao {

    private static final Logger log = Logger.getLogger(ProjectInfoDao.class);

    /**
     *
     * @param vo
     * @return
     */
    public List getAllObjectInfo(ProjectInfoVo vo) {
        return (List<ProjectInfo>) MyBatisUtils.selectList("ProjectInfo.getAllObjectInfo", vo);
    }

    /**
     *
     * @param pkId
     * @return
     */
    public ProjectInfo getObjectById(String pkId) throws SQLException {
        ProjectInfoVo vo = new ProjectInfoVo();
        vo.setPkId(pkId);
        return (ProjectInfo) MyBatisUtils.selectOne("ProjectInfo.getAllObjectInfo", vo);
    }

    /**
     * 根据主键删除数据
     *
     * @param list
     */
    public void deleteObjectById(ArrayList<String> list) throws SQLException {
        MyBatisUtils.deleteOnTransaction("ProjectInfo.deleteObjectById", list);
    }

    public int insertObject(ProjectInfo dto) {
        return MyBatisUtils.insert("ProjectInfo.insertObject", dto);
    }

    public int updateObjectById(ProjectInfo dto) {
        return MyBatisUtils.update("ProjectInfo.updateObjectById", dto);
    }
}
