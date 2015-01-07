package ua.com.amicablesoft.android.core.utils;

import android.text.TextUtils;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 04.12.14.
 */
public final class UtilsFormat {

    public static String formatAddress(String name, String houseNumber) {
        return formatAddress(name, houseNumber, null);
    }

    public static String formatAddress(String name, String houseNumber, String entranceNumber) {
        if (TextUtils.isEmpty(name))
            return "";

        StringBuilder result = new StringBuilder(name);

        if (!TextUtils.isEmpty(houseNumber))
            result.append(" ").append(houseNumber);

        if (!TextUtils.isEmpty(entranceNumber))
            result.append(" п.").append(entranceNumber);

        return result.toString();
    }

    private UtilsFormat() {}
}
