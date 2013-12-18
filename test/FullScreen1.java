
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FullScreen1 {

    public FullScreen1() {
        final JFrame jframe = new JFrame();
        JButton fullsButton = new JButton("全屏显示");
        JButton windowButton = new JButton("退出全屏");
        JButton exitButton = new JButton("退出");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(1);
            }
        });
        windowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
            }
        });
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                super.windowClosing(e);
                System.exit(0);
            }
        });
        fullsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                /**
                 * 第一种方法
                 */
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                //通过调用GraphicsEnvironment的getDefaultScreenDevice方法获得当前的屏幕设备了
                GraphicsDevice gd = ge.getDefaultScreenDevice();
                // 全屏设置
                gd.setFullScreenWindow(jframe);

                /**
                 * 第二种方法
                 */
                /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                 Rectangle bounds = new Rectangle(screenSize);
                 jframe.setBounds(bounds);*/
            }
        });
        jframe.add(fullsButton);
        jframe.add(exitButton);
        jframe.add(windowButton);
        jframe.setLayout(new FlowLayout());
        jframe.setSize(400, 300);
        jframe.setUndecorated(true);
        jframe.setVisible(true);
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                new FullScreen1();
            }
        });
    }
}