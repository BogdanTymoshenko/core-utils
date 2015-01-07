package ua.com.amicablesoft.android.core.utils;

import android.content.Context;

/**
* Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 12/7/14.
*/
class GCMRegistrationDataHolder {

    private static final String PREFERENCES_NAME = "gcm.registration";
    private static final String KEY__REGISTRATION_ID = "gcm.registration.registration_id";
    private static final String KEY__APP_VERSION = "gcm.registration.app_version";


    public static String getRegistrationId(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).getString(KEY__REGISTRATION_ID, null);
    }

    public static int getRegistrationAppVersion(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).getInt(KEY__APP_VERSION, -1);
    }

    public static void saveRegistrationInfo(Context ctx, String regId, int appVersion) {
        ctx.getApplicationContext().getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit()
                .putString(KEY__REGISTRATION_ID, regId)
                .putInt(KEY__APP_VERSION, appVersion)
                .commit();
    }

}
