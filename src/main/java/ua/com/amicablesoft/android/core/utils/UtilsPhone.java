package ua.com.amicablesoft.android.core.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 28.11.14.
 */
public final class UtilsPhone {

    @Nullable
    public static final String readDevicePhoneNumber(@NonNull Context ctx) {
        TelephonyManager telephonyManager = (TelephonyManager)ctx.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = telephonyManager.getLine1Number();
        return TextUtils.isEmpty(phoneNumber) ? null : phoneNumber;
    }

    private UtilsPhone() {}
}
