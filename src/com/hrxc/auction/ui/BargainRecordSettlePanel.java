package com.hrxc.auction.ui;

import com.hrxc.auction.action.BargainRecordAction;
import com.hrxc.auction.util.MyTableModel;
import com.hrxc.auction.action.BiddingPaddleAction;
import com.hrxc.auction.action.PaymentListAction;
import com.hrxc.auction.domain.BargainRecord;
import com.hrxc.auction.domain.BiddingPaddle;
import com.hrxc.auction.domain.PaymentList;
import com.hrxc.auction.domain.vo.BargainRecordVo;
import com.hrxc.auction.domain.vo.PaymentListVo;
import com.hrxc.auction.util.Constant;
import com.hrxc.auction.util.DictEnum;
import com.hrxc.auction.util.DictEnum.SettleState;
import com.hrxc.auction.util.ExcelHelper;
import com.hrxc.auction.util.MyTableConfig;
import com.hrxc.auction.util.UITools;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author user
 */
public class BargainRecordSettlePanel extends javax.swing.JPanel {
    private static final Logger log = Logger.getLogger(BargainRecordSettlePanel.class);
    private BiddingPaddle paddleInfo;
    
    /**
     * Creates new form BargainRecordSettlePanel
     */
    public BargainRecordSettlePanel(String projectNo) {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        checkLayeredPanel = new javax.swing.JLayeredPane();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        fd_paddleNo_c = new org.jdesktop.swingx.JXTextField();
        searchBton_c = new org.jdesktop.swingx.JXButton();
        toSettleBton_c = new org.jdesktop.swingx.JXButton();
        exportBton_c = new org.jdesktop.swingx.JXButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MyTableModel model_c = MyTableConfig.getBargainRecordTableModel();

        //初始化显示数据
        BargainRecordVo condition_c = new BargainRecordVo();
        condition_c.setProjectNo(this.getProjectNo());
        condition_c.setSettleState(DictEnum.SettleState.BARGAIN);
        Object[][] datas_c  = BargainRecordAction.getAllTableData(condition_c);
        model_c.refreshContents(datas_c);
        dataTable_c = new org.jdesktop.swingx.JXTable(model_c);
        settleLayeredPane = new javax.swing.JLayeredPane();
        jXLabel7 = new org.jdesktop.swingx.JXLabel();
        fd_paddleNo_s = new org.jdesktop.swingx.JXTextField();
        jXLabel8 = new org.jdesktop.swingx.JXLabel();
        searchBton_s = new org.jdesktop.swingx.JXButton();
        toSettleBton_s = new org.jdesktop.swingx.JXButton();
        exportBton_s = new org.jdesktop.swingx.JXButton();
        settleListDataPane = new javax.swing.JScrollPane();
        MyTableModel model_n = MyTableConfig.getBargainRecordTableModel();

        //初始化显示数据
        Object[][] datas_n = null;
        model_n.refreshContents(datas_n);
        dataTable_s = new org.jdesktop.swingx.JXTable(model_n);
        paymentLayeredPane = new javax.swing.JLayeredPane();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        fd_paddleNo_p = new org.jdesktop.swingx.JXTextField();
        searchBton_p = new org.jdesktop.swingx.JXButton();
        undoSettleBton_p = new org.jdesktop.swingx.JXButton();
        exportBton_p = new org.jdesktop.swingx.JXButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MyTableModel model_p = MyTableConfig.getPaymentListTableModel();

        //初始化显示数据
        PaymentListVo condition_p = new PaymentListVo();
        condition_p.setProjectNo(this.getProjectNo());
        Object[][] datas_p = PaymentListAction.getAllTableData(condition_p);
        model_p.refreshContents(datas_p);
        dataTable_p = new org.jdesktop.swingx.JXTable(model_p);
        settleListPrintBton = new org.jdesktop.swingx.JXButton();
        depositLayeredPane = new javax.swing.JLayeredPane();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        fd_paddleNo_d = new org.jdesktop.swingx.JXTextField();
        searchBton_d = new org.jdesktop.swingx.JXButton();
        jXLabel6 = new org.jdesktop.swingx.JXLabel();
        lb_paddleInfo = new org.jdesktop.swingx.JXLabel();
        backCashDepositBt = new org.jdesktop.swingx.JXButton();

        setPreferredSize(new java.awt.Dimension(702, 443));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(702, 443));

