/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.ui;

import com.hrxc.auction.action.BiddingPaddleAction;
import com.hrxc.auction.action.BiddingPaddleTableConfig;
import com.hrxc.auction.domain.BiddingPaddle;
import com.hrxc.auction.util.Constant;
import com.hrxc.auction.util.UITools;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class BiddingPaddlePanel extends javax.swing.JPanel {

    private static final Logger log = Logger.getLogger(BiddingPaddlePanel.class);

    /**
     * Creates new form BiddingPaddlePanel
     */
    public BiddingPaddlePanel() {
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
        paddleInfoPrintBton = new org.jdesktop.swingx.JXButton();
        settleListPrintBton = new org.jdesktop.swingx.JXButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        BiddingPaddleTableConfig.MyTableModel model = new BiddingPaddleTableConfig().new MyTableModel();

        //初始化显示数据
        Object[][] datas = BiddingPaddleAction.getAllTableData(null, null);
        model.refreshContents(datas);
        dataTable = new org.jdesktop.swingx.JXTable(model);
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        fd_paddleNo = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        fd_custName = new org.jdesktop.swingx.JXTextField();
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

        paddleInfoPrintBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print.png"))); // NOI18N
        paddleInfoPrintBton.setText("竞买号牌信息打印");
        paddleInfoPrintBton.setFocusable(false);
        paddleInfoPrintBton.setMaximumSize(new java.awt.Dimension(145, 43));
        paddleInfoPrintBton.setMinimumSize(new java.awt.Dimension(145, 43));
        paddleInfoPrintBton.setPreferredSize(new java.awt.Dimension(145, 43));
        paddleInfoPrintBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paddleInfoPrintBtonActionPerformed(evt);
            }
        });
        toolBar.add(paddleInfoPrintBton);

        settleListPrintBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print.png"))); // NOI18N
        settleListPrintBton.setText("结款单打印");
        settleListPrintBton.setFocusable(false);
        settleListPrintBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settleListPrintBtonActionPerformed(evt);
            }
        });
        toolBar.add(settleListPrintBton);

        //隐藏第一列（主键）
        UITools.hideColumn(dataTable, 1);
        jScrollPane1.setViewportView(dataTable);

        jXLabel1.setText("竞买号牌：");

        jXLabel2.setText("竞买人姓名：");

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
                .addComponent(fd_custName, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(fd_custName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtonActionPerformed
        BiddingPaddleEditDialog dialog = new BiddingPaddleEditDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, null, this);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_addBtonActionPerformed

    private void searchBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtonActionPerformed
        String paddleNo = fd_paddleNo.getText().trim();
        String custName = fd_custName.getText().trim();
        refreshTableDatas(paddleNo, custName);
    }//GEN-LAST:event_searchBtonActionPerformed

    private void editBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtonActionPerformed
        if (UITools.getCheckedRows(dataTable) != 1) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请确认您选择了一条记录！");
        } else {
            ArrayList<String> list = UITools.getCheckedRowsId(dataTable);
            String pkId = list.get(0);
            BiddingPaddle dto = BiddingPaddleAction.getObjectById(pkId);
            BiddingPaddleEditDialog dialog = new BiddingPaddleEditDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, dto, this);
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
                BiddingPaddleAction.deleteObjectById(list);
                JOptionPane.showMessageDialog(this.getRootPane(), list.size() + "条记录删除成功！");
                refreshTableDatas(null, null);
            }
        }
    }//GEN-LAST:event_deleteBtonActionPerformed

    private void paddleInfoPrintBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paddleInfoPrintBtonActionPerformed
        if (UITools.getCheckedRows(dataTable) != 1) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请确认您选择了一条记录！");
        } else {
            ArrayList<String> list = UITools.getCheckedRowsId(dataTable);
            String pkId = list.get(0);
            BiddingPaddlePrintDialog dialog = new BiddingPaddlePrintDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, pkId, Constant.PrintType.TYPE_PADDLE_INFO_PRINT);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_paddleInfoPrintBtonActionPerformed

    private void settleListPrintBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settleListPrintBtonActionPerformed
        if (UITools.getCheckedRows(dataTable) != 1) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请确认您选择了一条记录！");
        } else {
            ArrayList<String> list = UITools.getCheckedRowsId(dataTable);
            String pkId = list.get(0);
            BiddingPaddlePrintDialog dialog = new BiddingPaddlePrintDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, pkId, Constant.PrintType.TYPE_SETTLE_LIST_PRINT);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_settleListPrintBtonActionPerformed

    /**
     * 刷新表单数据
     */
    public void refreshTableDatas(String paddleNo, String custName) {
        BiddingPaddleTableConfig.MyTableModel model = (BiddingPaddleTableConfig.MyTableModel) dataTable.getModel();
        model.refreshContents(BiddingPaddleAction.getAllTableData(paddleNo, custName));
        //TODO:必须要重新设置一下model，否则刷新内容后界面无变化
        dataTable.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton addBton;
    private org.jdesktop.swingx.JXTable dataTable;
    private org.jdesktop.swingx.JXButton deleteBton;
    private org.jdesktop.swingx.JXButton editBton;
    private org.jdesktop.swingx.JXTextField fd_custName;
    private org.jdesktop.swingx.JXTextField fd_paddleNo;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXButton paddleInfoPrintBton;
    private org.jdesktop.swingx.JXButton searchBton;
    private org.jdesktop.swingx.JXButton settleListPrintBton;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
