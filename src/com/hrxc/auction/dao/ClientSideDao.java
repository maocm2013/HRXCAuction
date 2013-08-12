package com.hrxc.auction.dao;

import com.hrxc.auction.domain.ClientSide;
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
public class ClientSideDao {

    private static final Logger log = Logger.getLogger(ClientSideDao.class);
    private static final String SQL_BASIC_QUERY = "SELECT PK_ID pkId,CLIENT_NO clientNo,CLIENT_NAME clientName FROM CLIENT_SIDE where 1=1 ";
    private static final String SQL_DELETE_BY_ID = "delete from CLIENT_SIDE where pk_id=?";
    private static final String SQL_INSERT = "insert into CLIENT_SIDE(CLIENT_NO,CLIENT_NAME,PK_ID)values(?,?,?)";
    private static final String SQL_UPDATE_BY_ID = "update CLIENT_SIDE set CLIENT_NO=?,CLIENT_NAME=? where pk_id=?";

    /**
     * 根据条件进行查询
     * @param clientNo
     * @param clientName
     * @return
     * @throws SQLException 
     */
    public List getAllObjectInfo(String clientNo, String clientName) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<ClientSide> list = null;
        StringBuilder sb = new StringBuilder(SQL_BASIC_QUERY);
        try {
            ArrayList<Object> params = new ArrayList<Object>();
            if (StringUtils.isNotEmpty(clientNo)) {
                params.add(clientNo.trim());
                sb.append(" and CLIENT_NO=? ");
            }
            if (StringUtils.isNotEmpty(clientName)) {
                params.add(clientName.trim());
                sb.append(" and CLIENT_NAME like '%'||?||'%' ");
            }
            sb.append(" order by CLIENT_NO");
            log.debug("getAllObjectInfo.sql=" + sb.toString());

            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<ClientSide>) queryRunner.query(conn, sb.toString(), new BeanListHandler(ClientSide.class), params.toArray());
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
    public ClientSide getObjectById(String pkId) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        ClientSide dto = null;
        String sql = SQL_BASIC_QUERY.concat(" and pk_id=?");
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            dto = (ClientSide) queryRunner.query(conn, sql, new BeanHandler(ClientSide.class), pkId);
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
    public void saveOrUpdateObject(ClientSide dto) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[3];
            int seq = 0;
            params[seq++] = dto.getClientNo();
            params[seq++] = dto.getClientName();
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

