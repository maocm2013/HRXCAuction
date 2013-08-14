package com.hrxc.auction.action;

/**
 *
 * @author user
 */
public class GoodsListTableConfig {

    public static final String[] tableColumnNames = new String[]{
        "选择", "主键", "序号", "图录号", "拍品名称", "完残度", "尺寸", "证书后七位", "保留价", "市场估价", "起拍价", "项目编号", "委托方编号"
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
            java.lang.String.class,
            java.lang.String.class,
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    }
}
