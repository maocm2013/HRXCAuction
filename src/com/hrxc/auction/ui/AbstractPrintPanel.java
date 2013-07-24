package com.hrxc.auction.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 * 打印输出专用JPanel
 * @author user
 */
public abstract class AbstractPrintPanel extends JPanel implements Printable {
    private static final Logger log = Logger.getLogger(AbstractPrintPanel.class);
    @Override
    public void paintComponent(Graphics g) {
        log.debug("AbstractPrintPanel.paintComponent");
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawPage(g2);
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        log.debug("AbstractPrintPanel.print");
        if (page >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pf.getImageableX(), pf.getImageableY());
        drawPage(g2); 
        return Printable.PAGE_EXISTS;
    }

    public abstract void drawPage(Graphics2D g2);
}
