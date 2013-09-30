package com.hrxc.auction.ui;

import com.hrxc.auction.util.JdbcUtil;
import java.awt.Graphics2D;
import java.io.File;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class SingleProjectStatReportPanel extends javax.swing.JPanel {

    private static final Logger log = Logger.getLogger(SingleProjectStatReportPanel.class);

    /**
     * Creates new form BargainRecordSettlePanel
     */
    public SingleProjectStatReportPanel(String projectNo) {
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
        exportBton = new org.jdesktop.swingx.JXButton();
        showBton = new org.jdesktop.swingx.JXButton();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        fd_filePath = new org.jdesktop.swingx.JXTextField();
        reportPanel = new javax.swing.JScrollPane();

        setPreferredSize(new java.awt.Dimension(702, 443));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(702, 443));

        exportBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export.png"))); // NOI18N
        exportBton.setText("导出EXCEL");
        exportBton.setToolTipText(null);
        exportBton.setFocusable(false);
        exportBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBtonActionPerformed(evt);
            }
        });
        exportBton.setBounds(140, 0, 130, 41);
        checkLayeredPanel.add(exportBton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        showBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        showBton.setText("显示报表");
        showBton.setToolTipText(null);
        showBton.setFocusable(false);
        showBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBtonActionPerformed(evt);
            }
        });
        showBton.setBounds(0, 0, 130, 41);
        checkLayeredPanel.add(showBton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jXLabel1.setText("导出路径：");
        jXLabel1.setBounds(280, 10, 60, 30);
        checkLayeredPanel.add(jXLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fd_filePath.setEditable(false);
        fd_filePath.setText("C:\\\\bargainRecordCollectReport.xls");
        fd_filePath.setBounds(340, 10, 300, 30);
        checkLayeredPanel.add(fd_filePath, javax.swing.JLayeredPane.DEFAULT_LAYER);

        reportPanel.setMinimumSize(new java.awt.Dimension(700, 360));
        reportPanel.setPreferredSize(new java.awt.Dimension(700, 360));
        reportPanel.setBounds(0, 50, 700, 360);
        checkLayeredPanel.add(reportPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTabbedPane1.addTab("委托方成交统计", checkLayeredPanel);

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

    private void exportBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBtonActionPerformed
        exportReport();
    }//GEN-LAST:event_exportBtonActionPerformed

    private void showBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBtonActionPerformed
        showReport();
    }//GEN-LAST:event_showBtonActionPerformed

    private JasperPrint initReportContext() throws JRException {
        String rootPath = System.getProperty("user.dir").concat(File.separator).concat("config").concat(File.separator);
        String fileName = rootPath + "bargainRecordCollectReport.jasper";
        HashMap hm = new HashMap();
        hm.put("t_projectNo", this.projectNo);
        JasperPrint print  = JasperFillManager.fillReport(
                    fileName,
                    hm,
                    JdbcUtil.getInstance().getSession().getConnection());
        return print;
    }

    private void exportReport() {
        try {
            JasperPrint print = initReportContext();

            //将报表数据输出至Excel中
            JRXlsExporter exporter_xls = new JRXlsExporter();
            exporter_xls.setParameter(
                    JRXlsExporterParameter.OUTPUT_FILE_NAME,
                    fd_filePath.getText().trim());
            exporter_xls.setParameter(
                    JRExporterParameter.JASPER_PRINT, print);
            exporter_xls.exportReport();
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    private void showReport() {
        try {
            JasperPrint print = initReportContext();

            //将报表数据输出至JFrame
            JRGraphics2DExporter exporter_gui = new JRGraphics2DExporter();

            exporter_gui.setParameter(
                    JRGraphics2DExporterParameter.GRAPHICS_2D,
                    (Graphics2D) reportPanel.getGraphics());
            exporter_gui.setParameter(
                    JRExporterParameter.JASPER_PRINT, print);

            exporter_gui.exportReport();
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    public String getProjectNo() {
        return projectNo;
    }
    private String projectNo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane checkLayeredPanel;
    private org.jdesktop.swingx.JXButton exportBton;
    private org.jdesktop.swingx.JXTextField fd_filePath;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JScrollPane reportPanel;
    private org.jdesktop.swingx.JXButton showBton;
    // End of variables declaration//GEN-END:variables
}
