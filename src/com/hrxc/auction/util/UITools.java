package com.hrxc.auction.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author user
 */
public class UITools {

    private static final Logger log = Logger.getLogger(UITools.class);

    /**
     * 生成32位UUID
     *
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    /**
     * 隐藏table中的某一列
     *
     * @param jtable
     * @param columnIndex
     */
    public static void hideColumn(JTable jtable, int columnIndex) {
        TableColumn tc = jtable.getColumnModel().getColumn(columnIndex);
        tc.setWidth(0);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        jtable.getTableHeader().getColumnModel().getColumn(columnIndex).setMaxWidth(0);
        jtable.getTableHeader().getColumnModel().getColumn(columnIndex).setMinWidth(0);
    }

    /**
     * 根据数据字典生成ComboxModel
     *
     * @param dataMap
     * @param isHaveAll 是否包含全部选项
     * @return
     */
    public static DefaultComboBoxModel getComboxValue(Map dataMap, boolean isHaveAll) {
        Set set = dataMap.entrySet();
        Vector<ComboxValue> v = new Vector<ComboxValue>();
        if (isHaveAll) {
            v.add(new ComboxValue("全  部", ""));
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            ComboxValue value = new ComboxValue();
            value.setName(entry.getValue().toString());
            value.setValue(entry.getKey().toString());
            v.add(value);
        }
        return new DefaultComboBoxModel(v);
    }

    /**
     * 获取小时选择下拉选项
     *
     * @return
     */
    public static DefaultComboBoxModel getHourComboxModel() {
        String[] v = new String[24];
        for (int i = 0; i < v.length; i++) {
            v[i] = StringUtils.leftPad(String.valueOf(i), 2, "0");
        }
        return new DefaultComboBoxModel(v);
    }

    /**
     * 获取分钟选择下拉选项
     *
     * @return
     */
    public static DefaultComboBoxModel getMinComboxModel() {
        String[] v = new String[60];
        for (int i = 0; i < v.length; i++) {
            v[i] = StringUtils.leftPad(String.valueOf(i), 2, "0");
        }
        return new DefaultComboBoxModel(v);
    }

    /**
     * 获取选中的行数
     *
     * @param table
     * @return
     */
    public static int getCheckedRows(JTable table) {
        int c = 0;
        TableModel model = table.getModel();
        int rows = model.getRowCount();
        for (int i = 0; i < rows; i++) {
            //JOptionPane.showMessageDialog(null,String.valueOf(model.getValueAt(i, 0)));
            if (model.getValueAt(i, 0) != null && (Boolean) model.getValueAt(i, 0).equals(Boolean.TRUE)) {
                c++;
            }
        }
        return c;
    }

    /**
     * 获取选中记录的主键集合
     *
     * @param table
     * @return
     */
    public static ArrayList<String> getCheckedRowsId(JTable table) {
        ArrayList<String> list = new ArrayList<String>();
        TableModel model = table.getModel();
        int rows = model.getRowCount();
        for (int i = 0; i < rows; i++) {
            //JOptionPane.showMessageDialog(null,String.valueOf(model.getValueAt(i, 1)));
            if (model.getValueAt(i, 0) != null && (Boolean) model.getValueAt(i, 0).equals(Boolean.TRUE)) {
                list.add(String.valueOf(model.getValueAt(i, 1)));
            }
        }
        return list;
    }

    /**
     * 从bean中根据属性名称获取相应值
     *
     * @param bean
     * @param propName
     * @return
     */
    public static String getBeanPropertyValue(Object bean, String propName) {
        String s = "";
        try {
            if (bean != null) {
                s = BeanUtils.getProperty(bean, propName);
            }
        } catch (Exception ex) {
            log.error("getBeanPropertyValue.error:", ex);
        }
        return s;
    }

    /**
     * 从bean中根据属性名称获取相应值
     *
     * @param bean
     * @param propName
     * @param defaultValue
     * @return
     */
    public static String getBeanPropertyValue(Object bean, String propName, String defaultValue) {
        String s = "";
        try {
            if (bean != null) {
                s = BeanUtils.getProperty(bean, propName);
            } else {
                s = defaultValue;
            }
        } catch (Exception ex) {
            log.error("getBeanPropertyValue.error:", ex);
        }
        return s;
    }

    /**
     * 在焦点失去的时候进行文本校验
     *
     * @param tc
     * @param msgLabel 信息显示标签
     * @param isEmpty 是否可以为空
     * @param isNumber 是否为数值
     * @param isDigit 是否为纯数字
     */
    public static boolean vilidateText(JTextComponent tc, JLabel msgLabel, boolean isEmpty, boolean isNumber, boolean isDigit) {
        //验证空值
        if (isEmpty) {
            if (StringUtils.isEmpty(tc.getText())) {
                msgLabel.setText("<html><font color=red style=font-size:14pt;font-family:黑体><b>文本不能为空！</b></font></html>");
                tc.requestFocus();
                tc.selectAll();
                return false;
            }
        }

        //验证是否数值
        if (isNumber) {
            if (!NumberUtils.isNumber(tc.getText())) {
                msgLabel.setText("<html><font color=red style=font-size:14pt;font-family:黑体><b>文本必须为数值！</b></font></html>");
                tc.requestFocus();
                tc.selectAll();
                return false;
            }
        }

        //验证是否纯数字
        if (isDigit) {
            if (!NumberUtils.isDigits(tc.getText())) {
                msgLabel.setText("<html><font color=red style=font-size:14pt;font-family:黑体><b>文本必须为纯数字！</b></font></html>");
                tc.requestFocus();
                tc.selectAll();
                return false;
            }
        }

        msgLabel.setText("");
        return true;
    }

    /**
     * 将char[]转换为字符串
     *
     * @param c
     * @return
     */
    public static String char2String(char[] c) {
        StringBuilder str = new StringBuilder("");
        if (c != null && c.length > 1) {
            for (int i = 0; i < c.length; i++) {
                str.append(c[i]);
            }
        }
        return str.toString();
    }

    /**
     * 导出Excel
     * @param com
     * @param wb 
     */
    public static void exportExcel(JComponent com,HSSFWorkbook wb) {
        //保存为Excel文件  
        FileOutputStream out = null;
        try {

            JFileChooser fileChooser = new JFileChooser();
            //限制文件过滤
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Excel 97-2003(*.xls)", "xls");
            fileChooser.setFileFilter(filter);

            File defaultFile = new File("export.xls");
            fileChooser.setSelectedFile(defaultFile);

            int ret = fileChooser.showSaveDialog(com.getRootPane());
            if (ret == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (selectedFile.exists()) {
                    int copy = JOptionPane.showConfirmDialog(com.getRootPane(), "是否要覆盖当前文件", "保存", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (copy == JOptionPane.YES_OPTION) {
                        fileChooser.approveSelection();
                        out = new FileOutputStream(selectedFile);
                        wb.write(out);
                    }
                }
            }
        } catch (IOException e) {
            log.error("error:", e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                 log.error("error:", e);
            }
        }
    }
}
