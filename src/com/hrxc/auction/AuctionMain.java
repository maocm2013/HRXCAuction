package com.hrxc.auction;

import com.hrxc.auction.ui.AuctionFrame;
import com.hrxc.auction.ui.LoginDialog;
import com.hrxc.auction.util.Configuration;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class AuctionMain {

    private static final Logger log = Logger.getLogger(AuctionMain.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Log4j初始化
            Configuration.initLog4j();

        } catch (Exception ex) {
            log.error("log4j init error:", ex);
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            log.error("lookAndFeel set error:", ex);
        } catch (InstantiationException ex) {
            log.error("lookAndFeel set error:", ex);
        } catch (IllegalAccessException ex) {
            log.error("lookAndFeel set error:", ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            log.error("lookAndFeel set error:", ex);
        }
        //</editor-fold>

        /* Create and display the form */
        //TODO:程序启动后应单独启动一个线程进行数据文件备份
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AuctionFrame frame = new AuctionFrame();
                toLoginDialog(frame);
            }
        });
    }

    public static void toLoginDialog(AuctionFrame frame) {
        //首先进行登陆
        LoginDialog dialog = new LoginDialog(frame, true);
        //设置关闭窗体时的监听动作
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        //居中显示
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
