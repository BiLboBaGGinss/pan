package com.pan.project.system.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author : Pan Yanqing
 * @description :
 * @date : 2022-11-16 14:42
 */
public class MD5Util {
    private static final String SALT = "shenyou@1996";

    /**
     * md5加密
     * @param src 传入字符串
     * @return 加密后信息
     */
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     * 前端传入后端时第一次加密(这边加 “” 的原因是前端需要加空格)
     * @param inputPass 传入的明文
     * @return 第一次加密信息
     */
    public static String inputPassToFromPass(String inputPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(6) + salt.charAt(5);
        return md5(str);
    }

    /**
     * 往数据库存入时第二次加密(这边加 “” 的原因是前端需要加空格)
     * @param formPass 第一次加密后的数据
     * @return 第二次加密信息
     */
    public static String fromPassToDbPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(6) + salt.charAt(5);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass, salt);
        return fromPassToDbPass(fromPass, salt);
    }
}
