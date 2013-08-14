package com.hrxc.auction.dao;

import com.hrxc.auction.domain.BargainRecord;
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
public class BargainRecordDao {

    private static final Logger log = Logger.getLogger(BargainRecordDao.class);
    private static final String SQL_BASIC_QUERY = "select pk_id pkId,paddle_No paddleNo,goods_No goodsNo,bargain_Confirm_No bargainConfirmNo,hammer_Price hammerPrice,commission commission,other_Fund otherFund,bargain_Price bargainPrice,project_no projectNo,is_settled isSettled from bargain_record where 1=1 ";
    private static final String SQL_DELETE_BY_ID = "delete from bargain_record where pk_id=?";
    private static final String SQL_INSERT = "insert into bargain_record(paddle_No,goods_No,bargain_Confirm_No,hammer_Price,commission,other_Fund,bargain_Price,project_no,pk_id)values(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_BY_ID = "update bargain_record set paddle_No=?,goods_No=?,bargain_Confirm_No=?,hammer_Price=?,commission=?,other_Fund=?,bargain_Price=?,project_no=? where pk_id=?";

    /**
     * 根据条件进行查询
     *
     * @param projectNo
     * @param isSettled
     * @param paddleNo
     * @param custName
     * @return
     * @throws SQLException
     */
    public List getAllObjectInfo(String projectNo, String isSettled, String paddleNo, String custName) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<BargainRecord> list = null;
        StringBuilder sb = new StringBuilder(SQL_BASIC_QUERY);
        try {
            ArrayList<Object> params = new ArrayList<Object>();
            //首先增加项目编号查询条件
            params.add(projectNo);
            sb.append("and project_no=? ");
            if (StringUtils.isNotEmpty(isSettled)) {
                params.add(isSettled.trim());
                sb.append(" and is_settled=? ");
            }
            if (StringUtils.isNotEmpty(paddleNo)) {
                params.add(paddleNo.trim());
                sb.append(" and paddle_No=? ");
            }
            if (StringUtils.isNotEmpty(custName)) {
                params.add(custName.trim());
                sb.append(" and goods_No=? ");
            }
            sb.append(" order by paddle_No");
            log.debug("getAllObjectInfo.sql=" + sb.toString());

            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<BargainRecord>) queryRunner.query(conn, sb.toString(), new BeanListHandler(BargainRecord.class), params.toArray());
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
    public BargainRecord getObjectById(String pkId) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        BargainRecord dto = null;
        String sql = SQL_BASIC_QUERY.concat(" and pk_id=?");
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            dto = (BargainRecord) queryRunner.query(conn, sql, new BeanHandler(BargainRecord.class), pkId);
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
    public void saveOrUpdateObject(BargainRecord dto) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[9];
            int seq = 0;
            params[seq++] = dto.getPaddleNo();
            params[seq++] = dto.getGoodsNo();
            params[seq++] = dto.getBargainConfirmNo();
            params[seq++] = dto.getHammerPrice();
            params[seq++] = dto.getCommission();
            params[seq++] = dto.getOtherFund();
            params[seq++] = dto.getBargainPrice();
            params[seq++] = dto.getProjectNo();
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
