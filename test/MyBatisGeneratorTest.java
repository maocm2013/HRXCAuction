
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.ibatis.io.Resources;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 *
 * @author user
 */
public class MyBatisGeneratorTest {

    @Test
    public void generatorMybatis() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException, Exception {
        com.hrxc.auction.util.Configuration.initLog4j();
        
        ArrayList<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        String resource = "mybatis-generator-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(reader);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
