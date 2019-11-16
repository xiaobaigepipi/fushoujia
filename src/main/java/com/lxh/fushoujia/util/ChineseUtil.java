package com.lxh.fushoujia.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.ibatis.annotations.Param;
import sun.applet.Main;

/*
 * @PackageName: com.lxh.fushoujia.util
 * @ClassName: ChineseUtil
 * @Description: 汉字取首字母
 * @author: 辉
 * @date: 2019/11/7 14:45
 * */
public class ChineseUtil {

    /*
     * @Author 辉
     * @Description //TODO
     * @Date 14:47 2019/11/7
     * @Param c: 汉字
     * @return 返回首字母
     **/
    public static String convertChinese(char c) {
        //输出格式设置
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        /**
         * 输出大小写设置
         *
         * LOWERCASE:输出小写
         * UPPERCASE:输出大写
         */
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);

        /**
         * 输出音标设置
         *
         * WITH_TONE_MARK:直接用音标符（必须设置WITH_U_UNICODE，否则会抛出异常）
         * WITH_TONE_NUMBER：1-4数字表示音标
         * WITHOUT_TONE：没有音标
         */
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        /**
         * 特殊音标ü设置
         *
         * WITH_V：用v表示ü
         * WITH_U_AND_COLON：用"u:"表示ü
         * WITH_U_UNICODE：直接用ü
         */
        //format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

        String[] res;
        StringBuffer sb = new StringBuffer();
        try {
            res = PinyinHelper.toHanyuPinyinStringArray(c, format);
            //取多音字的第一个
            sb.append(res[0]);
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
            return "";
        }
        return sb.toString();
    }

    public static String getFirstPinyin(String hanzi) {
        if (hanzi.equals("") || hanzi.length() == 0) {
            return "FSJ";
        }
        char[] cs = hanzi.toCharArray();
        StringBuffer sf = new StringBuffer();

        /***
         * ^[\u2E80-\u9FFF]+$ 匹配所有东亚区的语言
         * ^[\u4E00-\u9FFF]+$ 匹配简体和繁体
         * ^[\u4E00-\u9FA5]+$ 匹配简体
         */
        for (int i = 0; i < cs.length; i++) {
            //判断是否是汉字
            if (Character.toString(cs[i]).matches("[\\u4E00-\\u9FFF]+$")) {
                sf.append(convertChinese(cs[i]).charAt(0));
            } else {
                sf.append(cs[i]);
            }
        }
        return sf.toString();
    }

    public static void main(String[] args) {
        System.out.println(getFirstPinyin("濬大家啊djjj"));
    }
}










