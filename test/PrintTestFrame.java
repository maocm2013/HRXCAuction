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
            drawList(g2);
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
            drawList(g2);
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

        private void drawPaddle(Graphics2D g2) {
            Font titleFont = new Font("黑体", Font.PLAIN, 14);

            AttributedString ats =
                    new AttributedString("北京华软信诚拍卖行有限公司竞买号牌登记表");
            ats.addAttribute(TextAttribute.FONT, titleFont);
            g2.drawString(ats.getIterator(), 60, 20);

            g2.drawString("竞买人姓名：王三", 10, 40);
            g2.drawString("竞买号牌：102", 200, 40);

            g2.drawString("证件名称：身份证", 10, 60);
            g2.drawString("证件号码：410323198303094512", 200, 60);

            g2.drawString("联系方式：18601020269", 10, 80);

            g2.drawString("通讯地址：北京市海淀区农大南路33好中电大厦", 10, 100);

            g2.drawString("保证金（元）：￥500", 10, 120);

            g2.drawString("竞买人签字：", 200, 140);
            g2.drawString("日期：", 200, 160);
        }
    }

    private void drawList(Graphics2D g2) {
        Font titleFont_14 = new Font("黑体", Font.PLAIN, 14);
        Font titleFont_20 = new Font("黑体", Font.PLAIN, 20);

        AttributedString ats =
                new AttributedString("北京华软信诚拍卖行有限公司");
        ats.addAttribute(TextAttribute.FONT, titleFont_14);
        g2.drawString(ats.getIterator(), 160, 20);
        ats =
                new AttributedString("结  款  单");
        ats.addAttribute(TextAttribute.FONT, titleFont_20);
        g2.drawString(ats.getIterator(), 200, 40);


        g2.drawString("竞买人姓名：王三", 10, 60);
        g2.drawString("证件号码：410323198303094512", 150, 60);
        g2.drawString("竞买号牌：102", 360, 60);

        g2.drawRect(5, 65, 520, 400);

        g2.drawString("阁下您好：", 10, 80);
        g2.drawString("您已竞得如下拍品，请认真核对以下信息，并交纳相关费用。", 30, 100);

        //输出列表数据
        int y_coord = 120;
        int x_coord_paddleNo = 10;
        int x_coord_paddleName = 50;
        int x_coord_hammerPrice = 250;
        int x_coord_commission = 320;
        int x_coord_otherFund = 380;
        int x_coord_bargainPrice = 460;
        g2.drawString("图录号", x_coord_paddleNo, y_coord);
        g2.drawString("名称", x_coord_paddleName, y_coord);
        g2.drawString("落锤价（元）", x_coord_hammerPrice, y_coord);
        g2.drawString("佣金（元）", x_coord_commission, y_coord);
        g2.drawString("其他费用（元）", x_coord_otherFund, y_coord);
        g2.drawString("合计（元）", x_coord_bargainPrice, y_coord);

        for (int i = 0; i < 10; i++) {
            y_coord = y_coord + 20;
            g2.drawString("151", x_coord_paddleNo, y_coord);
            g2.drawString("太阳石108佛珠蓝玉髓隔珠、紫水晶", x_coord_paddleName, y_coord);
            g2.drawString("5000", x_coord_hammerPrice, y_coord);
            g2.drawString("500", x_coord_commission, y_coord);
            g2.drawString("", x_coord_otherFund, y_coord);
            g2.drawString("5500", x_coord_bargainPrice, y_coord);
        }

        g2.drawString("合计件数：3", 10, 480);
        g2.drawString("总金额：25300", 150, 480);
        g2.drawString("竞买人签字：", 360, 480);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new PrintTestFrame().setVisible(true);

            }
        });

    }
}
