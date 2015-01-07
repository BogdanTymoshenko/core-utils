package ua.com.amicablesoft.android.core.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Bogdan Tymoshenko <bogdan.tymoshenko@gmail.com> on 18.12.14.
 */
public final class UtilsConnection {

    public enum LocationConnectionStatus {
        AVAILABLE,
        DISABLED,
        MISSING
    }

    public static boolean isNetworkConnected(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetInfo != null && activeNetInfo.isConnected();
    }

    public static LocationConnectionStatus locationConnectedStatus(Context ctx) {
        boolean hasGps = ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
        if (hasGps) {
            LocationManager manager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
            return manager.isProviderEnabled(LocationManager.GPS_PROVIDER) ? LocationConnectionStatus.AVAILABLE : LocationConnectionStatus.DISABLED;
        }

        boolean hasNetwork = ctx.getPackageManager().hasSystemFeature(PackageManager.FEATURE_LOCATION_NETWORK);
        if (hasNetwork) {
            LocationManager manager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
            return manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ? LocationConnectionStatus.AVAILABLE : LocationConnectionStatus.DISABLED;
        }

        return LocationConnectionStatus.MISSING;
    }


    private UtilsConnection() {}
}
