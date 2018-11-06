package br.com.digitalhouse.moviemvvm.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtil {

    // Verifica se temos conexão com internet
    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo;

        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected() &&
                    (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                            || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE);
        }
        return false;
    }
}
