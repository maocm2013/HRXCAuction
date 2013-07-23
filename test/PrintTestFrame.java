/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

import java.awt.event.*;
import java.awt.font.TextAttribute;

import java.awt.geom.*;

import java.awt.print.*;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.print.attribute.*;

import javax.swing.*;

/**
 *
 * @author user
 */
public class PrintTestFrame extends javax.swing.JFrame {

    private PrintPanel canvas;
    private PrintRequestAttributeSet attributes;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public PrintTestFrame() {

        //initComponents();

        setTitle("PrintTest");

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        this.setLayout(new BorderLayout());

        canvas = new PrintPanel();

        this.getContentPane().add(canvas, BorderLayout.CENTER);

        attributes = new HashPrintRequestAttributeSet();

        JPanel buttonPanel = new JPanel();

        JButton printButton = new JButton("Print");

        buttonPanel.add(printButton);

        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                try {

                    PrinterJob job = PrinterJob.getPrinterJob();

                    job.setPrintable(canvas);

                    if (job.printDialog(attributes)) {
                        job.print(attributes);
                    }

                } catch (PrinterException e) {

                    JOptionPane.showMessageDialog(PrintTestFrame.this, e);

                }

            }
        });

        JButton pageSetupButton = new JButton("Page setup");

        buttonPanel.add(pageSetupButton);

        pageSetupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                PrinterJob job = PrinterJob.getPrinterJob();

                job.pageDialog(attributes);

            }
        });

        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);

    }

    class PrintPanel extends JPanel implements Printable {

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;

            drawPage(g2);    //相当于在窗体上预览打印结果

        }

        public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

            if (page >= 1) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) g;

            g2.translate(pf.getImageableX(), pf.getImageableY());

            // g2.draw(new Rectangle2D.Double(0, 0, pf.getImageableWidth(), pf.getImageableHeight()));   //整个纸张的外边框



            drawPage(g2, pf.getImageableWidth(), pf.getImageableHeight());  //打印

            return Printable.PAGE_EXISTS;

        }

        public void drawPage(Graphics2D g2, double width, double height) {
            drawDoc(g2);
//            g2.draw(new Rectangle2D.Double(0, 0, width / 2, 20));  //起点（x,y），宽，高
//
//            g2.draw(new Rectangle2D.Double(width / 2, 0, width / 2, 20));
//
//            g2.draw(new Rectangle2D.Double(0, 20, width, 20));
//
//            g2.drawString("你好，中国！", 1, 15);   //x,y
//
//            g2.drawString("天气很晴朗", (int) width / 2, 15);

        }

        public void drawPage(Graphics2D g2) {
            drawDoc(g2);
//            g2.draw(new Rectangle2D.Double(0, 0, 150, 20));  //起点（x,y），宽，高
//
//            g2.draw(new Rectangle2D.Double(150, 0, 150, 20));
//
//            g2.draw(new Rectangle2D.Double(0, 20, 300, 20));
//
//            g2.drawString("你好，中国！", 1, 15);   //x,y
//
//            g2.drawString("天气很晴朗", 151, 15);

        }

        private void drawDoc(Graphics2D g2) {

            Font font1 = new Font("黑体", Font.PLAIN, 14);
            Font font2 = new Font("宋体", Font.PLAIN, 12);

            AttributedString ats =
                    new AttributedString("北京华软信诚拍卖行有限公司竞买号牌登记表");
            ats.addAttribute(TextAttribute.FONT, font1);
            g2.drawString(ats.getIterator(), 60, 20);

            ats = new AttributedString("竞买人姓名：");
            ats.addAttribute(TextAttribute.FONT, font2);
            ats.addAttribute(TextAttribute.RUN_DIRECTION, TextAttribute.RUN_DIRECTION_RTL);
            g2.drawString(ats.getIterator(), 10, 40);

            ats = new AttributedString("王三");
            ats.addAttribute(TextAttribute.FONT, font2);
            ats.addAttribute(TextAttribute.RUN_DIRECTION, TextAttribute.RUN_DIRECTION_LTR);
            g2.drawString(ats.getIterator(), 90, 40);

            g2.drawString("竞买号牌：102", 200, 40);
            g2.drawString("证件名称：身份证", 10, 60);
            g2.drawString("证件号码：410323198303094512", 200, 60);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new PrintTestFrame().setVisible(true);

            }
        });

    }
}
