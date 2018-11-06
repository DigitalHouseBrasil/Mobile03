package br.com.digitalhouse.moviemvvm;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
