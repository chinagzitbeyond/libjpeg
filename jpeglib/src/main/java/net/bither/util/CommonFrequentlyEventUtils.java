package net.bither.util;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class CommonFrequentlyEventUtils {

    private static Map<String, Long> records = new HashMap<>();
    /**
     * @deprecated 是否频繁点击
     * @param delayTime
     * @return boolean
     */
    public static boolean frequentlyClickMethod(int delayTime) {

            if (records.size() > 1000) {
                records.clear();
            }
            //本方法被调用的文件名和行号作为标记
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String key = ste.getFileName() + ste.getLineNumber();
            if(!TextUtils.isEmpty(key)){
                Long lastClickTime = records.get(key);
                long thisClickTime = System.currentTimeMillis();
                records.put(key, thisClickTime);
                if (lastClickTime == null) {
                    lastClickTime = 0L;
                }
                long timeDuration = thisClickTime - lastClickTime;
                return 0 < timeDuration && timeDuration < delayTime;
            }else{
                return false;
            }

    }

}
