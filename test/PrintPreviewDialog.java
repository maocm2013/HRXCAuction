
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class PrintPreviewDialog extends JDialog implements ActionListener {

    private JButton closeButton = new JButton("Close");
    private JButton printButton = new JButton("Ok! I want to print the current tab.");
    private JPanel buttonPanel = new JPanel();
    private PreviewCanvas canvas;
    private Component c;

    public PrintPreviewDialog(Frame parent, String title, boolean modal, Component pt) {
        super(parent, title, modal);
        this.c = pt;
        canvas = new PreviewCanvas(pt);
        setLayout();
    }

    private void setLayout() {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(canvas, BorderLayout.CENTER);


        closeButton.setMnemonic('N');
        closeButton.addActionListener(this);

        printButton.setMnemonic('N');
        printButton.addActionListener(this);

        buttonPanel.add(closeButton);
        buttonPanel.add(printButton);

        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.setBounds((int) ((Toolkit.getDefaultToolkit().getScreenSize().width - 400) / 2), (int) ((Toolkit.getDefaultToolkit().getScreenSize().height - 400) / 2), 400, 400);
    }

    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (src == closeButton) {
            closeAction();
        } else if (src == printButton) {
            PrintUtil.print(c);
        }
    }

    private void closeAction() {
        this.setVisible(false);
        this.dispose();
    }

    class PreviewCanvas extends JPanel {

        private int currentPage = 0;
        private Component preview;

        public PreviewCanvas(Component pt) {

            preview = pt;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            PageFormat pf = PrinterJob.getPrinterJob().defaultPage();

            double xoff;
            double yoff;
            double scale;
            double px = pf.getWidth();
            double py = pf.getHeight();
            double sx = getWidth() - 1;
            double sy = getHeight() - 1;
            if (px / py < sx / sy) {
                scale = sy / py;
                xoff = 0.5 * (sx - scale * px);
                yoff = 0;
            } else {
                scale = sx / px;
                xoff = 0;
                yoff = 0.5 * (sy - scale * py);
            }
            g2.translate((float) xoff, (float) yoff);
            g2.scale((float) scale, (float) scale);

            Rectangle2D page = new Rectangle2D.Double(0, 0, px, py);
            g2.setPaint(Color.white);
            g2.fill(page);
            g2.setPaint(Color.black);
            g2.draw(page);

            try {
                ((Printable) preview).print(g2, pf, currentPage);
            } catch (PrinterException pe) {
                g2.draw(new Line2D.Double(0, 0, px, py));
                g2.draw(new Line2D.Double(0, px, 0, py));
            }
        }
    }
}
