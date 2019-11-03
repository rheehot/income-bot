package com.jojoldu.incomebot.batch.util;

import java.text.NumberFormat;

/**
 * Created by jojoldu@gmail.com on 28/10/2019
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class NumberUtils {
    public static String toAbsCommaNumber(Long number) {
        return toCommaNumber(toAbs(number));
    }

    public static String toCommaNumber(Long number) {
        return NumberFormat.getInstance().format(number);
    }

    public static Long toAbs(Long number) {
        return Math.abs(number);
    }
}
