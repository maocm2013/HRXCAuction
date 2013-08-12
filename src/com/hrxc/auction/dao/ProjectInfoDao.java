package com.hrxc.auction.dao;

import com.hrxc.auction.domain.ProjectInfo;
import com.hrxc.auction.util.JdbcUtil;
import com.hrxc.auction.util.UITools;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class ProjectInfoDao {

    private static final Logger log = Logger.getLogger(ProjectInfoDao.class);
    private static final String SQL_BASIC_QUERY = "SELECT PK_ID pkId,PROJECT_NO projectNo,PROJECT_NAME projectName,PROJECT_STATE projectState FROM PROJECT_INFO where 1=1 ";
    private static final String SQL_DELETE_BY_ID = "delete from PROJECT_INFO where pk_id=?";
    private static final String SQL_INSERT = "insert into PROJECT_INFO(PROJECT_NO,PROJECT_NAME,PROJECT_STATE,PK_ID)values(?,?,?,?)";
    private static final String SQL_UPDATE_BY_ID = "update PROJECT_INFO set PROJECT_NO=?,PROJECT_NAME=?,PROJECT_STATE=? where pk_id=?";

    /**
     * 根据条件进行查询
     * @param projectNo
     * @param projectName
     * @return
     * @throws SQLException 
     */
    public List getAllObjectInfo(String projectNo, String projectName) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<ProjectInfo> list = null;
        StringBuilder sb = new StringBuilder(SQL_BASIC_QUERY);
        try {
            ArrayList<Object> params = new ArrayList<Object>();
            if (StringUtils.isNotEmpty(projectNo)) {
                params.add(projectNo.trim());
                sb.append(" and PROJECT_NO=? ");
            }
            if (StringUtils.isNotEmpty(projectName)) {
                params.add(projectName.trim());
                sb.append(" and PROJECT_NAME like '%'||?||'%' ");
            }
            sb.append(" order by PROJECT_NO");
            log.debug("getAllObjectInfo.sql=" + sb.toString());

            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<ProjectInfo>) queryRunner.query(conn, sb.toString(), new BeanListHandler(ProjectInfo.class), params.toArray());
        } finally {
            DbUtils.close(conn);
        }
        return list;
    }

    /**
     * 根据主键获取数据信息
     *
     * @param pkId
     * @return
     * @throws SQLException
     */
    public ProjectInfo getObjectById(String pkId) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        ProjectInfo dto = null;
        String sql = SQL_BASIC_QUERY.concat(" and pk_id=?");
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            dto = (ProjectInfo) queryRunner.query(conn, sql, new BeanHandler(ProjectInfo.class), pkId);
        } finally {
            DbUtils.close(conn);
        }
        return dto;
    }

    /**
     * 根据主键删除数据
     *
     * @param list
     * @throws SQLException
     */
    public void deleteObjectById(ArrayList<String> list) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        try {
            conn = JdbcUtil.getConn();
            conn.setAutoCommit(false);
            queryRunner = new QueryRunner();
            for (int i = 0; i < list.size(); i++) {
                queryRunner.update(conn, SQL_DELETE_BY_ID, list.get(i));
            }
            conn.commit();
        } finally {
            conn.setAutoCommit(true);
            DbUtils.close(conn);
        }
    }

    /**
     * 根据ID来更新或插入数据，根据ID是否为空进行判断
     *
     * @param dto
     * @throws SQLException
     */
    public void saveOrUpdateObject(ProjectInfo dto) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[9];
            int seq = 0;
            params[seq++] = dto.getProjectNo();
            params[seq++] = dto.getProjectName();
            params[seq++] = dto.getProjectState();
            if (StringUtils.isNotEmpty(dto.getPkId())) {
                params[seq++] = dto.getPkId();
                queryRunner.update(conn, SQL_UPDATE_BY_ID, params);
            } else {
                params[seq++] = UITools.generateUUID();
                queryRunner.update(conn, SQL_INSERT, params);
            }
        } finally {
            DbUtils.close(conn);
        }
    }
}

