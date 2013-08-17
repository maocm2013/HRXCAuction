package com.hrxc.auction.action;

import com.hrxc.auction.dao.ProjectInfoDao;
import com.hrxc.auction.domain.ProjectInfo;
import com.hrxc.auction.domain.vo.ProjectInfoVo;
import com.hrxc.auction.util.MyTableConfig;
import com.hrxc.auction.util.UITools;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class ProjectInfoAction {

    private static final Logger log = Logger.getLogger(ProjectInfoAction.class);
    private static final ProjectInfoDao dao = new ProjectInfoDao();

    /**
     * 根据项目编号获取项目信息
     *
     * @param projectNo
     * @return
     */
    public static ProjectInfo getProjectInfoByProjectNo(String projectNo) {
        ProjectInfo dto = null;
        try {
            ProjectInfoVo condition = new ProjectInfoVo();
            condition.setProjectNo(projectNo);
            List<ProjectInfo> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                dto = list.get(0);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return dto;
    }

    /**
     * 根据条件查询数据信息
     *
     * @return
     */
    public static Object[][] getAllTableData(ProjectInfoVo condition) {
        Object[][] data = null;
        try {
            List<ProjectInfo> list = dao.getAllObjectInfo(condition);
            if (list != null && list.size() > 0) {
                data = UITools.List2TableData(list,MyTableConfig.ProjectInfo.columns);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    /**
     * 根据项目状态获取项目信息
     *
     * @param projectState
     * @return
     */
    public static List<ProjectInfo> getAllProjectByState(String projectState) {
        List<ProjectInfo> list = null;
        try {
            ProjectInfoVo condition = new ProjectInfoVo();
            condition.setProjectState(projectState);
            list = dao.getAllObjectInfo(condition);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return list;
    }

    /**
     * 保存或新增数据信息
     *
     * @param dto
     */
    public static void saveOrUpdateObject(ProjectInfo dto) {
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
    public static ProjectInfo getObjectById(String pkId) {
        ProjectInfo dto = null;
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
