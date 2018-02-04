package com.spider.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.util.List;
import java.util.Objects;

public final class CommonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    private CommonUtil() {
    }

    public final static Boolean checkStringIsNull(String string) {
        return null == string || string.trim().equals("");
    }

    public final static Boolean checkObjectIsNull(Object obj) {
        try {
            List list = (List) obj;
            if (list.size() <= 0) {
                return true;
            }
        } catch (Exception e) {
            LOGGER.info("check obj is null transfrom list is faile");
        }
        return Objects.equals(null, obj);

    }

    public final static String getEnvValue(String key) {
        if (!checkStringIsNull(key)) {
            String res = System.getenv(key);
            if (!checkStringIsNull(res)) {
                return res;
            }
            LOGGER.info("env not have '" + key + "' value");
            return null;
        }
        LOGGER.info("get env error, key is null");
        return null;
    }

    public final static Boolean checkMapperCudIsSuccess(int res) {
        return res >= 0;
    }

    public final static String MD5(String pwd) {
        char md5String[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = pwd.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = md5String[byte0 >>> 4 & 0xf];
                str[k++] = md5String[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            LOGGER.error("md5 create secret error");
        }
        return null;
    }
}
