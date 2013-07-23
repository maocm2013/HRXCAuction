
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public abstract class PrintUtil implements Printable
{
     public static void print(Component com) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Maxim 1");
        job.setPrintable((Printable) com);
        try {
            job.print();
        } catch (PrinterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void printPreview(Frame p, Component com) {
        PrintPreviewDialog pd = new PrintPreviewDialog(p, "print Preview", true, com);
        pd.setSize(800, 600);
        pd.setVisible(true);
    }

    public static int printAble(Component c, Graphics g, PageFormat pageFormat, int pageIndex) {
        if (pageIndex == 0) {
            Dimension prefSize = c.getPreferredSize();
            c.setSize(prefSize);
            c.validate();
            double ratio = pageFormat.getImageableWidth() / prefSize.width;
            Graphics2D g2d = (Graphics2D) g;
            // translate origin toimageable origin
            g2d.transform(AffineTransform.getTranslateInstance(pageFormat
                    .getImageableX(), pageFormat.getImageableY()));
            // // scale output
            g2d.transform(AffineTransform.getScaleInstance(ratio, ratio));
            c.printAll(g2d);
            return PAGE_EXISTS;
        }
        return NO_SUCH_PAGE;

    }
}
