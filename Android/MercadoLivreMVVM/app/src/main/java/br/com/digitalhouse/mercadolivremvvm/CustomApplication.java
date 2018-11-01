package br.com.digitalhouse.mercadolivremvvm;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Se estamos em modo Debug habilitamos o Stetho para conseguirmos ver nossas requisições no google chrome
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }
}
