package com.hrxc.auction.ui;

import com.hrxc.auction.action.BargainRecordAction;
import com.hrxc.auction.action.BargainRecordTableConfig;
import com.hrxc.auction.action.BaseTableModel;
import com.hrxc.auction.domain.BargainRecord;
import com.hrxc.auction.util.ExcelHelper;
import com.hrxc.auction.util.UITools;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author user
 */
public class BargainRecordPanel extends javax.swing.JPanel {

    private static final Logger log = Logger.getLogger(BargainRecordPanel.class);

    /**
     * Creates new form BargainRecordPanel
     */
    public BargainRecordPanel(String projectNo) {
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

        toolBar = new javax.swing.JToolBar();
        addBton = new org.jdesktop.swingx.JXButton();
        deleteBton = new org.jdesktop.swingx.JXButton();
        editBton = new org.jdesktop.swingx.JXButton();
        exortBton = new org.jdesktop.swingx.JXButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BargainRecordTableConfig.MyTableModel model = new BargainRecordTableConfig().new MyTableModel();

        //初始化显示数据
        Object[][] datas = BargainRecordAction.getAllTableData(this.getProjectNo(),null, null);
        model.refreshContents(datas);
        dataTable = new org.jdesktop.swingx.JXTable(model);
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        fd_paddleNo = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        fd_goodsNo = new org.jdesktop.swingx.JXTextField();
        searchBton = new org.jdesktop.swingx.JXButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        addBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        addBton.setToolTipText("添加");
        addBton.setFocusable(false);
        addBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBton.setMinimumSize(new java.awt.Dimension(45, 63));
        addBton.setPreferredSize(new java.awt.Dimension(40, 40));
        addBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtonActionPerformed(evt);
            }
        });
        toolBar.add(addBton);

        deleteBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        deleteBton.setToolTipText("删除");
        deleteBton.setFocusable(false);
        deleteBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteBton.setPreferredSize(new java.awt.Dimension(40, 40));
        deleteBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtonActionPerformed(evt);
            }
        });
        toolBar.add(deleteBton);

        editBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        editBton.setToolTipText("修改");
        editBton.setFocusable(false);
        editBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBton.setPreferredSize(new java.awt.Dimension(40, 40));
        editBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtonActionPerformed(evt);
            }
        });
        toolBar.add(editBton);

        exortBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export.png"))); // NOI18N
        exortBton.setToolTipText("修改");
        exortBton.setFocusable(false);
        exortBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exortBton.setPreferredSize(new java.awt.Dimension(40, 40));
        exortBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exortBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exortBtonActionPerformed(evt);
            }
        });
        toolBar.add(exortBton);

        //隐藏第一列（主键）
        UITools.hideColumn(dataTable, 1);
        jScrollPane1.setViewportView(dataTable);

        jXLabel1.setText("竞买号牌：");

        jXLabel2.setText("图录号：");

        searchBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        searchBton.setText("查询");
        searchBton.setToolTipText("");
        searchBton.setFocusable(false);
        searchBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fd_paddleNo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fd_goodsNo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchBton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_paddleNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_goodsNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtonActionPerformed
        BargainRecordEditDialog dialog = new BargainRecordEditDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, null, this);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_addBtonActionPerformed

    private void searchBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtonActionPerformed
        String paddleNo = fd_paddleNo.getText().trim();
        String goodsNo = fd_goodsNo.getText().trim();
        refreshTableDatas(paddleNo, goodsNo);
    }//GEN-LAST:event_searchBtonActionPerformed

    private void editBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtonActionPerformed
        if (UITools.getCheckedRows(dataTable) != 1) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请确认您选择了一条记录！");
        } else {
            ArrayList<String> list = UITools.getCheckedRowsId(dataTable);
            String pkId = list.get(0);
            BargainRecord dto = BargainRecordAction.getObjectById(pkId);
            BargainRecordEditDialog dialog = new BargainRecordEditDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, dto, this);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_editBtonActionPerformed

    private void deleteBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtonActionPerformed
        if (UITools.getCheckedRows(dataTable) == 0) {
            JOptionPane.showMessageDialog(this.getRootPane(), "您至少需要选择一条记录！");
        } else {
            if (JOptionPane.showConfirmDialog(this.getRootPane(), "请确认您是否要删除数据？") == JOptionPane.YES_OPTION) {
                ArrayList<String> list = UITools.getCheckedRowsId(dataTable);
                BargainRecordAction.deleteObjectById(list);
                JOptionPane.showMessageDialog(this.getRootPane(), list.size() + "条记录删除成功！");
                refreshTableDatas(null, null);
            }
        }
    }//GEN-LAST:event_deleteBtonActionPerformed

    private void exortBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exortBtonActionPerformed
        HSSFWorkbook wb = ExcelHelper.createExcel((BaseTableModel) dataTable.getModel());
        UITools.exportExcel(this.getRootPane(), wb);
    }//GEN-LAST:event_exortBtonActionPerformed

    /**
     * 刷新表单数据
     */
    public void refreshTableDatas(String paddleNo, String goodsNo) {
        BargainRecordTableConfig.MyTableModel model = (BargainRecordTableConfig.MyTableModel) dataTable.getModel();
        model.refreshContents(BargainRecordAction.getAllTableData(this.getProjectNo(),paddleNo, goodsNo));
        //TODO:必须要重新设置一下model，否则刷新内容后界面无变化
        dataTable.setModel(model);
    }

    public String getProjectNo() {
        return projectNo;
    }
    
    private String projectNo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton addBton;
    private org.jdesktop.swingx.JXTable dataTable;
    private org.jdesktop.swingx.JXButton deleteBton;
    private org.jdesktop.swingx.JXButton editBton;
    private org.jdesktop.swingx.JXButton exortBton;
    private org.jdesktop.swingx.JXTextField fd_goodsNo;
    private org.jdesktop.swingx.JXTextField fd_paddleNo;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXButton searchBton;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
