package com.hrxc.auction.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
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
import org.apache.commons.beanutils.MethodUtils;
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
     * 设置表格属性
     *
     * @param table
     * @param cols
     */
    public static void setTableProps(JTable table, List<MyTableColumn> cols) {
        for (int i = 0; i < cols.size(); i++) {
            MyTableColumn col = cols.get(i);
            TableColumn tc = table.getColumn(col.getColumnName());
            //设置首选列宽
            if (col.getColumnWidth() != null) {
                tc.setMaxWidth(col.getColumnWidth());
                tc.setPreferredWidth(col.getColumnWidth());
            }
            //设置隐藏列
            if (col.isIsHidden()) {
                tc.setPreferredWidth(0);
                tc.setMinWidth(0);
                tc.setMaxWidth(0);
            }
        }
    }

    /**
     * 隐藏table中的某一列
     *
     * @param jtable
     * @param columnTitle
     */
    public static void hideColumn(JTable jtable, String columnTitle) {
        TableColumn tc = jtable.getColumn(columnTitle);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
    }

    /**
     * 将列表数据转换为JTable可以使用的二维数组
     *
     * @param list
     * @param columns
     * @return
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static Object[][] List2TableData(List list, ArrayList<MyTableColumn> columns) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Object[][] data = new Object[list.size()][columns.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int c = 0; c < columns.size(); c++) {
                Object dto = list.get(i);
                MyTableColumn col = columns.get(c);
                //第一列为选择，故无需赋值
                if (c == 0) {
                    data[i][c] = null;
                } else if (c == 2) {//第三列为序号，需要依次累加
                    data[i][c] = Integer.valueOf(i + 1);
                } else {
                    String propValue = BeanUtils.getProperty(dto, col.getPropertyName());
                    if (col.isIsDict() == true) {
                        data[i][c] = "";
                        if (propValue != null) {
                            data[i][c] = MethodUtils.invokeMethod(DictEnum.getInstance(), "getDictDesc", new Object[]{col.getDictMap(), propValue});
                        }
                    } else {
                        data[i][c] = propValue;
                        if (StringUtils.isNotEmpty(propValue) && col.getColumnType().getName().equals("java.lang.Integer")) {
                            data[i][c] = Integer.valueOf(propValue);
                        }
                    }
                }
            }
        }
        return data;
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
     * 获取被选中首行的记录序号
     *
     * @param table
     * @return
     */
    public static int getFirstCheckedRowNo(JTable table) {
        int c = 0;
        TableModel model = table.getModel();
        int rows = model.getRowCount();
        for (int i = 0; i < rows; i++) {
            if (model.getValueAt(i, 0) != null && (Boolean) model.getValueAt(i, 0).equals(Boolean.TRUE)) {
                c = i;
                break;
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
     *
     * @param com
     * @param wb
     */
    public static void exportExcel(JComponent com, HSSFWorkbook wb) {
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
                    } else {
                        return;
                    }
                } else {
                    selectedFile.createNewFile();

                }
                out = new FileOutputStream(selectedFile);
                wb.write(out);
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

    /**
     * 选择文件并返回文件路径
     *
     * @param com
     * @return
     */
    public static String ChooseExcelFile(JComponent com) {
        String filePath = "";
        try {

            JFileChooser fileChooser = new JFileChooser();
            //限制文件过滤
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Excel 97-2003(*.xls)", "xls");
            fileChooser.setFileFilter(filter);

            int ret = fileChooser.showSaveDialog(com.getRootPane());
            if (ret == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                filePath = selectedFile.getAbsolutePath();
            }
        } catch (Exception e) {
            log.error("error:", e);
        }
        return filePath;
    }

    /**
     * 保存指定文件
     *
     * @param com
     * @param srcFilePath
     */
    public static void saveExcelTemplate(JComponent com, String srcFilePath) {
        try {

            JFileChooser fileChooser = new JFileChooser();
            //限制文件过滤
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "Excel 97-2003(*.xls)", "xls");
            fileChooser.setFileFilter(filter);

            File defaultFile = new File("myTemplate.xls");
            fileChooser.setSelectedFile(defaultFile);

            int ret = fileChooser.showSaveDialog(com.getRootPane());
            if (ret == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (selectedFile.exists()) {
                    int copy = JOptionPane.showConfirmDialog(com.getRootPane(), "是否要覆盖当前文件", "保存", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (copy == JOptionPane.YES_OPTION) {
                        fileChooser.approveSelection();
                    } else {
                        return;
                    }
                } else {
                    selectedFile.createNewFile();
                }

                //进行文件拷贝
                copyFile(srcFilePath, selectedFile.getAbsolutePath());
            }
        } catch (IOException e) {
            log.error("error:", e);
        }
    }

    /**
     * 复制文件
     *
     * @param srcFilePath 源文件
     * @param destFilePath 目标文件
     */
    public static void copyFile(String srcFilePath, String destFilePath) {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(srcFilePath);
            out = new FileOutputStream(destFilePath);
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (Exception ex) {
                log.error("error:", ex);
            }
        }
    }

    /**
     * 新建多级目录
     *
     * @param path
     */
    public static void checkOrSaveDir(String path) {
        StringTokenizer st = new StringTokenizer(path, "/");
        String path1 = st.nextToken() + "/";
        String path2 = path1;
        while (st.hasMoreTokens()) {
            path1 = st.nextToken() + "/";
            path2 += path1;
            File inbox = new File(path2);
            if (!inbox.exists()) {
                inbox.mkdir();
            }
        }
    }
    
    /**
     * 清空某个目录，如果该目录有子目录则一并清空、删除
     * @param path
     * @return 
     */
    public static boolean clearFolder(String path){
        boolean flag = false;
        File file = new File(path);
        if(!file.exists()){
            log.error(path + "文件不存在！");
            return flag;
        }
        
        if(!file.isDirectory()){
            log.error(path + "非文件夹，不能清空！");
            return flag;
        }
        
        String[] fileList = file.list();
        File tmpFile = null;
        for(int i = 0; i < fileList.length; i++){
            if(path.endsWith(File.separator)){
                tmpFile = new File(path + fileList[i]);
            }else{
                tmpFile = new File(path + File.separator + fileList[i]);
            }
            
            if(tmpFile.isFile()){
                tmpFile.delete();
            }
            
            if(tmpFile.isDirectory()){
                //先清空目录中的文件
                clearFolder(tmpFile.getAbsolutePath());
                //再删除目录
                tmpFile.delete();
                flag = true;
            }
        }
        return flag;
    }
}
