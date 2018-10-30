package br.com.digitalhouse.mercadolivremvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import br.com.digitalhouse.mercadolivremvvm.data.local.MercadoLivreLocalRepository;
import br.com.digitalhouse.mercadolivremvvm.data.network.MercadoLivreRemoteRepository;
import br.com.digitalhouse.mercadolivremvvm.model.MercadoLivreResponse;
import br.com.digitalhouse.mercadolivremvvm.model.Result;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NewsViewModel extends AndroidViewModel {

    private MutableLiveData<List<Result>> resultLiveData = new MutableLiveData<>();
    private CompositeDisposable disposable = new CompositeDisposable();

    public NewsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Result>> getResultLiveData() {
        return resultLiveData;
    }

    public void getNews(String item) {
        if (isNetworkConnected(getApplication())) {
            getFromNetwork(item);
        } else {
            getFromLocal();
        }
    }

    private void getFromLocal() {
        MercadoLivreLocalRepository localRepository = new MercadoLivreLocalRepository();

        disposable.add(localRepository.getLocalNews(getApplication().getApplicationContext())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                    resultLiveData.setValue(results);
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }

    private void getFromNetwork(String item) {
        MercadoLivreRemoteRepository remoteRepository = new MercadoLivreRemoteRepository();

        disposable.add(remoteRepository.searchItems(item)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsResponse -> {
                    resultLiveData.setValue(newsResponse.getResults());
                }, throwable -> {
                    Log.i("LOG", "Error: " + throwable.getMessage());
                }));
    }

    private boolean isNetworkConnected(Context context) {
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
