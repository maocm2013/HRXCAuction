package com.hrxc.auction.action;

import com.hrxc.auction.dao.ProjectInfoDao;
import com.hrxc.auction.domain.ProjectInfo;
import com.hrxc.auction.util.DictEnum;
import java.util.ArrayList;
import java.util.List;
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
     * @param projectNo
     * @return 
     */
    public static ProjectInfo getProjectInfoByProjectNo(String projectNo) {
        ProjectInfo dto = null;
        try {
            List<ProjectInfo> list = dao.getAllObjectInfo(projectNo, null,null);
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
     * @param projectNo
     * @param projectName
     * @param projectState
     * @return
     */
    public static Object[][] getAllTableData(String projectNo, String projectName,String projectState) {
        Object[][] data = null;
        try {
            List<ProjectInfo> list = dao.getAllObjectInfo(projectNo, projectName,projectState);
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }
    
    /**
     * 根据项目状态获取项目信息
     * @param projectState
     * @return 
     */
    public static List<ProjectInfo> getAllProjectByState(String projectState){
        List<ProjectInfo> list = null;
        try{
            list = dao.getAllObjectInfo(null, null,projectState);
        }catch(Exception ex){
            log.error("error:", ex);
        }
        return list;
    }

    private static Object[][] List2TableData(List<ProjectInfo> list) {
        Object[][] data = new Object[list.size()][ProjectInfoTableConfig.tableColumnNames.length];
        for (int i = 0; i < list.size(); i++) {
            int seq = 0;
            ProjectInfo dto = list.get(i);
            data[i][seq++] = null;
            data[i][seq++] = dto.getPkId();
            data[i][seq++] = String.valueOf(i + 1);
            data[i][seq++] = dto.getProjectNo();
            data[i][seq++] = dto.getProjectName();
            data[i][seq++] = dto.getProjectState() + "-" + DictEnum.ProjectState.dataMap.get(dto.getProjectState());
        }
        return data;
    }

    /**
     * 保存或新增数据信息
     *
     * @param dto
     */
    public static void saveOrUpdateObject(ProjectInfo dto) {
        try {
            dao.saveOrUpdateObject(dto);
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