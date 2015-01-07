package ua.com.amicablesoft.android.core.utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 15.12.14.
 */
public final class UtilsThread {

    public static void sleepSafe(long period, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(period);
        }
        catch (InterruptedException ignored) {}
    }


    private UtilsThread() {}
}
