package ua.com.amicablesoft.android.core.utils;

import java.math.BigDecimal;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 12/5/14.
 */
public final class UtilsBigDecimal {

    public static boolean equals(BigDecimal first, BigDecimal second) {
        if (first == second)
            return true;

        if (first != null && second != null && first.equals(second))
            return true;

        return false;
    }

    private UtilsBigDecimal() {}
}
