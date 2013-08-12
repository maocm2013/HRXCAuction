package com.hrxc.auction.ui;

import com.hrxc.auction.action.UserInfoAction;
import com.hrxc.auction.domain.UserInfo;
import com.hrxc.auction.util.MD5;
import com.hrxc.auction.util.SystemContext;
import com.hrxc.auction.util.UITools;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class LoginDialog extends javax.swing.JDialog {

    private static final Logger log = Logger.getLogger(LoginDialog.class);
    
    private AuctionFrame frame;

    /**
     * Creates new form LoginDialog
     */
    public LoginDialog(AuctionFrame parent, boolean modal) {
        super(parent, modal);
        this.frame = parent;
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

        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        fd_userNo = new org.jdesktop.swingx.JXTextField();
        fd_password = new javax.swing.JPasswordField();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        resetBton = new org.jdesktop.swingx.JXButton();
        loginBton = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("华软信诚拍卖系统");
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel1.setText("拍卖信息管理系统");
        jXLabel1.setFont(new java.awt.Font("黑体", 1, 18)); // NOI18N
        jXLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jXLabel2.setText("用户编号：");

        jXLabel3.setText("用户密码：");

        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel4.setText("版权所有@北京华软信诚拍卖行有限公司  http://ce-xcpm.com");
        jXLabel4.setFont(new java.awt.Font("隶书", 0, 14)); // NOI18N

        resetBton.setText("重  置");
        resetBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtonActionPerformed(evt);
            }
        });

        loginBton.setText("登  陆");
        loginBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jXLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fd_userNo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fd_password, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(resetBton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loginBton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_userNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetBton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtonActionPerformed
        fd_userNo.setText("");
        fd_password.setText("");
    }//GEN-LAST:event_resetBtonActionPerformed

    private void loginBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtonActionPerformed
        //登陆验证
        String userNo = fd_userNo.getText();
        String password = UITools.char2String(fd_password.getPassword());

        //log.debug("userNo=" + userNo + ",password=" + password);
        UserInfo user = UserInfoAction.getUserInfo(userNo);
        MD5 md5 = new MD5();
        if (user != null
                && user.getPassword().equals(md5.encryptMD5(password))) {

            //设置系统用户信息
            SystemContext.getInstance().setUser(user);
            this.dispose();

            //设置用户信息显示
            frame.getUserInfoLabel().setText("工号：" + user.getUserNo() + "|名称：" + user.getUserName());

            //居中显示
            frame.setLocationRelativeTo(null);
            //重新加载菜单
            frame.reLoadMenuTree();
            
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this.getRootPane(), "用户编号或密码输入错误！");
        }
    }//GEN-LAST:event_loginBtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField fd_password;
    private org.jdesktop.swingx.JXTextField fd_userNo;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXButton loginBton;
    private org.jdesktop.swingx.JXButton resetBton;
    // End of variables declaration//GEN-END:variables
}
