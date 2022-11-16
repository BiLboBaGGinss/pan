package com.pan.project.system.utils;

import java.util.Random;

/**
 * @author : Pan Yanqing
 * @description : 随机盐生成工具类
 * @date : 2022-11-16 15:14
 */
public class SaltUtils {
    public static String getsalt(int n) {
        char[] chars = "bakfbaowbfjkabofbaCCUVUIVIWDKV%$&^%*&*%$1131415".toCharArray(); //转换为字符数组
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = chars[new Random().nextInt(chars.length)];
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
