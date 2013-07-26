
import com.hrxc.auction.util.JdbcUtil;
import com.hrxc.auction.util.MD5;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.junit.Test;

/**
 *
 * @author user
 */
public class MyTest {
    //@Test

    public void testMd5() {
        MD5 md5 = new MD5();
        System.out.println(md5.encryptMD5("123456"));
    }

    @Test
    public void testReport() throws InterruptedException, SQLException {
        String rootPath = System.getProperty("user.dir").concat(File.separator).concat("config").concat(File.separator);

        String fileName = rootPath + "bargainRecordCollectReport.jasper";
        String outFileName = "E:\\nb_project\\HRXCAuction\\dist\\bargainRecordCollectReport.xls";
        HashMap hm = new HashMap();
        try {
            JasperPrint print = JasperFillManager.fillReport(
                    fileName,
                    hm,
                    JdbcUtil.getConn());


            //将报表数据输出至JFrame
            JRGraphics2DExporter exporter_gui = new JRGraphics2DExporter();
            JFrame frame = new JFrame("Report Preview");
            frame.setPreferredSize(new Dimension(640, 480));
            frame.setResizable(false);
            frame.setVisible(true);
            frame.pack();

            exporter_gui.setParameter(
                    JRGraphics2DExporterParameter.GRAPHICS_2D,
                    (Graphics2D) frame.getGraphics());
            exporter_gui.setParameter(
                    JRExporterParameter.JASPER_PRINT, print);
            exporter_gui.exportReport();

            //将报表数据输出至Excel中
            JRXlsExporter exporter_xls = new JRXlsExporter();
            exporter_xls.setParameter(
                    JRXlsExporterParameter.OUTPUT_FILE_NAME,
                    outFileName);
            exporter_xls.setParameter(
                    JRExporterParameter.JASPER_PRINT, print);
            exporter_xls.exportReport();

            Thread.sleep(1000 * 10);
            System.out.println("Created file: " + outFileName);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
