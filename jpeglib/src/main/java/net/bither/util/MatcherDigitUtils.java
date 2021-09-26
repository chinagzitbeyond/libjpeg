package net.bither.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherDigitUtils {

    /**
     * 用正则表达式判断字符串是否是数字
     * @param param
     * @return
     */
    public static boolean isDigitMethod(String param){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(param);
        if( !isNum.matches() ){
            return false;
        }
        return true;

    }

}
