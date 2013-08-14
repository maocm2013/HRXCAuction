/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.dao;

import com.hrxc.auction.domain.BiddingPaddle;
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
public class BiddingPaddleDao {

    private static final Logger log = Logger.getLogger(BiddingPaddleDao.class);
    private static final String SQL_BASIC_QUERY = "select pk_id pkId,paddle_No paddleNo,cust_Name custName,cert_Type certType,cert_No certNo,cust_Tel custTel,cust_Addr custAddr,cash_Deposit cashDeposit,remarks remarks,project_no projectNo,CASH_DEPOSIT_STATE cashDepositState from bidding_paddle where 1=1 ";
    private static final String SQL_DELETE_BY_ID = "delete from bidding_paddle where pk_id=?";
    private static final String SQL_INSERT = "insert into bidding_paddle(paddle_No,cust_Name,cert_Type,cert_No,cust_Tel,cust_Addr,cash_Deposit,remarks,project_no,pk_id)values(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_BY_ID = "update bidding_paddle set paddle_No=?,cust_Name=?,cert_Type=?,cert_No=?,cust_Tel=?,cust_Addr=?,cash_Deposit=?,remarks=?,project_no=? where pk_id=?";

    /**
     * 根据条件进行查询
     *
     * @param projectNo
     * @param paddleNo
     * @param custName
     * @return
     * @throws SQLException
     */
    public List getAllObjectInfo(String projectNo, String paddleNo, String custName) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<BiddingPaddle> list = null;
        StringBuilder sb = new StringBuilder(SQL_BASIC_QUERY);
        try {
            ArrayList<Object> params = new ArrayList<Object>();
            //首先增加项目编号查询条件
            params.add(projectNo);
            sb.append("and project_no=? ");
            if (StringUtils.isNotEmpty(paddleNo)) {
                params.add(paddleNo.trim());
                sb.append(" and paddle_No=? ");
            }
            if (StringUtils.isNotEmpty(custName)) {
                params.add(custName.trim());
                sb.append(" and cust_Name like '%'||?||'%' ");
            }
            sb.append(" order by paddle_No");
            log.debug("getAllObjectInfo.sql=" + sb.toString());

            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<BiddingPaddle>) queryRunner.query(conn, sb.toString(), new BeanListHandler(BiddingPaddle.class), params.toArray());
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
    public BiddingPaddle getObjectById(String pkId) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        BiddingPaddle dto = null;
        String sql = SQL_BASIC_QUERY.concat(" and pk_id=?");
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            dto = (BiddingPaddle) queryRunner.query(conn, sql, new BeanHandler(BiddingPaddle.class), pkId);
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
    public void saveOrUpdateObject(BiddingPaddle dto) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[10];
            int seq = 0;
            params[seq++] = dto.getPaddleNo();
            params[seq++] = dto.getCustName();
            params[seq++] = dto.getCertType();
            params[seq++] = dto.getCertNo();
            params[seq++] = dto.getCustTel();
            params[seq++] = dto.getCustAddr();
            params[seq++] = dto.getCashDeposit();
            params[seq++] = dto.getRemarks();
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
