package com.hrxc.auction.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author user
 */
public class ExcelHelper {

    /**
     * 根据已经有的excel表构造POI对象
     *
     * @param filename
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static HSSFWorkbook constructWorkbook(String filename) throws FileNotFoundException, IOException {
        HSSFWorkbook wb = null;
        FileInputStream in = new FileInputStream(filename);
        wb = new HSSFWorkbook(in);
        in.close();
        return wb;
    }

    /**
     * 获取单元格的字符串值
     *
     * @param cell
     * @return
     */
    public static String getCellString(HSSFCell cell) {
        String cellValue = "";
        if (cell != null) {
            int cellType = cell.getCellType();
            //只处理了数字和字符串
            switch (cellType) {
                case Cell.CELL_TYPE_NUMERIC:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.getStringCellValue().trim();
                    break;
                //如果是数学公式则使用获取数值方法取得
                case Cell.CELL_TYPE_FORMULA:
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                default:
                    cellValue = cell.getStringCellValue().trim();
                    break;
            }

        }
        return cellValue;
    }
    
    /**
     * 根据tableModel生成excel文件
     * @param model
     * @return 
     */
    public static HSSFWorkbook createExcel(MyTableModel model){
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet1");
        //创建标题行
        Row title = sheet.createRow(0);
        
        for(int t = 3; t < model.getColumnCount(); t++){
            Cell cell = title.createCell(t-3);
            cell.setCellValue(model.getColumnName(t));
        }
        
        int row_count = model.getRowCount();
        int col_count = model.getColumnCount();
        for (int i = 0; i < row_count; i++) {
            Row row = sheet.createRow(i+1);
            //从第三个字段开始创建单元格
            for (int k = 3; k < col_count; k++) {
                //避免前3列无数据
                Cell cell = row.createCell(k - 3);
                Object obj = model.getValueAt(i, k);
                if (obj != null) {
                    if (obj instanceof Integer) {
                        cell.setCellValue((Integer) obj);
                    } else {
                        cell.setCellValue(String.valueOf(obj));
                    }
                }
            }
        }
        return wb;
    }
}
