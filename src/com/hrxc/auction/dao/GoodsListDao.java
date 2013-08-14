package com.hrxc.auction.dao;

import com.hrxc.auction.domain.GoodsList;
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
public class GoodsListDao {

    private static final Logger log = Logger.getLogger(GoodsListDao.class);
    private static final String SQL_BASIC_QUERY = "select pk_id pkId,goods_no goodsNo,goods_Name goodsName,goods_Intact goodsIntact,goods_Size goodsSize,certificate_No certificateNo,keep_Price keepPrice,market_Price marketPrice,onset_Price onsetPrice,project_no projectNo,client_no clientNo from goods_list where 1=1 ";
    private static final String SQL_DELETE_BY_ID = "delete from goods_list where pk_id=?";
    private static final String SQL_INSERT = "insert into goods_list(goods_no,goods_Name,goods_Intact,goods_Size,certificate_No,keep_Price,market_Price,onset_Price,project_no,client_no,pk_id)values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_BY_ID = "update goods_list set goods_no=?,goods_Name=?,goods_Intact=?,goods_Size=?,certificate_No=?,keep_Price=?,market_Price=?,onset_Price=?,project_no=?,client_no=? where pk_id=?";

    /**
     * 根据条件进行查询
     *
     * @param projectNo
     * @param goodsNo
     * @param goodsName
     * @return
     * @throws SQLException
     */
    public List getAllObjectInfo(String projectNo, String goodsNo, String goodsName) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<GoodsList> list = null;
        StringBuilder sb = new StringBuilder(SQL_BASIC_QUERY);
        try {
            ArrayList<Object> params = new ArrayList<Object>();
            
            //首先增加项目编号查询条件
            params.add(projectNo);
            sb.append("and project_no=? ");
            
            if (StringUtils.isNotEmpty(goodsNo)) {
                params.add(goodsNo.trim());
                sb.append(" and goods_no=? ");
            }
            if (StringUtils.isNotEmpty(goodsName)) {
                params.add(goodsName.trim());
                sb.append(" and goods_Name like '%'||?||'%' ");
            }
            sb.append(" order by goods_no");
            log.debug("getAllObjectInfo.sql=" + sb.toString());

            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<GoodsList>) queryRunner.query(conn, sb.toString(), new BeanListHandler(GoodsList.class), params.toArray());
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
    public GoodsList getObjectById(String pkId) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        GoodsList dto = null;
        String sql = SQL_BASIC_QUERY.concat(" and pk_id=?");
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            dto = (GoodsList) queryRunner.query(conn, sql, new BeanHandler(GoodsList.class), pkId);
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
    public void saveOrUpdateObject(GoodsList dto) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[11];
            int seq = 0;
            params[seq++] = dto.getGoodsNo();
            params[seq++] = dto.getGoodsName();
            params[seq++] = dto.getGoodsIntact();
            params[seq++] = dto.getGoodsSize();
            params[seq++] = dto.getCertificateNo();
            params[seq++] = dto.getKeepPrice();
            params[seq++] = dto.getMarketPrice();
            params[seq++] = dto.getOnsetPrice();
            params[seq++] = dto.getProjectNo();
            params[seq++] = dto.getClientNo();
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