        jXLabel1.setText("竞买号牌：");
        jXLabel1.setBounds(0, 10, 60, 30);
        checkLayeredPanel.add(jXLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fd_paddleNo_c.setBounds(60, 10, 110, 30);
        checkLayeredPanel.add(fd_paddleNo_c, javax.swing.JLayeredPane.DEFAULT_LAYER);

        searchBton_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        searchBton_c.setText("查询");
        searchBton_c.setToolTipText(null);
        searchBton_c.setFocusable(false);
        searchBton_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBton_cActionPerformed(evt);
            }
        });
        searchBton_c.setBounds(190, 10, 93, 30);
        checkLayeredPanel.add(searchBton_c, javax.swing.JLayeredPane.DEFAULT_LAYER);

        toSettleBton_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finish.png"))); // NOI18N
        toSettleBton_c.setText("成交复核");
        toSettleBton_c.setToolTipText(null);
        toSettleBton_c.setFocusable(false);
        toSettleBton_c.setPreferredSize(new java.awt.Dimension(40, 40));
        toSettleBton_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSettleBton_cActionPerformed(evt);
            }
        });
        toSettleBton_c.setBounds(60, 50, 120, 40);
        checkLayeredPanel.add(toSettleBton_c, javax.swing.JLayeredPane.DEFAULT_LAYER);

        exportBton_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export.png"))); // NOI18N
        exportBton_c.setToolTipText("导出");
        exportBton_c.setFocusable(false);
        exportBton_c.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportBton_c.setPreferredSize(new java.awt.Dimension(40, 40));
        exportBton_c.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportBton_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBton_cActionPerformed(evt);
            }
        });
        exportBton_c.setBounds(10, 50, 40, 40);
        checkLayeredPanel.add(exportBton_c, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(850, 400));

        UITools.setTableProps(dataTable_c, MyTableConfig.BargainRecord.columns);
        //隐藏付款编号列
        UITools.hideColumn(dataTable_c, "付款编号");
        UITools.hideColumn(dataTable_c, "委托方编号");
        UITools.hideColumn(dataTable_c, "项目编号");
        jScrollPane1.setViewportView(dataTable_c);

        jScrollPane1.setBounds(0, 94, 1060, 480);
        checkLayeredPanel.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("成交复核", checkLayeredPanel);

        jXLabel7.setText("竞买号牌：");
        jXLabel7.setBounds(0, 10, 60, 30);
        settleLayeredPane.add(jXLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fd_paddleNo_s.setBounds(60, 10, 110, 30);
        settleLayeredPane.add(fd_paddleNo_s, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jXLabel8.setForeground(new java.awt.Color(250, 12, 12));
        jXLabel8.setText("*");
        jXLabel8.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jXLabel8.setBounds(170, 10, 20, 30);
        settleLayeredPane.add(jXLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        searchBton_s.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        searchBton_s.setText("查询");
        searchBton_s.setToolTipText(null);
        searchBton_s.setFocusable(false);
        searchBton_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBton_sActionPerformed(evt);
            }
        });
        searchBton_s.setBounds(190, 10, 93, 30);
        settleLayeredPane.add(searchBton_s, javax.swing.JLayeredPane.DEFAULT_LAYER);

        toSettleBton_s.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finish.png"))); // NOI18N
        toSettleBton_s.setText("款项结算");
        toSettleBton_s.setToolTipText(null);
        toSettleBton_s.setFocusable(false);
        toSettleBton_s.setPreferredSize(new java.awt.Dimension(40, 40));
        toSettleBton_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSettleBton_sActionPerformed(evt);
            }
        });
        toSettleBton_s.setBounds(60, 50, 120, 40);
        settleLayeredPane.add(toSettleBton_s, javax.swing.JLayeredPane.DEFAULT_LAYER);

        exportBton_s.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export.png"))); // NOI18N
        exportBton_s.setToolTipText("导出");
        exportBton_s.setFocusable(false);
        exportBton_s.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportBton_s.setPreferredSize(new java.awt.Dimension(40, 40));
        exportBton_s.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportBton_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBton_sActionPerformed(evt);
            }
        });
        exportBton_s.setBounds(10, 50, 40, 40);
        settleLayeredPane.add(exportBton_s, javax.swing.JLayeredPane.DEFAULT_LAYER);

        UITools.setTableProps(dataTable_s, MyTableConfig.BargainRecord.columns);
        //隐藏付款编号列
        UITools.hideColumn(dataTable_s, "付款编号");
        settleListDataPane.setViewportView(dataTable_s);

        settleListDataPane.setBounds(0, 94, 1060, 480);
        settleLayeredPane.add(settleListDataPane, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("款项结算", settleLayeredPane);

        jXLabel3.setText("竞买号牌：");
        jXLabel3.setBounds(0, 10, 60, 30);
        paymentLayeredPane.add(jXLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fd_paddleNo_p.setBounds(60, 10, 110, 30);
        paymentLayeredPane.add(fd_paddleNo_p, javax.swing.JLayeredPane.DEFAULT_LAYER);

        searchBton_p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        searchBton_p.setText("查询");
        searchBton_p.setToolTipText(null);
        searchBton_p.setFocusable(false);
        searchBton_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBton_pActionPerformed(evt);
            }
        });
        searchBton_p.setBounds(190, 10, 93, 30);
        paymentLayeredPane.add(searchBton_p, javax.swing.JLayeredPane.DEFAULT_LAYER);

        undoSettleBton_p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/undo.png"))); // NOI18N
        undoSettleBton_p.setText("撤销结算");
        undoSettleBton_p.setToolTipText(null);
        undoSettleBton_p.setFocusable(false);
        undoSettleBton_p.setPreferredSize(new java.awt.Dimension(40, 40));
        undoSettleBton_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoSettleBton_pActionPerformed(evt);
            }
        });
        undoSettleBton_p.setBounds(60, 50, 120, 40);
        paymentLayeredPane.add(undoSettleBton_p, javax.swing.JLayeredPane.DEFAULT_LAYER);

        exportBton_p.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export.png"))); // NOI18N
        exportBton_p.setToolTipText("导出");
        exportBton_p.setFocusable(false);
        exportBton_p.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportBton_p.setPreferredSize(new java.awt.Dimension(40, 40));
        exportBton_p.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportBton_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBton_pActionPerformed(evt);
            }
        });
        exportBton_p.setBounds(10, 50, 40, 40);
        paymentLayeredPane.add(exportBton_p, javax.swing.JLayeredPane.DEFAULT_LAYER);

        UITools.setTableProps(dataTable_p, MyTableConfig.PaymentList.columns);
        jScrollPane2.setViewportView(dataTable_p);

        jScrollPane2.setBounds(0, 94, 1060, 480);
        paymentLayeredPane.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        settleListPrintBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print.png"))); // NOI18N
        settleListPrintBton.setText("结款单打印");
        settleListPrintBton.setFocusable(false);
        settleListPrintBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settleListPrintBtonActionPerformed(evt);
            }
        });
        settleListPrintBton.setBounds(190, 50, 129, 41);
        paymentLayeredPane.add(settleListPrintBton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("付款清单", paymentLayeredPane);

        jXLabel4.setText("竞买号牌：");
        jXLabel4.setBounds(0, 10, 60, 30);
        depositLayeredPane.add(jXLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fd_paddleNo_d.setBounds(60, 10, 110, 30);
        depositLayeredPane.add(fd_paddleNo_d, javax.swing.JLayeredPane.DEFAULT_LAYER);

        searchBton_d.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        searchBton_d.setText("查询");
        searchBton_d.setFocusable(false);
        searchBton_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBton_dActionPerformed(evt);
            }
        });
        searchBton_d.setBounds(190, 10, 93, 30);
        depositLayeredPane.add(searchBton_d, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jXLabel6.setForeground(new java.awt.Color(250, 12, 12));
        jXLabel6.setText("*");
        jXLabel6.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        jXLabel6.setBounds(170, 10, 20, 30);
        depositLayeredPane.add(jXLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lb_paddleInfo.setText("号牌信息：");
        lb_paddleInfo.setFont(new java.awt.Font("黑体", 0, 16)); // NOI18N
        lb_paddleInfo.setBounds(20, 60, 440, 210);
        depositLayeredPane.add(lb_paddleInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        backCashDepositBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/undo.png"))); // NOI18N
        backCashDepositBt.setText("退还保证金");
        backCashDepositBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backCashDepositBtActionPerformed(evt);
            }
        });
        backCashDepositBt.setBounds(290, 10, 130, 30);
        depositLayeredPane.add(backCashDepositBt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("退还保证金", depositLayeredPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBton_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBton_cActionPerformed
        String paddleNo = fd_paddleNo_c.getText().trim();
        refreshTableDatas(dataTable_c, DictEnum.SettleState.BARGAIN, paddleNo, null);
    }//GEN-LAST:event_searchBton_cActionPerformed

    private void toSettleBton_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSettleBton_cActionPerformed
        if (UITools.getCheckedRows(dataTable_c) != 1) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请确认您选择了一条记录！");
        } else {
            ArrayList<String> list = UITools.getCheckedRowsId(dataTable_c);
            String pkId = list.get(0);
            BargainRecordAction.updateSettleState(DictEnum.SettleState.RECHECKED, pkId, null);
            refreshTableDatas(dataTable_c, DictEnum.SettleState.BARGAIN, null, null);
            JOptionPane.showMessageDialog(this.getRootPane(), "成交记录复核成功！");
        }
    }//GEN-LAST:event_toSettleBton_cActionPerformed

    private void exportBton_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBton_cActionPerformed
        HSSFWorkbook wb = ExcelHelper.createExcel((MyTableModel) dataTable_c.getModel());
        UITools.exportExcel(this.getRootPane(), wb);
    }//GEN-LAST:event_exportBton_cActionPerformed

    private void searchBton_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBton_pActionPerformed
        String paddleNo = fd_paddleNo_p.getText().trim();
        refreshPaymentTableDatas(dataTable_p, paddleNo);
    }//GEN-LAST:event_searchBton_pActionPerformed

    private void undoSettleBton_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoSettleBton_pActionPerformed
        if (UITools.getCheckedRows(dataTable_p) != 1) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请确认您选择了一条记录！");
        } else {
            if (JOptionPane.showConfirmDialog(this.getRootPane(), "请确认您是否要撤销结算？") == JOptionPane.YES_OPTION) {
                ArrayList<String> list = UITools.getCheckedRowsId(dataTable_p);
                String pkId = list.get(0);
                PaymentList dto = PaymentListAction.getObjectById(pkId);
                String paymentNo = dto.getPaymentNo();
                //1.还原成交记录为已复核未结清状态           
                List<BargainRecord> recordList = BargainRecordAction.getBargainRecordListByPaymentNo(this.getProjectNo(), paymentNo);
                if (recordList != null && recordList.size() > 0) {
                    for (int i = 0; i < recordList.size(); i++) {
                        BargainRecord record = recordList.get(i);
                        BargainRecordAction.updateSettleState(DictEnum.SettleState.RECHECKED, record.getPkId(), "");
                    }
                }

                //2.还原号牌保证金状态及保证金付款编号
                BiddingPaddle paddleInfo = BiddingPaddleAction.getPaddleInfoByPaymentNo(projectNo, paymentNo);
                if (paddleInfo != null) {
                    log.debug(paddleInfo.getPaddleNo() + "|存在抵扣保证金，需要还原保证金使用状态");
                    BiddingPaddleAction.updateCashDepositStateById(paddleInfo.getPkId(), DictEnum.CashDepositState.NOT_USE, "");
                }

                //3.将付款记录标记为无效
                PaymentListAction.updatePaymentStateById(dto.getPkId(), DictEnum.PaymentState.INVALID);

                JOptionPane.showMessageDialog(this.getRootPane(), "付款编号【" + paymentNo + "】撤销结算操作成功！");
                refreshPaymentTableDatas(this.dataTable_p, null);
            }
        }
    }//GEN-LAST:event_undoSettleBton_pActionPerformed

    private void exportBton_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBton_pActionPerformed
        HSSFWorkbook wb = ExcelHelper.createExcel((MyTableModel) dataTable_p.getModel());
        UITools.exportExcel(this.getRootPane(), wb);
    }//GEN-LAST:event_exportBton_pActionPerformed

    private void settleListPrintBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settleListPrintBtonActionPerformed
        if (UITools.getCheckedRows(dataTable_p) != 1) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请确认您选择了一条记录！");
        } else {
            ArrayList<String> list = UITools.getCheckedRowsId(dataTable_p);
            String pkId = list.get(0);
            BiddingRecordPrintDialog dialog = new BiddingRecordPrintDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, null,pkId, Constant.PrintType.TYPE_SETTLE_LIST_PRINT);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_settleListPrintBtonActionPerformed

    private void searchBton_dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBton_dActionPerformed
        String paddleNo = fd_paddleNo_d.getText().trim();
        if (StringUtils.isEmpty(paddleNo)) {
            JOptionPane.showMessageDialog(this.getRootPane(), "请输入竞买号牌后再进行查询！");
            return;
        }
        BiddingPaddle paddleInfo = BiddingPaddleAction.getPaddleInfoByNo(this.getProjectNo(), paddleNo);
        if(paddleInfo != null){
            this.paddleInfo = paddleInfo;
            
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            sb.append("******号牌信息******<br>");
            sb.append("姓名：" + paddleInfo.getCustName() + "<br>");
            sb.append("证件类型：" + paddleInfo.getCertType() + "<br>");
            sb.append("地址：" + paddleInfo.getCustAddr() + "<br>");
            sb.append("联系电话：" + paddleInfo.getCustTel() + "<br>");
            sb.append("保证金：" + paddleInfo.getCashDeposit() + "<br>");
            sb.append("保证金使用状态：" + DictEnum.getDictDesc(DictEnum.CashDepositState.dataMap, paddleInfo.getCashDepositState()) + "<br>");
            sb.append("保证金付款编号：" + StringUtils.trimToEmpty(paddleInfo.getCashDepositPaymentNo()) + "<br>");
            
            //计算成交记录数与未结算成交记录数
            List<BargainRecord> list = BargainRecordAction.getBargainRecordListByPaddleNo(this.getProjectNo(),paddleNo);
            int bargainRecordNum = 0;
            int noSettleBargainRecordNum = 0;
            if(list != null && list.size() >0){
                bargainRecordNum = list.size();
                for(int i = 0; i < list.size(); i++){
                    BargainRecord record = list.get(i);
                    if(!record.getSettleState().equals(SettleState.SETTLED)){
                        noSettleBargainRecordNum++;
                    }
                }
            }
            sb.append("成交记录总数：" + bargainRecordNum + "<br>");
            sb.append("未结算成交记录数：" + noSettleBargainRecordNum);
            sb.append("</html>");
            lb_paddleInfo.setText(sb.toString());
            
            if(!paddleInfo.getCashDepositState().equals(DictEnum.CashDepositState.NOT_USE)){
                backCashDepositBt.setEnabled(false);
            }else{
                backCashDepositBt.setEnabled(true);
            }
        }else{
            JOptionPane.showMessageDialog(this.getRootPane(), "您输入的竞买号牌无相应数据，请确认！");
        }
    }//GEN-LAST:event_searchBton_dActionPerformed
  
    private void searchBton_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBton_sActionPerformed
        if(StringUtils.isEmpty(fd_paddleNo_s.getText())){
            JOptionPane.showMessageDialog(this.getRootPane(), "请输入竞买号牌后再进行查询！");
            fd_paddleNo_s.requestFocus();
            return;
        }
        String paddleNo = fd_paddleNo_s.getText().trim();
        refreshTableDatas(dataTable_s, DictEnum.SettleState.RECHECKED, paddleNo, null);
    }//GEN-LAST:event_searchBton_sActionPerformed

    private void toSettleBton_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSettleBton_sActionPerformed
        if (UITools.getCheckedRows(dataTable_s) == 0) {
            JOptionPane.showMessageDialog(this.getRootPane(), "您至少需要选择一条记录！");
        } else {
            //获取号牌信息并组合付款清单
            String paddleNo = fd_paddleNo_s.getText().trim();
            BiddingPaddle paddleInfo = BiddingPaddleAction.getPaddleInfoByNo(this.getProjectNo(), paddleNo);
            ArrayList<String> list = UITools.getCheckedRowsId(dataTable_s);
            int totalAmount = 0;
            for (int i = 0; i < list.size(); i++) {
                BargainRecord record = BargainRecordAction.getObjectById(list.get(i));
                totalAmount += record.getBargainPrice();
            }

            //构造付款清单对象
            PaymentList payment = new PaymentList();
            payment.setProjectNo(this.getProjectNo());
            payment.setPaymentNo(paddleInfo.getPaddleNo() + "-" + DateFormatUtils.format(new java.util.Date(), "yyyyMMddHHmmss"));
            payment.setPaddleNo(paddleInfo.getPaddleNo());
            payment.setGoodsNum(list.size());
            payment.setTotalAmount(totalAmount);
            payment.setAccountPaid(totalAmount);
            payment.setNonPayment(0);

            BargainRecordSettleDialog dialog = new BargainRecordSettleDialog((javax.swing.JFrame) this.getRootPane().getParent(), true, paddleInfo, payment, list, this);
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_toSettleBton_sActionPerformed

    private void exportBton_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBton_sActionPerformed
        HSSFWorkbook wb = ExcelHelper.createExcel((MyTableModel) dataTable_s.getModel());
        UITools.exportExcel(this.getRootPane(), wb);
    }//GEN-LAST:event_exportBton_sActionPerformed

    private void backCashDepositBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backCashDepositBtActionPerformed
        if(this.paddleInfo != null){
            if (JOptionPane.showConfirmDialog(this.getRootPane(), "退还保证金操作无法撤销，请确认！") == JOptionPane.YES_OPTION) {
                BiddingPaddleAction.updateCashDepositStateById(paddleInfo.getPkId(), DictEnum.CashDepositState.GIVE_BACK, null);
                JOptionPane.showMessageDialog(this.getRootPane(), "号牌【" + paddleInfo.getPaddleNo() + "】保证金已经退还成功！");
                backCashDepositBt.setEnabled(false);
            }
        }else{
            JOptionPane.showMessageDialog(this.getRootPane(), "无竞买号牌信息，请先进行查询！");
        }
    }//GEN-LAST:event_backCashDepositBtActionPerformed

    /**
     * 刷新表单数据
     */
    public void refreshTableDatas(JXTable dataTable, String settleState, String paddleNo, String goodsNo) {
        MyTableModel model = (MyTableModel) dataTable.getModel();

        BargainRecordVo condition = new BargainRecordVo();
        condition.setProjectNo(this.getProjectNo());
        condition.setSettleState(settleState);
        condition.setPaddleNo(paddleNo);
        condition.setGoodsNo(goodsNo);
        model.refreshContents(BargainRecordAction.getAllTableData(condition));
        //TODO:必须要重新设置一下model，否则刷新内容后界面无变化
        dataTable.setModel(model);
    }

    /**
     * 刷新表单数据
     */
    public void refreshPaymentTableDatas(JXTable dataTable, String paddleNo) {
        MyTableModel model = (MyTableModel) dataTable.getModel();

        PaymentListVo condition = new PaymentListVo();
        condition.setProjectNo(this.getProjectNo());
        condition.setPaddleNo(paddleNo);
        model.refreshContents(PaymentListAction.getAllTableData(condition));
        //TODO:必须要重新设置一下model，否则刷新内容后界面无变化
        dataTable.setModel(model);
    }

    public String getProjectNo() {
        return projectNo;
    }
    private String projectNo;

    public JXTable getDataTable_s() {
        return dataTable_s;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXButton backCashDepositBt;
    private javax.swing.JLayeredPane checkLayeredPanel;
    private org.jdesktop.swingx.JXTable dataTable_c;
    private org.jdesktop.swingx.JXTable dataTable_p;
    private org.jdesktop.swingx.JXTable dataTable_s;
    private javax.swing.JLayeredPane depositLayeredPane;
    private org.jdesktop.swingx.JXButton exportBton_c;
    private org.jdesktop.swingx.JXButton exportBton_p;
    private org.jdesktop.swingx.JXButton exportBton_s;
    private org.jdesktop.swingx.JXTextField fd_paddleNo_c;
    private org.jdesktop.swingx.JXTextField fd_paddleNo_d;
    private org.jdesktop.swingx.JXTextField fd_paddleNo_p;
    private org.jdesktop.swingx.JXTextField fd_paddleNo_s;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel6;
    private org.jdesktop.swingx.JXLabel jXLabel7;
    private org.jdesktop.swingx.JXLabel jXLabel8;
    private org.jdesktop.swingx.JXLabel lb_paddleInfo;
    private javax.swing.JLayeredPane paymentLayeredPane;
    private org.jdesktop.swingx.JXButton searchBton_c;
    private org.jdesktop.swingx.JXButton searchBton_d;
    private org.jdesktop.swingx.JXButton searchBton_p;
    private org.jdesktop.swingx.JXButton searchBton_s;
    private javax.swing.JLayeredPane settleLayeredPane;
    private javax.swing.JScrollPane settleListDataPane;
    private org.jdesktop.swingx.JXButton settleListPrintBton;
    private org.jdesktop.swingx.JXButton toSettleBton_c;
    private org.jdesktop.swingx.JXButton toSettleBton_s;
    private org.jdesktop.swingx.JXButton undoSettleBton_p;
    // End of variables declaration//GEN-END:variables
}
