package com.hrxc.auction.util;

import java.security.MessageDigest;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author user
 */
public class MD5 {

    private static final Logger log = Logger.getLogger(MD5.class);

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    private String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public String encryptMD5(String data) {
        String ret = "";
        try {
            String base64Str = encryptBASE64(data.getBytes("UTF-8"));

            char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
            byte[] strTemp = base64Str.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            ret = new String(str).toUpperCase();
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return ret;
    }
}
