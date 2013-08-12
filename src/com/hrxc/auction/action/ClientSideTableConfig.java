package com.hrxc.auction.action;

/**
 *
 * @author user
 */
public class ClientSideTableConfig {

    public static final String[] tableColumnNames = new String[]{
        "选择", "主键", "序号", "委托方编号", "委托方名称"
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
            java.lang.String.class
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    }
}
