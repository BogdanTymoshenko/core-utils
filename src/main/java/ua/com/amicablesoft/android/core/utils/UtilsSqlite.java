package ua.com.amicablesoft.android.core.utils;

import android.database.Cursor;
import android.util.Log;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 09.12.14.
 */
public final class UtilsSqlite {

    private static final String TAG = UtilsSqlite.class.getSimpleName();


    public static int readInt(Cursor c, String columnName, int defaultValue) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1) {
            Log.e(TAG, "Fail to read column int value - column "+columnName+" not found.");
            return defaultValue;
        }

        if (c.isNull(columnIdx))
            return defaultValue;

        return c.getInt(columnIdx);
    }

    public static Integer readInteger(Cursor c, String columnName) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1) {
            Log.e(TAG, "Fail to read column integer value - column "+columnName+" not found.");
            return null;
        }

        if (c.isNull(columnIdx))
            return null;

        return c.getInt(columnIdx);
    }

    public static String readString(Cursor c, String columnName) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1) {
            Log.e(TAG, "Fail to read column string value - column "+columnName+" not found.");
            return null;
        }

        if (c.isNull(columnIdx))
            return null;

        return c.getString(columnIdx);
    }

    public static BigDecimal readBigDecimal(Cursor c, String columnName) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1 ) {
            Log.e(TAG, "Fail to read column big decimal value - column "+columnName+" not found.");
            return null;
        }

        if (c.isNull(columnIdx))
            return null;

        return new BigDecimal(c.getDouble(columnIdx));
    }

    public static Boolean readBoolean(Cursor c, String columnName) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1) {
            Log.e(TAG, "Fail to read column boolean value - column "+columnName+" not found.");
            return null;
        }

        if (c.isNull(columnIdx))
            return null;

        return c.getInt(columnIdx) > 0;
    }

    public static long readLong(Cursor c, String columnName, long defaultValue) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1) {
            Log.e(TAG, "Fail to read column long value - column "+columnName+" not found.");
            return defaultValue;
        }

        if (c.isNull(columnIdx))
            return defaultValue;

        return c.getLong(columnIdx);
    }

    public static Long readLong(Cursor c, String columnName, Long defaultValue) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1) {
            Log.e(TAG, "Fail to read column Long value - column "+columnName+" not found.");
            return defaultValue;
        }

        if (c.isNull(columnIdx))
            return defaultValue;

        return c.getLong(columnIdx);
    }

    public static Long readLong(Cursor c, String columnName) {
        return readLong(c, columnName, null);
    }

    public static Date readDate(Cursor c, String columnName) {
        Long timestamp = readLong(c, columnName);
        return timestamp != null ? new Date(timestamp) : null;
    }


    public static Long writeDate(Date date) {
        if (date == null)
            return null;

        return date.getTime();
    }

    public static Boolean isNull(Cursor c, String columnName) {
        int columnIdx = c.getColumnIndex(columnName);
        if (columnIdx == -1) {
            Log.e(TAG, "Fail to check is column NULL - column "+columnName+" not found.");
            return null;
        }

        return c.isNull(columnIdx);
    }


    private UtilsSqlite() {}
}
