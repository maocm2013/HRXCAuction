/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrxc.auction.ui;

import com.hrxc.auction.util.TreeMenuConfig;
import java.awt.Toolkit;

/**
 *
 * @author user
 */
public class AuctionFrame extends javax.swing.JFrame {

    /**
     * Creates new form AuctionFrame
     */
    public AuctionFrame() {
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

        jToolBar1 = new javax.swing.JToolBar();
        jSplitPane1 = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JScrollPane();
        menuTree = new org.jdesktop.swingx.JXTree();
        rightPanel = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("华软信诚拍卖系统V1.0");
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/app01.png")));
        setName("auctionFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 600));
        setResizable(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        menuTree.setModel(TreeMenuConfig.generateTreeMenu());
        menuTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                menuTreeValueChanged(evt);
            }
        });
        leftPanel.setViewportView(menuTree);

        jSplitPane1.setLeftComponent(leftPanel);
        jSplitPane1.setRightComponent(rightPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_menuTreeValueChanged
        String menuName = evt.getPath().getLastPathComponent().toString();
        if (menuName.equals(TreeMenuConfig.MenuName.M_00_01)) {
            rightPanel.setViewportView(new GoodsListPanel());
        }
    }//GEN-LAST:event_menuTreeValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JScrollPane leftPanel;
    private org.jdesktop.swingx.JXTree menuTree;
    private javax.swing.JScrollPane rightPanel;
    // End of variables declaration//GEN-END:variables
}
