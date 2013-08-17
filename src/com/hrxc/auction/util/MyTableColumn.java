package com.hrxc.auction.util;

/**
 * 表格配置信息
 * @author maochangming
 */
public class MyTableColumn {
    private String columnName;
    private Class columnType;
    private String propertyName;
    private String columnWidth;
    private boolean isHidden;

    public MyTableColumn(String columnName,Class columnType,String propertyName){
        this.columnName = columnName;
        this.columnType = columnType;
        this.propertyName = propertyName;
    }
    
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Class getColumnType() {
        return columnType;
    }

    public void setColumnType(Class columnType) {
        this.columnType = columnType;
    }


    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(String columnWidth) {
        this.columnWidth = columnWidth;
    }

    public boolean isIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
}
