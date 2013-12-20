package com.hrxc.auction.ui;

import com.hrxc.auction.action.GoodsListAction;
import com.hrxc.auction.domain.GoodsList;
import com.hrxc.auction.util.ExcelHelper;
import com.hrxc.auction.util.UITools;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author user
 */
public class GoodsListBatchImportDialog extends javax.swing.JDialog {

    private static Logger log = Logger.getLogger(GoodsListBatchImportDialog.class);

    /**
     * Creates new form GoodsListBatchImportDialog
     */
    public GoodsListBatchImportDialog(java.awt.Frame parent, boolean modal, String projectNo) {
        super(parent, modal);

        this.projectNo = projectNo;

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseFileBt = new org.jdesktop.swingx.JXButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        filePathFd = new org.jdesktop.swingx.JXTextField();
        downTemplateBt = new org.jdesktop.swingx.JXButton();
        executeImportBt = new org.jdesktop.swingx.JXButton();
        msgLabel = new org.jdesktop.swingx.JXLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("拍品清单批量导入");
        setFont(new java.awt.Font("黑体", 0, 14)); // NOI18N
        setResizable(false);

        chooseFileBt.setText("选择文件");
        chooseFileBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileBtActionPerformed(evt);
            }
        });

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel1.setText("文件路径：");

        downTemplateBt.setText("下载模板");
        downTemplateBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downTemplateBtActionPerformed(evt);
            }
        });

        executeImportBt.setText("执行导入");
        executeImportBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeImportBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filePathFd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooseFileBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(executeImportBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(downTemplateBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(528, 528, 528))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(downTemplateBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filePathFd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseFileBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(executeImportBt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(msgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseFileBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileBtActionPerformed
        String filePath = UITools.ChooseExcelFile(this.getRootPane());
        filePathFd.setText(filePath);
    }//GEN-LAST:event_chooseFileBtActionPerformed

    private void downTemplateBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downTemplateBtActionPerformed
        String srcFilePath = "config/goods_list_template.xls";
        UITools.saveExcelTemplate(this.getRootPane(), srcFilePath);
    }//GEN-LAST:event_downTemplateBtActionPerformed

    private void executeImportBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeImportBtActionPerformed
        String filePath = filePathFd.getText().trim();
        batchImportGoodsLists(filePath);
    }//GEN-LAST:event_executeImportBtActionPerformed

    /**
     * 解析文件并批量导入数据
     * @param filePath 
     */
    private void batchImportGoodsLists(String filePath) {
        ArrayList<GoodsList> list = null;
        String msg = "<html><p style=\"font-family:宋体;font-size:18px;color:red\">错误：errormsg</p></html>";
        String errormsg = "";
        try {
            HSSFWorkbook workbook = ExcelHelper.constructWorkbook(filePath);
            HSSFSheet sheet = workbook.getSheet("goodslist");

            //总记录行数
            int rows = sheet.getPhysicalNumberOfRows();

            /**
             * <p>第一行为标题行</p> <p>0-图录号 1-拍品名称 2-保留价 3-市场估价 4-起拍价 5-尺寸 6-完残度
             * 7-入库号 8-作者 9-委托方编号</p> 防止数据行某些字段值为空出现，每行单元格的个数以标题行为准
             */
            HSSFRow row = sheet.getRow(0);
            int cells = row.getPhysicalNumberOfCells();
            
            list = new ArrayList<GoodsList>();
            for (int m = 1; m < rows; m++) {
                row = sheet.getRow(m);
                GoodsList dto = null;
                for (int n = 0; n < cells; n++) {
                    String goodsNo = ExcelHelper.getCellString(row.getCell(0));
                    
                    //如果图录号为空，则直接退出循环
                    if(StringUtils.isEmpty(goodsNo)){
                        errormsg = "第[" + (m+1) + "]行，图录号为空，终止解析！";
                        msgLabel.setText(msg.replaceAll("errormsg", errormsg));
                        break;
                    }else{
                        dto = new GoodsList();
                    }
                    
                    dto.setGoodsNo(goodsNo);
                    String goodsName = ExcelHelper.getCellString(row.getCell(1));
                    dto.setGoodsName(goodsName);
                    Integer keepPrice = new BigDecimal(ExcelHelper.getCellString(row.getCell(2))).intValue();
                    dto.setKeepPrice(keepPrice);
                    Integer marketPrice = new BigDecimal(ExcelHelper.getCellString(row.getCell(3))).intValue();
                    dto.setMarketPrice(marketPrice);
                    Integer onsetPrice = new BigDecimal(ExcelHelper.getCellString(row.getCell(4))).intValue();
                    dto.setOnsetPrice(onsetPrice);
                    String goodsSize = ExcelHelper.getCellString(row.getCell(5));
                    dto.setGoodsSize(goodsSize);
                    String goodsIntact = ExcelHelper.getCellString(row.getCell(6));
                    dto.setGoodsIntact(goodsIntact);
                    String depotNo = ExcelHelper.getCellString(row.getCell(7));
                    dto.setDepotNo(depotNo);
                    String author = ExcelHelper.getCellString(row.getCell(8));
                    dto.setAuthor(author);
                    String clientNo = ExcelHelper.getCellString(row.getCell(9));
                    dto.setClientNo(clientNo);
                    
                    dto.setProjectNo(projectNo);
                    dto.setPkId(UITools.generateUUID());
                }
                if(dto != null){
                    list.add(dto);
                }
            }
            GoodsListAction.batchSaveObject(list);
            String success_msg = "<html><p style=\"font-family:宋体;font-size:18px;color:blue\">本次共成功导入数据[" + list.size() + "]条，请核对！</p></html>";
            msgLabel.setText(success_msg);
        } catch (Exception ex) {
            log.error("error:", ex);
            msgLabel.setText(msg.replaceAll("errormsg", ex.toString()));
        }
    }
    
    private String projectNo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton chooseFileBt;
    private org.jdesktop.swingx.JXButton downTemplateBt;
    private org.jdesktop.swingx.JXButton executeImportBt;
    private org.jdesktop.swingx.JXTextField filePathFd;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel msgLabel;
    // End of variables declaration//GEN-END:variables
}
