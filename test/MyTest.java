
import com.hrxc.auction.util.MD5;
import org.junit.Test;

/**
 *
 * @author user
 */
public class MyTest {
    @Test
    public void testMd5(){
        MD5 md5 = new MD5();
        System.out.println(md5.encryptMD5("123456"));
    }
}
