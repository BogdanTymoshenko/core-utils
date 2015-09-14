package ua.com.amicablesoft.android.core.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 1/7/15.
 */
public final class UtilsGCM {

    private static final String TAG = UtilsGCM.class.getSimpleName();

    public static RegId performRegistration(Context ctx, @StringRes int senderIdRes) throws IOException {
        String currentRegId = GCMRegistrationDataHolder.getRegistrationId(ctx, ctx.getString(senderIdRes));
        String regId = doRegistration(ctx, ctx.getString(senderIdRes));

        RegId result = new RegId();
        result.setRegId(regId);
        if (!UtilsObject.equals(currentRegId, regId))
            result.setPreviouslyRegId(currentRegId);
        return result;
    }

    @Deprecated
    public static String doRegistration(Context ctx, @StringRes int senderIdRes) throws IOException {
        return doRegistration(ctx, ctx.getString(senderIdRes));
    }

    @Deprecated
    public static String doRegistration(Context ctx, String senderId) throws IOException {
        String regId = getRegistrationId(ctx, senderId);
        if (TextUtils.isEmpty(regId)) {
            Context appContext = ctx.getApplicationContext();

            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(appContext);
            regId = gcm.register(senderId);
            GCMRegistrationDataHolder.saveRegistrationInfo(appContext, senderId, regId, UtilsApp.getAppVersion(appContext));
        }

        return regId;
    }

    public static void clear(Context context, @StringRes int senderId) throws IOException {
        clear(context, context.getString(senderId));
    }

    public static void clear(Context context, String senderId) throws IOException {
        GCMRegistrationDataHolder.clearRegistrationInfo(context, senderId);
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(context);
        gcm.unregister();
    }


    private static String getRegistrationId(Context ctx, String senderId) {
        Context appContext = ctx.getApplicationContext();

        String registrationId = GCMRegistrationDataHolder.getRegistrationId(appContext, senderId);
        if (TextUtils.isEmpty(registrationId)) {
            Log.i(TAG, "GCM registration ID not found.");
            return null;
        }

        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = GCMRegistrationDataHolder.getRegistrationAppVersion(appContext, senderId);
        int currentVersion = UtilsApp.getAppVersion(appContext);
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "GCM registration app version changed.");
            return null;
        }

        return registrationId;
    }

    private UtilsGCM() {}
}
