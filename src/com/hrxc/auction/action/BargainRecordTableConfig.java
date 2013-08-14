package com.hrxc.auction.action;

/**
 *
 * @author user
 */
public class BargainRecordTableConfig {

    public static final String[] tableColumnNames = new String[]{
        "选择", "主键", "序号", "竞买号牌", "图录号", "成交确认书编号", "落锤价", "佣金", "其他款项", "总成交价", "项目编号", "结算状态", "付款编号"
    };

    public class MyTableModel extends BaseTableModel {

        public MyTableModel() {
            super(tableColumnNames);
            //设置第1列可编辑，保证复选框可以选择
            this.setCheckColumn(0);
        }
        Class[] types = new Class[]{
            java.lang.Boolean.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    }
}
