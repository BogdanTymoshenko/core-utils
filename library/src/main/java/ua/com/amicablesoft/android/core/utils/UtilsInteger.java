package ua.com.amicablesoft.android.core.utils;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 12/19/14.
 */
public final class UtilsInteger {

    public static boolean equals(Integer a, Integer b) {
        if (a == null && b == null)
            return true;

        if (a != null && b != null && a.equals(b))
            return true;

        return false;
    }

    private UtilsInteger() {}
}
