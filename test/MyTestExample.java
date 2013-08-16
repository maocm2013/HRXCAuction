
import com.hrxc.auction.domain.GoodsList;
import com.hrxc.auction.util.Configuration;
import com.hrxc.auction.util.JdbcUtil;
import com.hrxc.auction.util.MD5;
import com.hrxc.auction.util.MyBatisUtils;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author user
 */
public class MyTestExample {
    private static final Logger log = Logger.getLogger(MyTestExample.class);

    @Before
    public void init() throws Exception {
        //初始化log4j
        Configuration.initLog4j();
    }

    //@Test
    public void testMd5() {
        MD5 md5 = new MD5();
        log.debug(md5.encryptMD5("123456"));
    }

    //@Test
    public void testDerbyJdbc() {
        Connection conn = null;
        try {
            conn = JdbcUtil.getConn();
            conn.close();
        } catch (Exception ex) {
            log.debug("error:", ex);
        }
    }

    //@Test
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
            log.debug("Created file: " + outFileName);
        } catch (JRException e) {
            log.debug("error:", e);
        }
    }

    @Test
    public void testMybatis() throws SQLException {
        GoodsList goods = new GoodsList();
        goods.setProjectNo("20130728-001");
        MyBatisUtils.insert("GoodsList.insertObject", new String(""));
        //List list = MyBatisUtils.selectList("GoodsList.getAllObjectInfo", goods);
        //log.debug("list.size=" + list.size());
    }
}
