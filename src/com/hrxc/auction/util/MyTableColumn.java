package com.hrxc.auction.util;

import java.util.Map;

/**
 * 表格配置信息
 * @author maochangming
 */
public class MyTableColumn {
    /**
     * 列标题
     */
    private String columnName;
    /**
     * 列类型
     */
    private Class columnType;
    /**
     * 属性名称
     */
    private String propertyName;
    /**
     * 列宽
     */
    private String columnWidth;
    /**
     * 是否隐藏
     */
    private boolean isHidden;
    /**
     * 是否数据字典
     */
    private boolean isDict;
    /**
     * 数据字典map
     */
    private Map dictMap;

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

    public boolean isIsDict() {
        return isDict;
    }

    public void setIsDict(boolean isDict) {
        this.isDict = isDict;
    }

    public Map getDictMap() {
        return dictMap;
    }

    public void setDictMap(Map dictMap) {
        this.dictMap = dictMap;
    }
    
    
}
