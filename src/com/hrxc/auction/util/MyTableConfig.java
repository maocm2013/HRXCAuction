package com.hrxc.auction.util;

import java.util.ArrayList;

/**
 *
 * @author maochangming
 */
public class MyTableConfig {

    /**
     *
     * @param columns
     * @return
     */
    public static String[] getTableColumnNames(ArrayList<MyTableColumn> columns) {
        String[] tableColumnNames = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            tableColumnNames[i] = columns.get(i).getColumnName();
        }
        return tableColumnNames;
    }

    public static Class[] getColumnTypes(ArrayList<MyTableColumn> columns) {
        Class[] types = new Class[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            types[i] = columns.get(i).getColumnType();
        }
        return types;
    }

    public static MyTableModel getTableModel(String[] columnNames, Class[] types) {
        return new MyTableModel(columnNames, types);
    }

    public static MyTableModel getBiddingPaddleTableModel() {
        return getTableModel(getTableColumnNames(BiddingPaddle.columns), getColumnTypes(BiddingPaddle.columns));
    }

    public static MyTableModel getProjectInfoTableModel() {
        return getTableModel(getTableColumnNames(ProjectInfo.columns), getColumnTypes(ProjectInfo.columns));
    }

    public static MyTableModel getClientSideTableModel() {
        return getTableModel(getTableColumnNames(ClientSide.columns), getColumnTypes(ClientSide.columns));
    }

    public static MyTableModel getGoodsListTableModel() {
        return getTableModel(getTableColumnNames(GoodsList.columns), getColumnTypes(GoodsList.columns));
    }

    public static MyTableModel getBargainRecordTableModel() {
        return getTableModel(getTableColumnNames(BargainRecord.columns), getColumnTypes(BargainRecord.columns));
    }

    public static MyTableModel getPaymentListTableModel() {
        return getTableModel(getTableColumnNames(PaymentList.columns), getColumnTypes(PaymentList.columns));
    }

    public static class BiddingPaddle {

        public static final ArrayList<MyTableColumn> columns = new ArrayList<MyTableColumn>();

        static {
            columns.add(new MyTableColumn("选择", java.lang.Boolean.class, ""));
            columns.add(new MyTableColumn("主键", java.lang.String.class, "pkId"));
            columns.add(new MyTableColumn("序号", java.lang.Integer.class, ""));
            columns.add(new MyTableColumn("竞买号牌", java.lang.String.class, "paddleNo"));
            columns.add(new MyTableColumn("竞买人姓名", java.lang.String.class, "custName"));
            columns.add(new MyTableColumn("证件类型", java.lang.String.class, "certType"));
            columns.add(new MyTableColumn("证件号码", java.lang.String.class, "certNo"));
            columns.add(new MyTableColumn("联系方式", java.lang.String.class, "custTel"));
            columns.add(new MyTableColumn("通讯地址", java.lang.String.class, "custAddr"));
            columns.add(new MyTableColumn("保证金（元）", java.lang.Integer.class, "cashDeposit"));
            columns.add(new MyTableColumn("备注", java.lang.String.class, "remarks"));
            columns.add(new MyTableColumn("项目编号", java.lang.String.class, "projectNo"));

            MyTableColumn cds = new MyTableColumn("保证金使用状态", java.lang.String.class, "cashDepositState");
            cds.setIsDict(true);
            cds.setDictMap(DictEnum.CashDepositState.dataMap);
            columns.add(cds);
        }
    }

    public static class ProjectInfo {

        public static final ArrayList<MyTableColumn> columns = new ArrayList<MyTableColumn>();

        static {
            columns.add(new MyTableColumn("选择", java.lang.Boolean.class, ""));
            columns.add(new MyTableColumn("主键", java.lang.String.class, "pkId"));
            columns.add(new MyTableColumn("序号", java.lang.Integer.class, ""));
            columns.add(new MyTableColumn("项目编号", java.lang.String.class, "projectNo"));
            columns.add(new MyTableColumn("项目名称", java.lang.String.class, "projectName"));

            MyTableColumn psCol = new MyTableColumn("项目状态", java.lang.String.class, "projectState");
            psCol.setIsDict(true);
            psCol.setDictMap(DictEnum.ProjectState.dataMap);
            columns.add(psCol);
        }
    }

    public static class ClientSide {

        public static final ArrayList<MyTableColumn> columns = new ArrayList<MyTableColumn>();

        static {
            columns.add(new MyTableColumn("选择", java.lang.Boolean.class, ""));
            columns.add(new MyTableColumn("主键", java.lang.String.class, "pkId"));
            columns.add(new MyTableColumn("序号", java.lang.Integer.class, ""));
            columns.add(new MyTableColumn("委托方编号", java.lang.String.class, "clientNo"));
            columns.add(new MyTableColumn("委托方名称", java.lang.String.class, "clientName"));
        }
    }

    public static class GoodsList {

        public static final ArrayList<MyTableColumn> columns = new ArrayList<MyTableColumn>();

        static {
            columns.add(new MyTableColumn("选择", java.lang.Boolean.class, ""));
            columns.add(new MyTableColumn("主键", java.lang.String.class, "pkId"));
            columns.add(new MyTableColumn("序号", java.lang.Integer.class, ""));
            columns.add(new MyTableColumn("图录号", java.lang.String.class, "goodsNo"));
            columns.add(new MyTableColumn("拍品名称", java.lang.String.class, "goodsName"));
            columns.add(new MyTableColumn("完残度", java.lang.String.class, "goodsIntact"));
            columns.add(new MyTableColumn("尺寸", java.lang.String.class, "goodsSize"));
            columns.add(new MyTableColumn("证书后七位", java.lang.String.class, "certificateNo"));
            columns.add(new MyTableColumn("保留价", java.lang.Integer.class, "keepPrice"));
            columns.add(new MyTableColumn("市场估价", java.lang.Integer.class, "marketPrice"));
            columns.add(new MyTableColumn("起拍价", java.lang.Integer.class, "onsetPrice"));
            columns.add(new MyTableColumn("项目编号", java.lang.String.class, "projectNo"));
            columns.add(new MyTableColumn("委托方编号", java.lang.String.class, "clientNo"));
        }
    }

    public static class BargainRecord {

        public static final ArrayList<MyTableColumn> columns = new ArrayList<MyTableColumn>();

        static {
            columns.add(new MyTableColumn("选择", java.lang.Boolean.class, ""));
            columns.add(new MyTableColumn("主键", java.lang.String.class, "pkId"));
            columns.add(new MyTableColumn("序号", java.lang.Integer.class, ""));
            columns.add(new MyTableColumn("竞买号牌", java.lang.String.class, "paddleNo"));
            columns.add(new MyTableColumn("图录号", java.lang.String.class, "goodsNo"));
            columns.add(new MyTableColumn("成交确认书编号", java.lang.String.class, "bargainConfirmNo"));
            columns.add(new MyTableColumn("落锤价", java.lang.Integer.class, "hammerPrice"));
            columns.add(new MyTableColumn("佣金", java.lang.Integer.class, "commission"));
            columns.add(new MyTableColumn("其他款项", java.lang.Integer.class, "otherFund"));
            columns.add(new MyTableColumn("总成交价", java.lang.Integer.class, "bargainPrice"));
            columns.add(new MyTableColumn("项目编号", java.lang.String.class, "projectNo"));

            MyTableColumn ss = new MyTableColumn("结算状态", java.lang.String.class, "settleState");
            ss.setIsDict(true);
            ss.setDictMap(DictEnum.SettleState.dataMap);
            columns.add(ss);

            columns.add(new MyTableColumn("付款编号", java.lang.String.class, "paymentNo"));
        }
    }

    public static class PaymentList {

        public static final ArrayList<MyTableColumn> columns = new ArrayList<MyTableColumn>();

        static {
            columns.add(new MyTableColumn("选择", java.lang.Boolean.class, ""));
            columns.add(new MyTableColumn("主键", java.lang.String.class, "pkId"));
            columns.add(new MyTableColumn("序号", java.lang.Integer.class, ""));
            columns.add(new MyTableColumn("付款编号", java.lang.String.class, "paymentNo"));
            columns.add(new MyTableColumn("项目编号", java.lang.String.class, "projectNo"));
            columns.add(new MyTableColumn("号牌编号", java.lang.String.class, "paddleNo"));
            columns.add(new MyTableColumn("拍品数量", java.lang.String.class, "goodsNum"));
            columns.add(new MyTableColumn("总金额", java.lang.Integer.class, "totalAmount"));
            columns.add(new MyTableColumn("已付款", java.lang.Integer.class, "accountPaid"));
            columns.add(new MyTableColumn("未付款", java.lang.Integer.class, "nonPayment"));

            MyTableColumn cds = new MyTableColumn("保证金使用状态", java.lang.String.class, "cashDepositState");
            cds.setIsDict(true);
            cds.setDictMap(DictEnum.CashDepositState.dataMap);
            columns.add(cds);

            MyTableColumn ps = new MyTableColumn("付款状态", java.lang.String.class, "paymentState");
            ps.setIsDict(true);
            ps.setDictMap(DictEnum.PaymentState.dataMap);
            columns.add(ps);
        }
    }
}
