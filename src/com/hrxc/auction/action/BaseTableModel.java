package com.hrxc.auction.action;

import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class BaseTableModel extends AbstractTableModel{
    /**
     * ID
     */
    private static final long serialVersionUID = -1264704523326656387L;
    /**
     * 第N列可编辑
     */
    protected int checkColumn = -1;
    protected List<String> columnNames;
    protected List<Object> contents;

    public BaseTableModel() {
        this.columnNames = new Vector<String>();
        this.contents = new Vector<Object>();
    }

    public BaseTableModel(String[] columnNames) {
        this();
        if (null == columnNames) {
            return;
        }
        for (String columnName : columnNames) {
            this.columnNames.add(columnName);
        }
    }

    public BaseTableModel(Object[][] datas, String[] columnNames) {
        this(columnNames);
        refreshContents(datas);
    }

    public void refreshContents(Object[][] datas){
        this.contents.clear();
        if (null == datas) {
            return;
        }

        for (Object[] data : datas) {
            addRow(data);
        }
    }

    public void addRow(Object[] data) {
        if (null == data) {
            return;
        }

        Vector<Object> content = new Vector<Object>(this.columnNames.size());
        for (int ii = 0; ii < this.columnNames.size(); ii++) {
            content.add(data[ii]);
        }
        contents.add(content);
    }

    public void removeRow(int row) {
        contents.remove(row);
    }

    public void removeRows(int row, int count) {
        for (int ii = 0; ii < count; ii++) {
            if (contents.size() > row) {
                contents.remove(row);
            }
        }
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#isCellEditable(int, int)
     */
    public boolean isCellEditable(int row, int col) {
        if (col == this.checkColumn) {
            return true;
        }
        return super.isCellEditable(row, col);
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#setValueAt(java.lang.Object, int, int)
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setValueAt(Object value, int row, int col) {
        ((Vector) contents.get(row)).set(col, value);
        this.fireTableCellUpdated(row, col);
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
     */
    public Class<?> getColumnClass(int column) {
        Object value = getValueAt(0, column);
        if (value != null) {
            return value.getClass();
        }
        return super.getClass();
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    @Override
    public int getColumnCount() {
        return this.columnNames.size();
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.TableModel#getRowCount()
     */
    @Override
    public int getRowCount() {
        return this.contents.size();
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Object getValueAt(int row, int col) {
        return ((Vector) contents.get(row)).get(col);
    }

    /*
     * (non-Javadoc)
     * @see javax.swing.table.AbstractTableModel#getColumnName(int)
     */
    public String getColumnName(int col) {
        return columnNames.get(col);
    }

    public int getCheckColumn() {
        return checkColumn;
    }

    public void setCheckColumn(int checkColumn) {
        this.checkColumn = checkColumn;
    }
}
