
import com.hrxc.auction.domain.GoodsList;
import com.hrxc.auction.util.Configuration;
import com.hrxc.auction.util.JdbcUtil;
import com.hrxc.auction.util.MD5;
import com.hrxc.auction.util.MyBatisUtils;
import com.hrxc.auction.util.MyTableConfig;
import com.hrxc.auction.util.MyTableModel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.ibatis.session.SqlSession;
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
            conn = JdbcUtil.getInstance().getSession().getConnection();
            conn.close();
        } catch (Exception ex) {
            log.debug("error:", ex);
        }
    }

    @Test
    public void testReport() throws InterruptedException, SQLException {
        String rootPath = System.getProperty("user.dir").concat(File.separator).concat("config").concat(File.separator);

        String fileName = rootPath + "bargainRecordCollectReport.jasper";
        String outFileName = "E:\\my_workspace\\nb_project\\HRXCAuction\\config\\bargainRecordCollectReport.xls";
        //设置参数
        HashMap hm = new HashMap();
        hm.put("t_projectNo", "20130901-001");
        try {
            JasperPrint print = JasperFillManager.fillReport(
                    fileName,
                    hm,
                    JdbcUtil.getInstance().getSession().getConnection());


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

    //@Test
    public void testMybatis() throws SQLException {
        GoodsList goods = new GoodsList();
        goods.setProjectNo("20130728-001");
        MyBatisUtils.insert("GoodsList.insertObject", new String(""));
        //List list = MyBatisUtils.selectList("GoodsList.getAllObjectInfo", goods);
        //log.debug("list.size=" + list.size());
    }

    /**
     * 生产mybatis配置文件
     */
    //@Test
    public void generateMyBatisMapper() throws SQLException {
        String pkIdProp = "pkId";
        String tableName = "PROJECT_INFO";
        String domainName = "ProjectInfo";

        SqlSession session = JdbcUtil.getInstance().getSession();
        PreparedStatement ps = session.getConnection().prepareStatement("select * from " + tableName);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rm = rs.getMetaData();
        String[] cols = new String[rm.getColumnCount()];
        for (int c = 1; c <= cols.length; c++) {
            cols[c - 1] = rm.getColumnName(c);
        }
        session.close();


        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \n"
                + "\"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"> \n");
        sb.append("<mapper namespace=\"@DOMAIN@\"> \n");

        sb.append(" <resultMap type=\"com.hrxc.auction.domain.vo.@DOMAIN@Vo\" id=\"@DOMAIN@ResultMap\"> \n");
        for (int i = 0; i < cols.length; i++) {
            sb.append("<result column=\"").append(cols[i]).append("\" property=\"").append(column2Property(cols[i])).append("\"></result> \n");
        }
        sb.append("</resultMap> \n\n");

        sb.append("<select id=\"getAllObjectInfo\" resultMap=\"@DOMAIN@ResultMap\" parameterType=\"@DOMAIN@Vo\"> \n");
        sb.append("SELECT \n");
        for (int i = 0; i < cols.length; i++) {
            if (i == cols.length - 1) {
                sb.append(cols[i]).append(" \n");
            } else {
                sb.append(cols[i]).append(", \n");
            }
        }
        sb.append("FROM @TABLE@ \n");
        sb.append("<where> \n");
        for (int i = 0; i < cols.length; i++) {
            sb.append("<if test=\"").append(column2Property(cols[i])).append("!= null\"> and ").append(column2Property(cols[i])).append(" != ''\">\n");
            sb.append("AND ").append(cols[i]).append("=#{").append(column2Property(cols[i])).append("} \n");
            sb.append("</if> \n");
        }
        sb.append("</where> \n");
        sb.append("</select> \n\n");

        sb.append("<insert id=\"insertObject\" parameterType=\"@DOMAIN@\"> \n");
        sb.append("INSERT INTO @TABLE@(");
        for (int i = 0; i < cols.length; i++) {
            if (i == cols.length - 1) {
                sb.append(cols[i]);
            } else {
                sb.append(cols[i]).append(",");
            }
        }

        sb.append(") \n VALUES (");
        for (int i = 0; i < cols.length; i++) {
            if (i == cols.length - 1) {
                sb.append("#{").append(column2Property(cols[i])).append("}");
            } else {
                sb.append("#{").append(column2Property(cols[i])).append("}").append(",");
            }
        }
        sb.append(") \n");
        sb.append("</insert> \n\n");

        sb.append("<delete id=\"deleteObjectById\" parameterType=\"string\"> \n");
        sb.append("DELETE FROM @TABLE@ WHERE PK_ID=#{pkId} \n");
        sb.append("</delete> \n\n");

        sb.append("<update id=\"updateObjectById\" parameterType=\"@DOMAIN@\"> \n");
        sb.append("UPDATE @TABLE@ \n");
        sb.append("<set> \n");
        for (int i = 0; i < cols.length; i++) {
            if (!column2Property(cols[i]).equalsIgnoreCase(pkIdProp)) {
                sb.append("<if test=\"").append(column2Property(cols[i])).append(" != null\"> \n");
                sb.append(cols[i]).append(" = #{").append(column2Property(cols[i])).append("}, \n");
                sb.append("</if> \n");
            }
        }
        sb.append("</set> \n");
        sb.append("WHERE PK_ID=#{pkId} \n");
        sb.append("</update> \n");
        sb.append("</mapper> \n");

        //替换表名及domain名称
        String str = sb.toString();
        str = str.replaceAll("@TABLE@", tableName);
        str = str.replaceAll("@DOMAIN@", domainName);
        System.out.println("---------mapper output--------------------\n" + str);
    }

    /**
     * <p>将数据库字段名替换为属性名</p>
     * TODO：该函数只支持一个_的情况！！
     *
     * @param col
     * @return
     */
    private String column2Property(String col) {
        String property = "";
        int i = col.indexOf("_");
        if (i > 0) {
            property = col.substring(0, i).toLowerCase();
            property += col.substring(i + 1, i + 2).toUpperCase();
            property += col.substring(i + 2).toLowerCase();
        } else {
            property = col.toLowerCase();
        }    
        return property;
    }
    
    //@Test
    public void simpleTest(){
        System.out.println(DateFormatUtils.format(new java.util.Date(), "yyyyMMddHHmmss"));
    }
}
