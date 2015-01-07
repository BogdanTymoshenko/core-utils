package ua.com.amicablesoft.android.core.utils;

import android.text.TextUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 22.12.14.
 */
public final class UtilsString {

    public static String join(Collection collection) {
        StringBuilder result = new StringBuilder();

        for (Object item : collection) {
            if (result.length() > 0)
                result.append(",");
            result.append(item.toString());
        }

        return result.toString();
    }

    public static Set<String> split(String joined) {
        if (TextUtils.isEmpty(joined))
            return Collections.EMPTY_SET;

        String spited[] = joined.split(",");
        if (spited == null || spited.length == 0)
            return Collections.EMPTY_SET;

        return new HashSet<>(Arrays.asList(spited));
    }

    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        return new StringBuffer(strLen)
            .append(Character.toTitleCase(str.charAt(0)))
            .append(str.substring(1))
            .toString();
    }


    private UtilsString() {}
}
