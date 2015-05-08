package ua.com.amicablesoft.android.core.utils;

import android.database.Cursor;
import android.util.Log;

import java.io.Closeable;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 18.12.14.
 */
public final class UtilsClosable {

    private static final String TAG = UtilsClosable.class.getSimpleName();


    public static void closeSafe(Closeable closeable) {
        if (closeable != null)
            try {
                if (closeable instanceof Cursor) {
                    ((Cursor)closeable).close();
                }
                else {
                    closeable.close();
                }
            }
            catch (Exception ex) {
                Log.e(TAG, "Error during close call", ex);
            }
    }

    private UtilsClosable() {}
}
